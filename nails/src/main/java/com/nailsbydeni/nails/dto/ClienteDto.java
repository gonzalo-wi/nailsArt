package com.nailsbydeni.nails.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
    private static final int    NOMBRE_MINIMO_TAMANIO      = 2;
    private static final int    NOMBRE_MAXIMO_TAMANIO      = 100;
    private static final int    TELEFONO_MINIMO_TAMANIO    = 9;
    private static final int    TELEFONO_MAXIMO_TAMANIO    = 15;
    private static final int    EMAIL_MAXIMO_TAMANIO       = 100;

    private static final String TELEFONO_REGEX = "^[0-9]{" + TELEFONO_MINIMO_TAMANIO + "," + TELEFONO_MAXIMO_TAMANIO + "}$";

    private Long id;
    @NotBlank(message = "{cliente.nombre.obligatorio}")
    @Size(min = NOMBRE_MINIMO_TAMANIO, max = NOMBRE_MAXIMO_TAMANIO, message = "{cliente.nombre.size}")
    private String nombre;

    @Pattern(regexp = TELEFONO_REGEX, message = "{cliente.telefono.pattern}")
    private String telefono;

    @Email(message = "{cliente.email.invalid}")
    @Size(max = EMAIL_MAXIMO_TAMANIO, message = "{cliente.email.size}")
    private String email;
}
