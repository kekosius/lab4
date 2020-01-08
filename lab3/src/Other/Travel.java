package Other;

import Existence.Citizen;

public class Travel { //осуществляет перемещение из города в город
    private Map map = Map.getMap();
    private Citizen citizen;
    private Town town2;

    public Travel(Citizen citizen, Town town2) {
        this.citizen = citizen;
        this.town2 = town2;
    }

    public void travel() {
        if (map.findCarOnPoint(citizen.getTown().getXg(), citizen.getTown().getYg()) instanceof Car) {//проверяем есть ли автомобиль а городе
            Car car = (Car) map.findCarOnPoint(citizen.getTown().getXg(), citizen.getTown().getYg());
            TravelByCar travel = new TravelByCar(citizen, town2, car);
            travel.ride();
        } else {
            TravelOnFoot travel = new TravelOnFoot(citizen, town2);
            travel.go();
        }
    }
}


