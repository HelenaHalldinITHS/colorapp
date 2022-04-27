package com.example;

import io.micronaut.core.annotation.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ColorRepository {
    @NonNull
    List<Color> list();

    void save(@NonNull @NotNull @Valid Color color);
}

