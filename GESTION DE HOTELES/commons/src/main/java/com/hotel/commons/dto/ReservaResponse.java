package com.hotel.commons.dto;

import java.time.LocalDate;

public record ReservaResponse(
    Long id,
    HuespedResponse Huesped,
    HabitacionResponse Habitacion,
    LocalDate fechaEntrada,
    LocalDate fechaSalida,
    Integer noches,
    Double total,
    Long idEstado
) {} 