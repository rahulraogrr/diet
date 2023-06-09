package com.diet.exceptions.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    @Schema(title = "status", name = "status", description = "Error Status")
    private int status;

    @Schema(title = "timestamp", name = "timestamp", description = "Error Timestamp", example = "2021-08-10 03:48:58")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
}