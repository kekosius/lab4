package Other;

import Existence.*;
import static java.lang.Math.*;

class TravelOnFoot {
    private Map map = Map.getMap();
    private Citizen citizen;
    private Town town2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x;
    private int y;
    private boolean b = true;

    public TravelOnFoot(Citizen citizen, Town town2) {
        this.citizen = citizen;
        this.town2 = town2;
        x1 = citizen.getTown().getXg();
        y1 = citizen.getTown().getYg();
        x2 = town2.getXg();
        y2 = town2.getYg();
        x = x1;
        y = y1;
    }

    void go(){
        if (abs(x2 - x1) >= abs(y2 - y1)) {//если dх больше
            while (x != x2 && b) {// для каждого x строим соответствующий у
                map.removeOnMapp(citizen, x, y);
                x += signum(x2 - x1);//шагает по x
                y = y1 + round((x - x1) * (y2 - y1) / (float) (x2 - x1));//шагает по у
                map.addOnMapp(citizen, x, y);
                move();
            }
        } else {//если dy больше
            while (y != y2 && b) {// для каждого у строим соответствующий х
                map.removeOnMapp(citizen, x, y);
                y += signum(y2 - y1);//шагает по y
                x = x1 + round((y - y1) * (x2 - x1) / (float) (y2 - y1));//шагает по x
                map.addOnMapp(citizen, x, y);
                move();
            }
        }
    }

    private void move() {
        full:
        if (x == x2) {
            System.out.println(citizen.getName() + " зашел в город " + town2);
            citizen.setTown(town2);
            map.findGnomeOnPoint(citizen, x, y);
            b = false;
        } else {
            System.out.println(citizen.getName() + " идет в точке (" + x + "," + y + ")");
            map.findGnomeOnPoint(citizen, x, y);
            if (map.findAnimalOnPoint(citizen, x, y)) {
                System.out.println(citizen.getName() + " испугался и убежал");
                map.addOnMapp(citizen, x1, y1);
                b = false;
                break full;
            }
            try {
                citizen.reduceHungry();//уменьшается сытость
            }catch (StarvationException e){
                System.out.println(e.getMessage());
                b = false;
            }
        }
    }
}
