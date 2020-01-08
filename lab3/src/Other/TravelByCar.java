package Other;

import Existence.Citizen;
import static java.lang.Math.*;

class TravelByCar {
    private Map map = Map.getMap();
    private Citizen citizen;
    private Town town2;
    private Car car;
    private int x;
    private int y;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean b = true;

    public TravelByCar(Citizen citizen, Town town2, Car car) {
        this.citizen = citizen;
        this.town2 = town2;
        this.car = car;
        x1 = citizen.getTown().getXg();
        y1 = citizen.getTown().getYg();
        x2 = town2.getXg();
        y2 = town2.getYg();
        x = x1;
        y = y1;
    }

    void ride() {
        if (abs(x2 - x1) >= abs(y2 - y1)) {//если dх больше
            while (x != x2 && b) {// для каждого x строим соответствующий у
                map.removeOnMapp(citizen, x, y);
                map.removeOnMapp(car, x, y);
                x += signum(x2 - x1);//шагает по x
                y = y1 + round((x - x1) * (y2 - y1) / (float) (x2 - x1));//шагает по у
                map.addOnMapp(citizen, x, y);
                map.addOnMapp(car, x, y);
                move();
            }
        } else {//если dy больше
            while (y != y2 && b) {// для каждого у строим соответствующий х
                map.removeOnMapp(citizen, x, y);
                map.removeOnMapp(car, x, y);
                y += signum(y2 - y1);//шагает по y
                x = x1 + round((y - y1) * (x2 - x1) / (float) (y2 - y1));//шагает по x
                map.addOnMapp(citizen, x, y);
                map.addOnMapp(car, x, y);
                move();
            }
        }
    }

    private void move() {
        if (x == x2) {
            System.out.println(citizen.getName() + " доехал на автомобиле c " + car.getFruit() + " на капоте в город " + town2 + "\n");
            citizen.setTown(town2);
            car.setTown(town2);
            map.findGnomeOnPoint(citizen, x, y);
            b = false;
        } else {
            System.out.println(citizen.getName() + " едет в точке (" + x + "," + y + ")");
            try {
                citizen.reduceHungry();//уменьшается сытость
            } catch (StarvationException e) {
                System.out.println(e.getMessage());
                b = false;
            }
        }

    }
}
