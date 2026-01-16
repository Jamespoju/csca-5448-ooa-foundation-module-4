package server;

import server.database.RedisManager;
import server.model.*;
import server.simulation.Simulator;

public class ServerMain {
    public static void main(String[] args) {
//        PCB pcb = new SensorBoard();
//        PCB pcb = new TestBoard();
        PCB pcb = new GatewayBoard();
        Simulator simulator = new Simulator();
        SimulationResult result = simulator.runSimulation(pcb);

        String json = SimulationResultSerializer.toJson(result);

        // Store in Redis
        String key = "simulation:" + pcb.getType().replace(" ", "_");
        RedisManager.save(key, json);

        System.out.println("Saved to Redis with key: " + key);
        System.out.println(json);
    }
}
