
abstract class Animal {
    private int numberoflegs;

    public int getNumberoflegs(){
        return numberoflegs;
    }
    public void setNumberoflegs(int numberoflegs){
        this.numberoflegs = numberoflegs;
    }
    public abstract void play();
}


class Cat extends Animal {
    public Cat() {
        setNumberoflegs(4);
    }

    @Override
    public void play() {
        System.out.println("Cats play with toys");
    }

    public void colour(){
        System.out.println("Cat have many colours");
    }

    public void colour(String color) {
        System.out.println("This cat is " + color + " colour");
    }
}

class Dog extends Animal {
    public Dog() {
        setNumberoflegs(4);
    }
    @Override
    public void play() {
        System.out.println("Dogs play with bones as well as toys");
    }
}

public class AllInOne {
    public static void main(String[] args){
        Animal cat = new Cat();
        Animal dog = new Dog();

        System.out.println("Cat have " + cat.getNumberoflegs() + " legs");
        System.out.println("Dogs have " + dog.getNumberoflegs() + " legs");

        cat.play();
        dog.play();

        ((Cat) cat).colour();
        ((Cat) cat).colour("Blue");
    }
}