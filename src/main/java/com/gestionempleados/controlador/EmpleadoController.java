package com.gestionempleados.controlador;

import com.gestionempleados.entidades.Empleado;
import com.gestionempleados.servicio.EmpleadoService;
import com.gestionempleados.util.paginacion.PageRender;
import com.gestionempleados.util.reportes.EmpleadoExporterExcel;
import com.gestionempleados.util.reportes.EmpleadoExporterPDF;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/ver/{id}")
    public String verDetallesEmpleado(@PathVariable(value = "id")Long id, Map<String, Object> modelo, RedirectAttributes flash){
        Empleado empleado = empleadoService.findOne(id);
        if(empleado == null){
            flash.addFlashAttribute("error", "El empleado no existe en la base de datos");
            return "redirect:/listar";
        }

        modelo.put("empleado", empleado);
        modelo.put("titulo", "Detalles del empleado");

        return "verEmpleado";
    }

    @GetMapping("/form")
    public String mostrarFormularioRegistrarEmpleado(Map<String, Object> modelo){
        Empleado empleado = new Empleado();

        modelo.put("empleado", empleado);
        modelo.put("titulo", "Registro de Empleado");

        return "formEmpleado";
    }

    @PostMapping("/form")
    public String guardarEmpleado(@Valid Empleado empleado, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status){
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registro de Empleado");
            return "formEmpleado";
        }
        String mensaje = (empleado.getId() != null) ? "El empleado ha sido Actualizado con éxito" : "Cliente Registrado con éxito";

        empleadoService.save(empleado);
        status.setComplete();
        flash.addFlashAttribute("success", mensaje);
        return "redirect:/listar";
    }

    @GetMapping({"/", "/listar", ""})
    public String listarEmpleados(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo){
        Pageable pageRequest = PageRequest.of(page, 10);
        Page<Empleado> empleados = empleadoService.findAll(pageRequest);

        PageRender<Empleado> pageRender = new PageRender<>("/listar", empleados);

        modelo.addAttribute("titulo", "Listado de Empleados");
        modelo.addAttribute("empleados", empleados);
        modelo.addAttribute("page", pageRender);

        return "listar";
    }

    @GetMapping("/form/{id}")
    public String editarEmpleado(@PathVariable(value = "id") Long id, Map<String, Object> modelo, RedirectAttributes flash){
        Empleado empleado = null;

        if(id > 0){
            empleado = empleadoService.findOne(id);
            if(empleado == null){
                flash.addFlashAttribute("error", "ID entregado no existe en la base de datos");
                return "redirect:/listar";
            }
        }else{
            flash.addFlashAttribute("error", "El ID del empleado no puede ser cero.");
        }
        modelo.put("empleado", empleado);
        modelo.put("titulo", "Edición Empleado " + empleado.getNombre());

        return "formEmpleado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            empleadoService.delete(id);
            flash.addFlashAttribute("success", "Empleado eliminado con éxito");
        }
        return "redirect:/listar";
    }

    @GetMapping("/exportarPDF")
    public void exportarListadoEmpleadosPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        String fechaActual= dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Empleados_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Empleado> empleados = empleadoService.findAll();

        EmpleadoExporterPDF exporterPDF = new EmpleadoExporterPDF(empleados);
        exporterPDF.exportar(response);
    }

    @GetMapping("/exportarExcel")
    public void exportarListadoEmpleadosExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octec-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        String fechaActual= dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Empleados_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        List<Empleado> empleados = empleadoService.findAll();

        EmpleadoExporterExcel empleadoExporterExcel = new EmpleadoExporterExcel(empleados);
        empleadoExporterExcel.exportar(response);
    }
}
