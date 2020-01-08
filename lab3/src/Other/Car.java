package Other;

public class Car extends Substance {
    private Fruit fruit;
    private Town town;

    public enum Fruit {
        APPLE,
        PEAR,
        PLUM,
        KIWI,
        PINEAPPLE,
        ORANGE;
    }

    public Car(Town town, Fruit fruit){
        this.town=town;
        this.fruit=fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
