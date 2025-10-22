package org.jobrunr.dashboard.server.http.handlers;

import org.jobrunr.dashboard.server.http.HttpStatusCode;

import java.util.HashMap;
import java.util.Map;

import static org.jobrunr.dashboard.server.http.handlers.HttpRequestHandlers.RequestMethod.*;

public class HttpRequestHandlers {

    public static final HttpRequestHandler ok = (httpRequest, httpResponse) -> httpResponse.statusCode(HttpStatusCode.OK.getCode());
    public static final HttpRequestHandler notFound = (httpRequest, httpResponse) -> httpResponse.statusCode(HttpStatusCode.NOT_FOUND.getCode());

    private final Map<String, HttpRequestMethodHandlers> requestHandlers = new HashMap<>();

    public static class RequestMethod {

        private RequestMethod() {
        }

        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
    }

    public void get(String url, HttpRequestHandler httpRequestHandler) {
        getAllRequestMethodHandlers(GET).put(url, httpRequestHandler);
    }

    public void put(String url, HttpRequestHandler httpRequestHandler) {
        getAllRequestMethodHandlers(PUT).put(url, httpRequestHandler);
    }

    public void post(String url, HttpRequestHandler httpRequestHandler) {
        getAllRequestMethodHandlers(POST).put(url, httpRequestHandler);
    }

    public void delete(String url, HttpRequestHandler httpRequestHandler) {
        getAllRequestMethodHandlers(OPTIONS).put(url, HttpRequestHandlers.ok);
        getAllRequestMethodHandlers(DELETE).put(url, httpRequestHandler);
    }

    public void head(String url, HttpRequestHandler httpRequestHandler) {
        getAllRequestMethodHandlers(HEAD).put(url, httpRequestHandler);
    }

    public HttpRequestMethodHandlers getAllRequestMethodHandlers(String method) {
        return requestHandlers.computeIfAbsent(method.toUpperCase(), m -> new HttpRequestMethodHandlers());
    }
}
