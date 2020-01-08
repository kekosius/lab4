import Existence.*;
import Other.*;


public class Main {

    public static void main(String[] args) {

        Map map = Map.getMap();

        Citizen znayka = new Citizen(Town.FLOWER, "Знайка");
        map.addOnMapp(znayka, znayka.getTown().getXg(), znayka.getTown().getYg());//заносим гражданина в список
        System.out.println("В городе появился " + znayka);

        Citizen pomogaika = new Citizen(Town.SUN, "Помогайка");
        map.addOnMapp(pomogaika, pomogaika.getTown().getXg(), pomogaika.getTown().getYg());//заносим гражданина в список
        System.out.println("В городе появился " + pomogaika);

        Citizen bublik = new Citizen(Town.FLOWER, "Бублик");
        map.addOnMapp(bublik, bublik.getTown().getXg(), bublik.getTown().getYg());//заносим гражданина в список
        System.out.println("В городе появился " + bublik);

        Citizen gvozdik = new Citizen(Town.GREEN, "Гвоздик");
        map.addOnMapp(gvozdik, gvozdik.getTown().getXg(), gvozdik.getTown().getYg());//заносим гражданина в список
        System.out.println("В городе появился " + gvozdik);

        Citizen shurupchik = new Citizen(Town.GREEN, "Шурупчик");
        map.addOnMapp(shurupchik, shurupchik.getTown().getXg(), shurupchik.getTown().getYg());
        System.out.println("В городе появился " + shurupchik);

        Citizen molchun = new Citizen(Town.KITE, "Молчун"){
            @Override//Основной
            public void say(String somebody) {
                System.out.println(getName() + " помахал ему рукой ");
            }
        };
        map.addOnMapp(molchun, molchun.getTown().getXg(), molchun.getTown().getYg());
        System.out.println("В городе появился " + molchun);

        Tramp michalich = new Tramp("Михалыч", "Удачного пути");
        map.addOnMapp(michalich, 15, 24);//заносим бездомного в список
        System.out.println("В лесу появился " + michalich);

        Tramp petrovich = new Tramp("Петрович", "Проходи, не задерживайся");
        map.addOnMapp(petrovich, 23, 19);//заносим бездомного в список
        System.out.println("В лесу появился " + petrovich);

        Animal catdog = new Animal("КотоПес", "МяуГав");
        map.addOnMapp(catdog, 16, 23);//заносим животное в список
        System.out.println("В лесу появился " + catdog);

        Animal snake = new Animal("Волосатая змея", "шшшшшшш");
        map.addOnMapp(snake, 17, 21);//заносим животное в список
        System.out.println("В лесу появился " + snake);

        Animal hedgehog = new Animal("Мохнатый ёж", "уф-уф-уф-уф");
        map.addOnMapp(hedgehog, 18, 12);//заносим животное в список
        System.out.println("В лесу появился " + hedgehog);

        Car car1 = new Car(Town.GREEN, Car.Fruit.APPLE);
        map.addOnMapp(car1, car1.getTown().getXg(), car1.getTown().getYg());

        Car car2 = new Car(Town.GREEN, Car.Fruit.PEAR);
        map.addOnMapp(car2, car2.getTown().getXg(), car2.getTown().getYg());

        Car car3 = new Car(Town.GREEN, Car.Fruit.PLUM);
        map.addOnMapp(car3, car3.getTown().getXg(), car3.getTown().getYg());

        try{
            znayka.think(Town.GREEN );
        }catch(ExceptionOfChoosingCity e) {
            System.out.println(e.getMessage());
           znayka.setTownTo(null);
        }
        znayka.eat();
        znayka.go();//отправляем жителя в другой город ...

        try{
            znayka.think(Town.GREEN );
        }catch(ExceptionOfChoosingCity e) {
            System.out.println(e.getMessage());
            znayka.setTownTo(null);
        }
        znayka.go();//отправляем жителя в другой город ...

        try{
            znayka.think(Town.KITE );
        }catch(ExceptionOfChoosingCity e) {
            System.out.println(e.getMessage());
            znayka.setTownTo(null);
        }
        znayka.eat();
        znayka.go();//отправляем жителя в другой город ...

        try{
            pomogaika.think(Town.SUN );
        }catch(ExceptionOfChoosingCity e) {
            System.out.println(e.getMessage());
            znayka.setTownTo(null);
        }
        pomogaika.eat();
        pomogaika.go();//отправляем жителя в другой город ...

        try{
            gvozdik.think(Town.FLOWER );
        }catch(ExceptionOfChoosingCity e) {
            System.out.println(e.getMessage());
            znayka.setTownTo(null);
        }
        gvozdik.eat();
        gvozdik.go();//отправляем жителя в другой город ...

        try{
            shurupchik.think(Town.KITE );
        }catch(ExceptionOfChoosingCity e) {
            System.out.println(e.getMessage());
            znayka.setTownTo(null);
        }
        shurupchik.eat();
        shurupchik.go();//отправляем жителя в другой город ...

    }
}
