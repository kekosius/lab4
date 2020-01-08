package Other;

import Existence.Animal;
import Existence.Citizen;
import Existence.Gnome;

public class Map {
    private static Map map;
    private static Cell[][] arr = new Cell[50][50];

    private Map() {//По вашей просьбе прописали синголтон
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                arr[i][j] = new Cell();
            }
        }
    }

    public static Map getMap() {
        if (map == null) {
            map = new Map();
        }
        return map;
    }

    public void removeOnMapp(Substance substance, int x1, int y1) {
        arr[x1][y1].remove(substance);
    }//удаляем из ячейки

    public void addOnMapp(Substance substance, int x2, int y2) {
        arr[x2][y2].add(substance);
    }//добавляем в ячейку

    public boolean findAnimalOnPoint(Citizen citizen, int x, int y) {//ищем в ячйке животное
        for (int i = 0; i < arr[x][y].size(); i++) {
            if (arr[x][y].get(i) instanceof Animal) {//Проверяем какие животные видят коротышку
                if (Interaction.meetAn(citizen, arr[x][y].get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
    public void findGnomeOnPoint(Citizen citizen, int x, int y) {//ищем в ячйке
        for (int i = 0; i < arr[x][y].size(); i++) {
            if ((arr[x][y].get(i) instanceof Gnome) && (!arr[x][y].get(i).equals(citizen))) {//Проверяем какие коротышки видят коротышку
                Interaction.meetGn(citizen, arr[x][y].get(i));
            }
        }
    }
    public Object findCarOnPoint(int x, int y) {//ищем в ячйке
        for (int i = 0; i < arr[x][y].size(); i++) {
            if (arr[x][y].get(i) instanceof Car) {//Проверяем какие есть ли тачки в городе
                return (Car)arr[x][y].get(i);
            }
        }
        return new Object();
    }
}
