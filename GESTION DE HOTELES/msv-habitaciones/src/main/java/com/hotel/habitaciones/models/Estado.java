package com.hotel.habitaciones.models;

public enum Estado {
	  
	    DISPONIBLE(1L, "Disponible"),     // ← Llama al constructor
	    OCUPADA(2L, "Ocupada"),       
	    LIMPIEZA(3L, "En Limpieza"),     
	    MANTENIMIENTO(4L, "En Mantenimiento"); 

	    // Campos del enum
	    private final Long id;
	    private final String descripcion;

	    // OBLIGATORIO: Constructor para inicializar los campos
	    Estado(Long id, String descripcion) {
	        this.id = id;
	        this.descripcion = descripcion;
	    }
}
