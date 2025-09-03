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
}
# CCE-105
