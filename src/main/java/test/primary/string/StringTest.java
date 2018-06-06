package test.primary.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class StringTest {
    

    @Test
    void test() {
        
        // 生成两个对象（字符串常量池没有cris的情况下），常量池一个cris，堆内存一个cris，栈内存s1 指向堆内存的cris
        String s1 = new String("cris");
        // 返回常量池的cris的内存地址
        String s2 = "cris";
        // 生成一个对象，只有堆内存又生成一个cris，占内存的s13 指向这个新增的cris
        String s3 = new String("cris");
        
        log.info("s1 == s2:{}", s1 == s2);        // false
        log.info("s1 == s3:{}", s1 == s3);        // false
        log.info("s2 == s3:{}", s2 == s3);      // false
        
        // 字符串引用.intern()表示将当前字符串对象入常量池并返回常量池的字符串引用
        // 如果当前常量池已经有相同的字符串了（equals方法比较），那么就返回常量池中这个字符串引用
        log.info("s1 == s1.intern():{}", s1 == s1.intern());        // false
        log.info("s2 == s2.intern():{}", s2 == s2.intern());        // true
        log.info("s1.intern() == s2.intern():{}", s1.intern() == s2.intern());      // true
        
        String string = "java";
        String string2 = "ja";
        String string3 = "va";
        // 常量（+）找池，变量（+）就在堆新建对象；注意String 是final 类哦
        System.out.println(string == string2 + string3);        // false
        System.out.println(string == string2 + "va");           // false
        System.out.println(string == "ja" + "va");              // true
        System.out.println(string == "java");                   // true
        System.out.println(string2 + string3 == string2 + "va");                   // false
        
        
    }

}
