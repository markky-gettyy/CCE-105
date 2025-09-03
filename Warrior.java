package JFRAME;
import javax.swing.JOptionPane;


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
}

