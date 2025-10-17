package com.hotel.reservas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "RESERVACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESERVA")
    @SequenceGenerator(name = "SEQ_RESERVA", sequenceName = "SEQ_RESERVA", allocationSize = 1)
    @Column(name = "ID_RESERVA")
    private Long id;

    @NotNull(message = "El huésped es requerido")
    @Column(name = "HUESPED_ID", nullable = false)
    private Long idHuesped;

    @NotNull(message = "La habitación es requerida")
    @Column(name = "HABITACION_ID", nullable = false)
    private Long idHabitacion;

    @NotNull(message = "La fecha de entrada es requerida")
    @Column(name = "FECHA_ENTRADA", nullable = false)
    private LocalDate fechaEntrada;

    @NotNull(message = "La fecha de salida es requerida")
    @Column(name = "FECHA_SALIDA", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "NOCHES")
    private Integer noches;

    @Positive(message = "El total debe de ser positivo")
    @Column(name = "TOTAL", nullable = false)
    private Double total;

    @Positive(message="La categoria debe ser positiva")
	@Column(name = "ID_ESTADO")
	private Long idEstado;


}