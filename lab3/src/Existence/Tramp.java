package Existence;

public class Tramp extends Gnome{

    public Tramp(String name, String say) {
        setSay(say);
        setName(name);
    }

    @Override//Основной
    public void say(String somebody) {
        System.out.println(getName() + " говорит: " + getSay() + ' ' + somebody);
    }

    @Override
    public String toString() {
        return "Бездомный житель " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tramp)) return false;

        Tramp tramp = (Tramp) o;

        return getName() == tramp.getName();
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

}
