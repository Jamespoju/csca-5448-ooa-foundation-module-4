package server.model;

import java.util.Map;

public class SensorBoard implements PCB{
    @Override
    public String getType() {
        return "Sensor Board";
    }

    @Override
    public Map<String, Double> getDefectChances() {
        return Map.of(
                "Place Components", 0.002,
                "Optical Inspection", 0.002,
                "Hand Soldering/Assembly", 0.004,
                "Test (ICT or Flying Probe)", 0.004);
    }
}
