package client;

import server.database.RedisManager;
import server.model.SimulationResult;
import server.model.SimulationResultSerializer;

public class ClientMain {
    public static void main(String[] args) {
//        String key = "simulation:Sensor_Board";
//        String key = "simulation:Test_Board";
        String key = "simulation:Gateway_Board";
        String json = RedisManager.load(key);
        System.out.println("Data from Redis:\n" + json);
        if(json == null) {
            System.out.println("No data found in Redis for key: " + key);
            return;
        }

        SimulationResult result = SimulationResultSerializer.fromJson(json);
        System.out.println("PCB type: " + result.getPcbType());
        System.out.println("PCB run: " + result.getTotalRun());
        System.out.println("\nStation Failures");
        result.getStationFailures().forEach((station, count) ->
                System.out.println(station + " : " + count));

        System.out.println("\nPCB Defect Failures");
        result.getDefectFailures().forEach((station, count) ->
                System.out.println(station + " " + count));

        System.out.println("\nFinal Results");
        int totalFailed = result.getTotalRun() - result.getTotalPass();
        System.out.println("Total failed PCBs: " + totalFailed);
        System.out.println("Total PCBs produced: " + result.getTotalPass());
    }
}
