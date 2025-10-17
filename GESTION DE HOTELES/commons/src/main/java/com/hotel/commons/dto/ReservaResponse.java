package com.hotel.commons.dto;

import java.time.LocalDate;

public record ReservaResponse(
    Long id,
    HuespedResponse idHuesped,
    HabitacionResponse Habitacion,
    LocalDate fechaEntrada,
    LocalDate fechaSalida,
    Integer noches,
    Double total,
    Long idEstado
) {} 