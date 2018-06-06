package test.primary.equals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EqualsTest {

    @Test
    void test() {

        String string = new String("cris");
        String string2 = new String("cris");
        log.info("string == string2 是：{}", string == string2); // false
        log.info("string.equals(string2) 是：{}", string.equals(string2)); // true
        System.out.println(1000 == new Integer(1000)); // true（包装类自动转换为基本数据类型）
        System.out.println(new Integer(2000).equals(2000)); // Integer覆写equals，比较值

        Integer integer = new Integer(9090);
        Integer integer2 = new Integer(9090);
        System.out.println(integer.equals(integer2)); // 注意：Integer复写了equals方法，就是比较值
        System.out.println(integer == integer2); // false

        Set<String> set = new HashSet<>();
        set.add(string);
        set.add(string2);
        log.info("set 的size是：{}", set.size()); // 1

        log.info("------------------------------------");

        Person p1 = new Person("cris", 12);
        Person p2 = new Person("cris", 12);
        log.info("p1 == p2  是：{}", p1 == p2); // false
        log.info("p1.equals(p2)  是：{}", p1.equals(p2)); // 不重写euqals方法就是false

        Set<Person> set2 = new HashSet<>();
        set2.add(p1);
        set2.add(p2);
        log.info("set2的size是：{}", set2.size()); // 不覆写equals和hashcode就是 2

    }

}
