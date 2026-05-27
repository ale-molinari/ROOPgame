package core.characters;

import core.world.Room;

public class CombatManager {

    private CombatManager() {};

    public static void executeBattle(Hero hero, Enemy enemy, Room room, MoveType moveType) {
        switch (moveType) {
            case BASE:
                hero.challenge(enemy);
                break;
            case SPECIAL:
                hero.specialMove(enemy);
        }
        if (enemy.isDead()) {
            System.out.println(enemy.getName() + " is dead");
            int exp = enemy.getExpReward();
            hero.gainExp(exp);
            room.removeEnemy(enemy);
            return;
        }
        if (enemy.getAttack()<=10) {
            enemy.specialMove(hero);
        } else {
            enemy.challenge(hero);
        }
        if (hero.isDead()) {
            System.out.println(hero.getName() + " is dead");
        }
    }
}
