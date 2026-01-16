package server.model;

import java.util.Map;

public interface PCB {
    String getType();
    Map<String, Double> getDefectChances();
}
