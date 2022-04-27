package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static io.micronaut.http.HttpStatus.CREATED;

@Controller("/colors")
@ExecuteOn(TaskExecutors.IO)
public class ColorController {

    private final ColorRepository colorRepository;

    public ColorController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Get
    List<Color> list() {
        return colorRepository.list();
    }

    @Post
    @Status(CREATED)
    void save(@NonNull @NotNull @Valid Color color) {
        colorRepository.save(color);
    }
}

