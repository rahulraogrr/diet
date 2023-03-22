package com.diet.exceptions.models;

import com.diet.exceptions.models.messages.BadRequestMessage;
import lombok.*;
import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BadRequestError extends ApiErrorResponse{
    List<BadRequestMessage> messages;
}