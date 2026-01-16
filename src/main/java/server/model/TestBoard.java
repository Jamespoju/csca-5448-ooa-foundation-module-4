package server.model;

import java.util.Map;

public class TestBoard implements PCB{
    @Override
    public String getType() {
        return "Test Board";
    }

    @Override
    public Map<String, Double> getDefectChances() {
        return Map.of(
                "Place Components", 0.05,
                "Optical Inspection", 0.10,
                "Hand Soldering/Assembly", 0.05,
                "Test (ICT or Flying Probe)", 0.10);
    }
}
