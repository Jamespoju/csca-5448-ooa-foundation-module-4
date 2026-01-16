package server.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;
public class SimulationResult {
    private String pcbType;
    private int totalRun;
    private int totalPass;
    private Map<String, Integer> stationFailures;
    private Map<String, Integer> defectFailures;

    public SimulationResult() {
    }

    public SimulationResult(String pcbType, int totalRun, int totalPass, Map<String, Integer> stationFailures, Map<String, Integer> defectFailures) {
        this.pcbType = pcbType;
        this.totalRun = totalRun;
        this.totalPass = totalPass;
        this.stationFailures = stationFailures;
        this.defectFailures = defectFailures;
    }

    public void setPcbType(String pcbType) {
        this.pcbType = pcbType;
    }

    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }

    public void setTotalPass(int totalPass) {
        this.totalPass = totalPass;
    }

    public void setStationFailures(Map<String, Integer> stationFailures) {
        this.stationFailures = stationFailures;
    }

    public void setDefectFailures(Map<String, Integer> defectFailures) {
        this.defectFailures = defectFailures;
    }

    public String getPcbType() {
        return pcbType;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public int getTotalPass() {
        return totalPass;
    }

    public Map<String, Integer> getStationFailures() {
        return stationFailures;
    }

    public Map<String, Integer> getDefectFailures() {
        return defectFailures;
    }
}
