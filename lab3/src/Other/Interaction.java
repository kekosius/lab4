package Other;

import Existence.Animal;
import Existence.Citizen;
import Existence.Gnome;

public class Interaction {//для взаимодействия существ

    public static boolean meetAn(Citizen citizen, Substance substance) {
        Animal animal = (Animal) substance;
        System.out.println(citizen.getName()+" увидел, что на дороге стоит "+ animal.getType());
        citizen.say(animal.getType());
        animal.say();
        if (animal.getScare() >= citizen.getFear()) {//задается предел страшности животного
            return true;
        } else {
            System.out.println("Но "+citizen.getName()+" не испугался животного");
            return false;
        }
    }

    public static void meetGn(Citizen citizen, Substance substance) {
        Gnome gnome = (Gnome) substance;
        System.out.println(citizen.getName()+" увидел, перед собой "+ gnome.getName());
        citizen.say(gnome.getName());
        gnome.say(citizen.getName());
    }
}
