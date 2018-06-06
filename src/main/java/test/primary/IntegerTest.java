package test.primary;

// 测试细心程度，粗心都是不会
public class IntegerTest {

    
    public static void main(String[] args) {
        
        int i = 1;
        System.out.println("i = " + i);         // i
        System.out.println("++i = " + ++i);     // 2
        System.out.println("i++ = " + i++);     // 2（i=3）
        System.out.println("i = " + i);         // 3
        System.out.println("--i = " + --i);     // 2
        System.out.println("i-- = " + i--);     // 2
        System.out.println("i = " + i);         // 1
        
        
    }
    
    
}
