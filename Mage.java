package JFRAME;
import javax.swing.JOptionPane;

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
    }
}
# CCE-105
