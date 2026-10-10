package encapsulation.assigment_problems;

// Key idea: next() is the only way to change the color, and it always moves one step
// forward through a fixed cycle (modulo wraps YELLOW back to RED).
class TrafficLight {
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int position = 0; // starts on RED

    TrafficLight(String id) {
        this.id = id;
    }

    String next() {
        position = (position + 1) % CYCLE.length;
        return CYCLE[position];
    }

    String getColor() {
        return CYCLE[position];
    }

    String getId() {
        return id;
    }
}

public class TrafficLightCycle {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
