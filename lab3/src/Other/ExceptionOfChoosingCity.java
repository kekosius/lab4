package Other;

public class ExceptionOfChoosingCity extends Exception {//unchecked
    public ExceptionOfChoosingCity() {
        super("\n" + "Нельзя отправлять героя в город, в котором он уже находится!!!");
    }
}
