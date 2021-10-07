package com.company.reto;

public class Libro {

    // 1. atributos
    public String titulo;
    public int  num_paginas;
    public String editorial;
    public String idioma;
    public String isbn;
    public int anio;
    public String plaza_edicion;

    // 2. constructores
    public Libro(String titulo, int num_paginas, String idioma, String isbn, int anio, String plaza_edicion){}

    public Libro(String titulo, int num_paginas, String editorial, String idioma, String isbn, int anio, String plaza_edicion) {
        this.titulo = titulo;
        this.num_paginas = num_paginas;
        this.editorial = editorial;
        this.idioma = idioma;
        this.isbn = isbn;
        this.anio = anio;
        this.plaza_edicion = plaza_edicion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "titulo='" + titulo + '\'' +
                ", número de páginas '" + num_paginas + '\'' +
                ", editorial='" + editorial + '\'' +
                ", idioma=" + idioma +
                ", isbn=" + isbn +
                ", año=" + anio +
                ", Plaza de edición=" + plaza_edicion +
                '}';
    }


}
