package com.gestionempleados.util.paginacion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender <T>{
    @Getter @Setter
    private String url;

    private Page<T> page;

    @Getter @Setter
    private int totalPaginas;

    private int numElementosPorPagina;

    @Getter @Setter
    private int paginaActual;

    @Getter @Setter
    private List<PageItem> paginas;


    public PageRender(String url, Page<T> page){

        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        numElementosPorPagina = 5;
        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber() + 1;

        int desde, hasta;

        if(totalPaginas <= numElementosPorPagina){
            desde = 1;
            hasta = totalPaginas;
        }else{
            if(paginaActual <= numElementosPorPagina / 2){
                desde = 1;
                hasta = numElementosPorPagina;
            } else if (paginaActual >= totalPaginas - numElementosPorPagina / 2) {
                desde = totalPaginas - numElementosPorPagina + 1;
                hasta = numElementosPorPagina;
            }else {
                desde = paginaActual - numElementosPorPagina / 2;
                hasta = numElementosPorPagina;
            }
        }

        for (int i = 0; i < hasta; i++){
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }
    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }

    public boolean hasNext(){
        return page.hasNext();
    }

    public boolean hasPrevious(){
        return page.hasPrevious();
    }
}
