package cl.gmanquilefn.recordstore.model;

public record ErrorResponse(String timestamp, Integer status, String error, String message, String path) {
}
