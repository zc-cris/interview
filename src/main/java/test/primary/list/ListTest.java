package test.primary.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListTest {

    List<String> list = new ArrayList<>();
    List<String> list2 = new LinkedList<>();
    
    @Test
    public void test2() {
        log.info("cris");
    }
    
}
