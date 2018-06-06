package test.primary.staticorder;

import javax.sound.midi.Soundbank;

import org.junit.jupiter.api.Test;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


class Father{
    public Father() {
        System.out.println("111111111");
    }
    {
        System.out.println("222222222");
    }
    static {
        System.out.println("333333333");
    }
}
class Son extends Father{
    public Son() {
        System.out.println("444444444");
    }
    {
        System.out.println("555555555");
    }
    static {
        System.out.println("666666666");
    }
}

public class StaticOrderTest {
    

    @Test
    public void test() {
        new Son();              //3 6 2 1 5 4           从父到子，静态优先
        System.out.println("-------------------------");
        new Son();              //2 1 5 4               静态代码只加载一次,class对象已经加载完成了
        System.out.println("-------------------------");
        new Father();           // 2 1
    }
    
}
