package study.developia.java.testapi.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<Result> healthcheck(@RequestParam(name = "format", required = false) String format) {
        Map<String, Integer> map = new HashMap<>();
        if (format == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Result.badRequest());
        }

        if (format.equals("full")) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Result.ok());
        } else if (format.equals("short")) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Result.ok());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Result.badRequest());
        }
    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity<Result> healthcheckPut() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity<Result> healthcheckPost() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity<Result> healthcheckDelete() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    public static class Result {
        private ZonedDateTime currentTime;
        private String status;

        public static Result ok() {
            Result result = new Result();
            result.currentTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            result.status = "OK";
            return result;
        }

        public static Result badRequest() {
            Result result = new Result();
            result.currentTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            result.status = "Bad Request";
            return result;
        }

    }


    @Getter
    public static class ApiResult<T> {
        private ZonedDateTime currentTime;
        private HttpStatus httpStatus;

        public ApiResult httpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public static ApiResult ok() {
            return with().httpStatus(HttpStatus.OK);
        }

        public static ApiResult badRequest() {
            return with().httpStatus(HttpStatus.BAD_REQUEST);
        }

        public static ApiResult methodNotAllowed() {
            return with().httpStatus(HttpStatus.METHOD_NOT_ALLOWED);
        }

        public static ApiResult with() {
            ApiResult result = new ApiResult();
            result.currentTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            return result;
        }

    }
}
