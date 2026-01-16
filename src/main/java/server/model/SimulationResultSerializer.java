package server.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimulationResultSerializer {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(SimulationResult result) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert to JSON", e);
        }
    }

    public static SimulationResult fromJson(String json) {
        try {
            return mapper.readValue(json, SimulationResult.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("failed to parse JSON", e.getCause());
        }
    }
}