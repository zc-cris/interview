package test.primary.cite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.Data;

@Data
class Person{
    private String name;
}
class CiteTest {

    public static void changeString(String string) {
        string = "123";
    }
    
    public static void changeName(Person person) {
        person.setName("cris");
    }
    
    public static int changeInt(int age) {
        age = 40;
        return age;
    }
    
    @Test
    void test() {
        
        int i = 10;
        changeInt(i);
        System.out.println(i);      // 10   基本数据类型传递的是值的副本
        
        
       Person person =  new Person();
       person.setName("zc");
       changeName(person);
       System.out.println(person.getName());    // cris   引用传递新生成的引用改变堆内存中对象的属性（根据Thinking in Java，其实还是值传递）
       
       String string = "abc";
       changeString(string);
       System.out.println(string);             // abc     引用传递新生成的引用改变原本的指向
        
    }

}
