package com.livraria.livrariavendalivros.payload;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class ResponsePayload {
    private String message;
    private LocalDateTime dateTime;
}
