package com.hotel.huespedes.models;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GeneratedType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
public class Huespedes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_HUESPEDES")
    @SequenceGenerator(name = "SEQUENCE_HUESPEDES", sequenceName = "SEQUENCE_HUESPEDES", allocationSize = 1)
    @Column(name = "ID_CATEGORIAS")
    private Long id;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 1, max = 50, message = "El nombre debe contener entre 1 y 50 caracteres")
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    
    @NotBlank(message = "El apellido es requerido")
    @Size(min = 1, max = 50, message = "El apellido debe contener entre 1 y 50 caracteres")
    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String apellido;
    
    @NotBlank(message = "El email es requerido")
    @Email(message = "El email debe ser válido")
    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;
    
    @NotBlank(message = "El teléfono es requerido")
    @Column(name = "TELEFONO", length = 20)
    private String telefono;
    
    @NotBlank(message = "El documento es requerido")
    @Column(name = "DOCUMENTO", nullable = false, unique = true, length = 30)
    private String documento;
    
    @NotBlank(message = "La nacionalidad es requerida")
    @Column(name = "NACIONALIDAD", length = 50)
    private String nacionalidad;
    
    
}
