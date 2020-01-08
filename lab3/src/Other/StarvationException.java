package Other;

public class StarvationException extends RuntimeException {
    public StarvationException() {
        super("Герой слишком голоден, чтобы продолжать путешествие, он теряет сознание и оказывается в больнице исходного города");
    }
}
