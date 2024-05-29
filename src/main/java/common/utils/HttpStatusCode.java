package common.utils;

public enum HttpStatusCode {

    // success
    OK(200,"OK"),
    ACCEPTED(202,"Accepted");

    private int code;
    private String message;
    HttpStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
