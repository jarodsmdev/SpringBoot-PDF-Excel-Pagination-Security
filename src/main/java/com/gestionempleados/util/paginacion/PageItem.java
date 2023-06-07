package com.gestionempleados.util.paginacion;

import lombok.*;

@Getter @Setter @ToString @EqualsAndHashCode
public class PageItem {
    private int numero;
    private boolean actual;

    public PageItem(int numero, boolean actual) {
        this.numero = numero;
        this.actual = actual;
    }

    public PageItem(){}
}
