package Existence;

import static java.lang.Math.random;

public class Animal extends Existence implements MakeSound {
    private String type;
    private double scare;

    public Animal(String type, String say) {
        setSay(say);
        this.type = type;
        scare = random();
    }

    public String getType() {
        return this.type;
    }

    public double getScare() {
        return this.scare;
    }

    @Override//Основной
    public void say() {
        System.out.println(getType() + " издает: " + getSay());
    }

    @Override
    public String toString() {
        return "Животное " + getType() + " появился в лесу с координатами";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        if (scare != animal.scare) return false;
        return getType() == animal.getType();
    }

    @Override
    public int hashCode() {
        return getType().hashCode();
    }
}