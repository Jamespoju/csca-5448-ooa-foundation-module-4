package server.simulation;

import server.model.PCB;
import server.model.SimulationResult;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Simulator {
    private static final List<String> STATIONS = List.of(
      "Apply Solder Paste",
      "Place Components",
      "Reflow Solder",
      "Optical Inspection",
      "Hand Soldering/ Assembly",
      "Cleaning",
      "Depanelization",
      "Test (ICT or Flying Probe)"
    );

    private static final double STATION_FAILURE_CHANCE = 0.002;

    public SimulationResult runSimulation(PCB pcb) {
        Random rand = new Random();
        int total = 1000;
        int passed = 0;

        Map<String, Integer> stationFailures = new LinkedHashMap<>();
        Map<String, Integer> defectFailures = new LinkedHashMap<>();

        // Initialize counts
        for (String station : STATIONS) {
            stationFailures.put(station, 0);
        }
        for (String station : pcb.getDefectChances().keySet()) {
            defectFailures.put(station, 0);
        }

        for (int i = 0; i < total; i++) {
            boolean failed = false;

            for (String station : STATIONS) {
                if (rand.nextDouble() < STATION_FAILURE_CHANCE) {
                    stationFailures.put(station, stationFailures.get(station) + 1);
                    failed = true;
                    break;
                }

                if (pcb.getDefectChances().containsKey(station)) {
                    if (rand.nextDouble() < pcb.getDefectChances().get(station)) {
                        defectFailures.put(station, defectFailures.get(station) + 1);
                        failed = true;
                        break;
                    }
                }
            }

            if (!failed) passed++;
        }

        return new SimulationResult(pcb.getType(), total, passed, stationFailures, defectFailures);
    }
}
