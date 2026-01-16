package server.database;

import redis.clients.jedis.Jedis;

public class RedisManager {
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    private static final Jedis JEDIS;

    static {
        JEDIS = new Jedis(REDIS_HOST, REDIS_PORT);
    }

    public static void save(String key, String json) {
        JEDIS.set(key, json);
    }

    public static String load(String key){
        return JEDIS.get(key);
    }
}
