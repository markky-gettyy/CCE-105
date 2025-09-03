package JFRAME;
import javax.swing.JOptionPane;

abstract class GameCharacter {
    String name;
    int health;
    GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }
    abstract void attack(GameCharacter opponent, int choice);
    boolean isAlive() {
        return health > 0;
    }
}

class Mage extends GameCharacter {
    private static final int FIREBALL_DMG = 20;
    private static final int BIND_CURSE_DMG = 25;
    private static final int ARCANE_EXPLOSION_DMG = 30;
    Mage(String name) {
        super(name, 100);
    }
    @Override
    void attack(GameCharacter opponent, int choice) {
        int damage = 0;
        String move = "";
        switch (choice) {
            case 1: move = "Fireball"; damage = FIREBALL_DMG; break;
            case 2: move = "Bind Curse"; damage = BIND_CURSE_DMG; break;
            case 3: move = "Arcane Explosion"; damage = ARCANE_EXPLOSION_DMG; break;
            default:
                JOptionPane.showMessageDialog(null, name + " wasted the turn by failing the spell!");
                return; // Lose the turn if invalid
        }
        opponent.health -= damage;
        if (opponent.health < 0) opponent.health = 0;
        JOptionPane.showMessageDialog(null,
            name + " casts " + move + "! (" + damage + " damage)\n" +
            opponent.name + " now has " + opponent.health + " HP.");
    }
}

class Warrior extends GameCharacter {
    private static final int SWORD_SLASH_DMG = 15;
    private static final int BLADETRAIL_DMG = 20;
    private static final int BLOODLUST_STRIKE_DMG = 30;
    Warrior(String name) {
        super(name, 100);
    }
    @Override
    void attack(GameCharacter opponent, int choice) {
        int damage = 0;
        String move = "";
        switch (choice) {
            case 1: move = "Sword Slash"; damage = SWORD_SLASH_DMG; break;
            case 2: move = "Bladetrail"; damage = BLADETRAIL_DMG; break;
            case 3: move = "Bloodlust Strike"; damage = BLOODLUST_STRIKE_DMG; break;
            default:
                JOptionPane.showMessageDialog(null, name + " missed the attack and lost the turn!");
                return; // Lose the turn if invalid
        }
        opponent.health -= damage;
        if (opponent.health < 0) opponent.health = 0;
        JOptionPane.showMessageDialog(null,
            name + " uses " + move + "! (" + damage + " damage)\n" +
            opponent.name + " now has " + opponent.health + " HP.");
    }
}

public class TurnBasedGame {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "✨ Welcome to the Mage vs Warrior Battle Game! ✨");
        String mageName = JOptionPane.showInputDialog("Enter a name for the Mage:");
        String warriorName = JOptionPane.showInputDialog("Enter a name for the Warrior:");
        Mage mage = new Mage(mageName);
        Warrior warrior = new Warrior(warriorName);
        JOptionPane.showMessageDialog(null,
            "Battle starts! " + mage.name + " vs " + warrior.name + "\nBoth start with 100 HP.");
        while (mage.isAlive() && warrior.isAlive()) {
            String mageInput = JOptionPane.showInputDialog(
                mage.name + "'s turn! Choose a move:\n" +
                "[1] Fireball (20 dmg)\n" +
                "[2] Bind Curse (25 dmg)\n" +
                "[3] Arcane Explosion (30 dmg)"
            );
            int mageChoice = safeParse(mageInput);
            mage.attack(warrior, mageChoice);
            if (!warrior.isAlive()) break;
            String warInput = JOptionPane.showInputDialog(
                warrior.name + "'s turn! Choose a move:\n" +
                "[1] Sword Slash (15 dmg)\n" +
                "[2] Bladetrail (20 dmg)\n" +
                "[3] Bloodlust Strike (30 dmg)"
            );
            int warChoice = safeParse(warInput);
            warrior.attack(mage, warChoice);
        }
        // Winner
        String winner = mage.isAlive() ? mage.name : warrior.name;
        JOptionPane.showMessageDialog(null, "🎉 Game Over! " + winner + " wins the battle!");
    }
    private static int safeParse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return -1; // Invalid choice
        }
    }
}
# CCE-105
