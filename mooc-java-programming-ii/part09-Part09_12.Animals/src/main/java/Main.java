
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.eat();
        
        Dog fido = new Dog("Fido");
        fido.bark();

        Cat cat = new Cat();
        cat.purr();
        cat.eat();
        
        Cat garfield = new Cat("Garfield");
        garfield.purr();

        NoiseCapable noiseDog = new Dog();
        noiseDog.makeNoise();

        NoiseCapable noiseCat = new Cat("Garfield");
        noiseCat.makeNoise();
    }

}
