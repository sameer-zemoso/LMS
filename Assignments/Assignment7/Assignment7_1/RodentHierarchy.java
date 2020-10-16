package Assignments.Assignment7.Assignment7_1;

class Rodent{
    void eat(){
        System.out.println("Rodent is eating");
    }
    void jump(){
        System.out.println("Rodent jumps");
    }

}
class Mouse extends Rodent {
    Mouse() {
        System.out.println("this is mouse class");
    }
    void eat(){
        System.out.println("Mouse is eating");
    }
    void jump(){
        System.out.println("Mouse jumps");
    }
}
class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("This is Gerbil class");
    }
    void eat(){
        System.out.println("Gerbil is eating");
    }
    void jump(){
        System.out.println("Gerbil jumps");
    }
}
class Hamster extends Rodent {
    Hamster() {
        System.out.println("This is hamster class");
    }
    void eat(){
        System.out.println("Hamster is eating");
    }
    void jump(){
        System.out.println("Hamster jumps");
    }
}

public class RodentHierarchy {
    public static void main(String[] args) {
        Rodent r[] = new Rodent[3];
        r[0] = new Mouse();
        r[1] = new Gerbil();
        r[2] = new Hamster();

        r[0].eat();
        r[0].jump();

        r[1].eat();
        r[1].jump();

        r[2].eat();
        r[2].jump();
    }
}
