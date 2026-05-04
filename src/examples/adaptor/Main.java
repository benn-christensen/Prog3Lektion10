package examples.adaptor;

public class Main {
    static void main() {
        Projector projector = new LGAdaptor(new LGProjector());
        projector.turnOn();
    }
}
