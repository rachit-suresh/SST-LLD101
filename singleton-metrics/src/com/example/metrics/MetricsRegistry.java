package com.example.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public enum MetricsRegistry {
    INSTANCE;
    private final Map<String, Long> counters = new ConcurrentHashMap<>();

    public void setCount(String key, long value) {
        counters.put(key, value);
    }

    public void increment(String key) {
        counters.compute(key, (k, v) -> (v == null) ? 1L : v + 1L);
    }

    public long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }
}