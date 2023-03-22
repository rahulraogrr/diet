package com.diet.exceptions.models;

import com.diet.exceptions.models.messages.InternalServerMessage;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InternalServerError extends ApiErrorResponse{
    List<InternalServerMessage> messages;
}
