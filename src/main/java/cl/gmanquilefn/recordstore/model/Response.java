package cl.gmanquilefn.recordstore.model;

import java.time.LocalDateTime;

public record Response(LocalDateTime timestamp, Integer status, String message) {
}
