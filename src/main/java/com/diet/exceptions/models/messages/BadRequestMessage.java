package com.diet.exceptions.models.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class BadRequestMessage extends Message implements Comparable<BadRequestMessage>{

    @Schema(title = "object",
            description = "object",
            example = "Member")
    private String object;

    @Schema(title = "field",
            description = "field",
            example = "firstName")
    private String field;

    @Schema(title = "rejectedValue",
            description = "rejectedValue",
            example = "Rahul Rao")
    private Object rejectedValue;

    @Schema(title = "defaultMessage",
            description = "defaultMessage",
            example = "firstName must be a minimum of 6 and maximum of 12 Characters")
    private String defaultMessage;

    @Override
    public int compareTo(BadRequestMessage badRequestMessage) {
        return this.getField().compareTo(badRequestMessage.getField());
    }
}
