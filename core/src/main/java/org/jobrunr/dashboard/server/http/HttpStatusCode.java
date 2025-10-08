package org.jobrunr.dashboard.server.http;

/**
 * Enum to represent HTTP status codes (numbers and names).
 * It covers only the status codes that JobRunr uses.
 */
public enum HttpStatusCode {
    OK(200, "OK"),
    NO_CONTENT(204, "No Content"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    UNKNOWN(-1, "Unknown Status");

    private final int code;
    private final String description;

    HttpStatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
