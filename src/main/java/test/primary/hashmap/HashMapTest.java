package test.primary.hashmap;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 123);
        map.put(null, 3);
        System.out.println(map.get(null));              // 3，hashmap的key是可以为null的哦
        
        System.out.println(false && true || true);      // true    java 中 && 优先级高于 ||
        System.out.println(true || true && false);      // true
    }
    
}
