package com.hotel.reservas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

	@NotNull(message = "El huesed es requerido")
    @Column(nullable = false)
    private String huesped;

	/*@NotNull(message = "La habitacion es requerida perro")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habitacion_id", nullable = false)
    private Habitacion habitacion;*/

	@NotNull(message = "La fecha de entrada es reuqrida")
    @Column(name = "fecha_entrada", nullable = false)
    private LocalDate fechaEntrada;

	@NotNull(message = "La fecha de salida es requerida")
    @Column(name = "fecha_salida", nullable = false)
    private LocalDate fechaSalida;

	@NotNull(message = "El numero de noches es rquerida")
    @Column(name = "noches")
    private Integer noches;

	@NotNull(message = "Su total prro, vuelva pronto")
    @Column(name = "total", precision = 10, scale = 2)
    private Double total;
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado = EstadoReserva.CONFIRMADA;

     /*// Método para calcular noches automáticamente
    @PrePersist
    @PreUpdate
    public void calcularNochesYTotal() {
        if (fechaEntrada != null && fechaSalida != null) {
            this.noches = (int) ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
            calcularTotal();
        }
    }

   // Método para calcular el total
    private void calcularTotal() {
        if (habitacion != null && habitacion.getPrecioPorNoche() != null && noches != null) {
            this.total = habitacion.getPrecioPorNoche().multiply(BigDecimal.valueOf(noches));
        }
    }*/

    // Métodos de negocio
    public void realizarCheckIn() {
        if (this.estado == EstadoReserva.CONFIRMADA) {
            this.estado = EstadoReserva.EN_CURSO;
        } else {
            throw new IllegalStateException("Solo se puede hacer check-in de reservas confirmadas");
        }
    }

    public void realizarCheckOut() {
        if (this.estado == EstadoReserva.EN_CURSO) {
            this.estado = EstadoReserva.FINALIZADA;
        } else {
            throw new IllegalStateException("Solo se puede hacer check-out de reservas en curso");
        }
    }

    public void cancelar() {
        if (this.estado != EstadoReserva.FINALIZADA) {
            this.estado = EstadoReserva.CANCELADA;
        } else {
            throw new IllegalStateException("No se puede cancelar una reserva finalizada");
        }
    }

    // Validación de fechas
    public boolean fechasSonValidas() {
        return fechaEntrada != null && 
               fechaSalida != null && 
               fechaEntrada.isBefore(fechaSalida) &&
               !fechaEntrada.isBefore(LocalDate.now());
    }
}