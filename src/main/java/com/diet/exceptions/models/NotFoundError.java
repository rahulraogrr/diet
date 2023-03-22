package com.diet.exceptions.models;

import com.diet.exceptions.models.messages.NotFoundMessage;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NotFoundError extends ApiErrorResponse {
    List<NotFoundMessage> messages;
}