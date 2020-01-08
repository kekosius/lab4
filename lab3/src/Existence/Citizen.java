package Existence;

import Other.*;

import static java.lang.Math.*;

public class Citizen extends Gnome implements Say, Think {
    private  double fear;
    private int hungry = 0;
    private Town town;
    private Town townTo;

    public Citizen(Town town, String name) {
        this.town = town;
        setName(name);
        fear = Math.random();
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Town getTown() {
        return this.town;
    }


    public void eat() {
        int plusHungry;
        System.out.println("\n" + getName() + " пошел покушать к малышам");
        plusHungry = (int) (random() * 100.0);
        hungry += plusHungry;
        System.out.println(getName() + " покушал и теперь его сытость " + getHungry());
    }

    public void go() {
        if (townTo==null) {
            System.out.println("\n"+getName()+ " не задумывался куда-либо пойти");
        }
        else {
            if (hungry > 0){
            System.out.println(getName() + " отправился из города " + town + " в город " + townTo);
            Travel travel = new Travel(this, townTo);
            travel.travel();//определяем текущий город и отправляем в указвнный
            townTo = null;
            }else {
                System.out.println(getName() + " голоден и не способен отправиться в путишествие");
            }

        }
    }

    public void setTownTo(Town townTo) {
        this.townTo = townTo;
    }

    public double getFear() {
        return fear;
    }

    public int getHungry() {
        return this.hungry;
    }

    public void reduceHungry() throws StarvationException {
        this.hungry--;
        if (hungry <= 0){
            throw new StarvationException();
        }
    }//пропадает сытость

    @Override
    public void think(Town townTo) throws ExceptionOfChoosingCity {
            if (townTo == getTown()) {
            throw new ExceptionOfChoosingCity();
            }
            else {
                System.out.println("\n" + getName() + " подумал отправиться в город " + townTo);
            }
            this.townTo = townTo;

    }

    @Override//Основной
    public void say(String somebody) {
        System.out.println(getName() + " говорит: привет " + somebody);
    }


    @Override
    public String toString() {
        return "Житель " + getName() + " появился в городе " + getTown();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen)) return false;

        Citizen citizen = (Citizen) o;

        if (getHungry() != citizen.getHungry()) return false;
        if (getTown() != citizen.getTown()) return false;
        return getName() == citizen.getName();
    }

    @Override
    public int hashCode() {
        return getTown().hashCode() + getHungry() + getName().hashCode();
    }
}