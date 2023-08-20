package com.richard.infrastructure.resources.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotEmpty
        @Size(max = 100, message = " tamanho deve estar entre 0 e 100 caracteres")
        String name

) { }
