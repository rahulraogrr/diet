package com.diet.exceptions.models.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class NotFoundMessage {
    @Schema(title = "path",
            description = "path",
            example = "/api/v1/members/"
    )
    public String path;

    @Schema(title = "defaultMessage",
            description = "defaultMessage",
            example = "Member was not found for parameters rahulraogrr"
    )
    public String defaultMessage;
}
