package com.SiGMafEAr.AlForo.domain.topico;

import jakarta.validation.constraints.NotNull;

public record RequestTopicoDTO(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long usuario,
        @NotNull
        String curso
) {

}
