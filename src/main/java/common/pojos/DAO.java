package common.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public  class DAO {

    protected int responseCode;
    protected String stringJsonResponse;

    public String getStringJsonResponse() {
        return stringJsonResponse;
    }

    public void setStringJsonResponse(String stringJsonResponse) {
        this.stringJsonResponse = stringJsonResponse;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }


    public static <T> String serialize(T item) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return (String) objectMapper.writeValueAsString(item);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String jsonResponse, Class<T> target) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);

        try {
            return (T) objectMapper.readValue(jsonResponse, Class.forName(target.getName()));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
