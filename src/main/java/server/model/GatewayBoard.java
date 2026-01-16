package server.model;

import java.util.Map;

public class GatewayBoard implements PCB {
    @Override
    public String getType() {
        return "Gateway Board";
    }

    @Override
    public Map<String, Double> getDefectChances() {
        return Map.of(
            "Place Components", 0.004,
            "Optical Inspection", 0.004,
            "Hand Soldering/Assembly", 0.008,
            "Test (ICT or Flying Probe)", 0.008
        );
    }
}
