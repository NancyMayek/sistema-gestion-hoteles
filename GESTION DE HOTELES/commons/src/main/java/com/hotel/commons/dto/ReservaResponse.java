package com.hotel.commons.dto;

import java.time.LocalDate;

public record ReservaResponse(
    Long id,
    Long idHuesped,
    Long idHabitacion,
    LocalDate fechaEntrada,
    LocalDate fechaSalida,
    Integer noches,
    Double total,
    Long idEstado
) {} 