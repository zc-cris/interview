package test.primary.polymorphism;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;


interface Animal{
    void eat();
}
class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("cat eat fish");
    }
  
}
class Dog implements Animal{

    @Override
    public void eat() {
        System.out.println("dog eat bone");
    }
    
}
class AnimalFactory {
    public static Animal getInstance(Integer integer) {
        Animal animal = null;
        
        switch (integer) {
        case 0:
            animal = new Cat();
            break;

        default:
            animal = new Dog();
            break;
        }
        return animal;
    }
}

class PolymorphismTest {

    @Test
    void test() {
        Animal instance = AnimalFactory.getInstance(new Random().nextInt(2));         // 0,1
        instance.eat();
    }

}
