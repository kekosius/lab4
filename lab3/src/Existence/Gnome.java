package Existence;

public abstract class Gnome extends Existence implements Say {
    private String name;

    @Override
    public void say(String somebody) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

