package test.primary.duplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        System.out.println(list.size());            // 9
        
        Set set = new HashSet<>();
        set.addAll(list);                           // 快速去重
        
        for (Object object : set) {
            System.out.println(object);             // 1,2,3,4
        }
        set.forEach(System.out::print);             // 1,2,3,4   java 8 语法
        
        list = new ArrayList<>(set);    
        System.out.println(list.size());            // 4
        
        
    }
}
