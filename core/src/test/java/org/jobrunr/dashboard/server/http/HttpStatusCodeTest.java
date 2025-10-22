package org.jobrunr.dashboard.server.http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HttpStatusCodeTest {

    /**
     * This test will start failing if one adds new status code
     * into the {HttpStatusCode} enum without making updates to the unit test.
     */
    @Test
    void testAgainstFixedValues() {
        // number of currently available enums for http status codes
        int expectedNumberOfStatusCodes = 5;

        assertThat(HttpStatusCode.values()).hasSize(expectedNumberOfStatusCodes);
    }

    @Test
    void testGetCode() {
        assertThat(HttpStatusCode.OK.getCode()).isEqualTo(200);
        assertThat(HttpStatusCode.NO_CONTENT.getCode()).isEqualTo(204);
        assertThat(HttpStatusCode.NOT_FOUND.getCode()).isEqualTo(404);
        assertThat(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode()).isEqualTo(500);
        assertThat(HttpStatusCode.UNKNOWN.getCode()).isEqualTo(-1);
    }

    @Test
    void testGetDescription() {
        assertThat(HttpStatusCode.OK.getDescription()).isEqualTo("OK");
        assertThat(HttpStatusCode.NO_CONTENT.getDescription()).isEqualTo("No Content");
        assertThat(HttpStatusCode.NOT_FOUND.getDescription()).isEqualTo("Not Found");
        assertThat(HttpStatusCode.INTERNAL_SERVER_ERROR.getDescription()).isEqualTo("Internal Server Error");
        assertThat(HttpStatusCode.UNKNOWN.getDescription()).isEqualTo("Unknown Status");
    }
}