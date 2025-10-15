
package com.hotel.habitaciones.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="HABITACION")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Habitacion {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_HABITACION")
	@SequenceGenerator(name="SEQ_HABITACION",sequenceName="SEQ_HABITACION",allocationSize = 1)
	@Column(name= "ID_HABITACION")
	private Long id;
	
	//mayor a 0 y unico
	@NotNull(message = "El número de la habitación es requerido")
	@Positive(message = "El número de la habitación debe ser positivo")
	@Column(name = "NUMERO", nullable = false, unique = true)
	private Short numero;
	
	//Obligatorio
	@Positive(message="El id de el tipo debe ser positivo")
	@NotNull(message="El id del tipo de  habitacion es requerida")
	@Column(name= "TIPO")
	private Long idtipo;
	
	@NotBlank(message = "La descripcion es requerida")
	@Size(min = 1, max = 50, message = "La descripción debe tener entre 1 y 50 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	private String descripcion;
	
	//precio debe ser mayor a 0
	@Positive(message = "El precio debe ser positivo")
	@Column(name = "PRECIO", nullable = false)
	private Double precio;
	
	//capacidad debe ser mayor o igual a 1
	@NotNull(message="La capacidad de la habitacion es requerida")
	@Min(value = 1, message = "La capacidad de la habitacion no puede ser menor a 1")
	@Column(name= "CAPACIDAD", nullable = false)
	private Short capacidad;
	
	@Positive(message="El id de el estado debe ser positivo")
	@Column(name = "ID_ESTADO")
	private Long idEstado;
}

