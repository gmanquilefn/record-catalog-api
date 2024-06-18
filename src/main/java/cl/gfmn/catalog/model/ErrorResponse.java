package cl.gfmn.catalog.model;

public record ErrorResponse(String timestamp, Integer status, String message, String path) {
}
