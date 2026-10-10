package encapsulation.assigment_problems;

// Key idea: health is private and only changes through methods that clamp the new value
// into [0, maxHealth]. maxHealth is final, so it can't change after construction.
class GameCharacter {
    private final int maxHealth;
    private int health;

    GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        health = Math.max(0, health - amount);         // extra damage is wasted
    }

    void heal(int amount) {
        health = Math.min(maxHealth, health + amount); // extra healing is wasted
    }

    int getHealth() {                                  // read-only: no setter exists
        return health;
    }
}

public class HealthBar {
    public static void main(String[] args) {
        GameCharacter c = new GameCharacter(100);
        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getHealth());
        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getHealth() + " (capped)");
        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}
