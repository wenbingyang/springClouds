package com.smd.employee.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

    public static <K> Map<K, Object> map(Object v, K... key) {
        return map(v, Arrays.asList(key));
    }

    public static <K> Map<K, Object> map(Object v, List<K> key) {
        Map<K, Object> resultMap = new HashMap<>();
        for (int i = 0; i < key.size() - 1; i++) {
            getMap(resultMap, key.subList(0, i)).put(key.get(i), new HashMap<>());
        }
        getMap(resultMap, key.subList(0, key.size() - 1)).put(key.get(key.size() - 1), v);
        return resultMap;
    }

    private static <K> Map<K, Object> getMap(Map<K, Object> resultMap, List<K> key) {
        if (key.isEmpty()) {
            return resultMap;
        }
        Map<K, Object> tempMap = resultMap;
        for (K k : key) {
            tempMap = (Map<K, Object>) tempMap.get(k);
        }
        return tempMap;
    }

}
