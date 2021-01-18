package ProgramowanieObiektowe.GryWojenne.Moves;

import ProgramowanieObiektowe.GryWojenne.General;
import ProgramowanieObiektowe.GryWojenne.Soldier;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class AttackOtherGeneral {
    public static void attackOtherGeneral(List<Soldier> attackerList,
                                          List<Soldier> defenderList,
                                          General attackerGeneral,
                                          General defenderGeneral) throws IOException, ClassNotFoundException {

        int strengthSumDefender = 0;
        int strengthSumAttacker = 0;
        for (Soldier soldierDefender : defenderList) {
            strengthSumDefender += soldierDefender.getStrengthValue();
        }
        for (Soldier soldierAttacker : attackerList) {
            strengthSumAttacker += soldierAttacker.getStrengthValue();
        }

        if (strengthSumAttacker > strengthSumDefender) {
            System.out.println("Sekretarz mówi: Atakujący wygrał walkę");
            int money = (int) (defenderGeneral.getGoldCoins() * 0.9);
            attackerGeneral.setGoldCoins((int) (attackerGeneral.getGoldCoins() + defenderGeneral.getGoldCoins() * 0.1));
            defenderGeneral.setGoldCoins(money);
            for (Soldier soldierDefender : defenderList) {
                soldierDefender.setExperience(soldierDefender.getExperience() - 1);
            }
            for (Soldier soldierAttacker : attackerList) {
                soldierAttacker.setExperience(soldierAttacker.getExperience() + 1);


            }
            SoldierExpAndDeath.promotion(attackerList);
            SoldierExpAndDeath.SoldierDeath(defenderList, defenderGeneral);
        } else if (strengthSumAttacker < strengthSumDefender) {
            System.out.println("Sekretarz mówi: Atakujący przegrał walkę");
            int money = (int) (attackerGeneral.getGoldCoins() * 0.9);
            attackerGeneral.setGoldCoins(money);
            defenderGeneral.setGoldCoins(defenderGeneral.getGoldCoins() + money);
            for (Soldier soldierDefender : defenderList) {
                soldierDefender.setExperience(soldierDefender.getExperience() + 1);
            }
            for (Soldier soldierAttacker : attackerList) {
                soldierAttacker.setExperience(soldierAttacker.getExperience() - 1);
            }
            SoldierExpAndDeath.promotion(defenderList);
            SoldierExpAndDeath.SoldierDeath(attackerList, attackerGeneral);
        } else if (strengthSumAttacker == strengthSumDefender) {
            draw(attackerList, defenderList, attackerGeneral, defenderGeneral);
        }
    }

    public static void draw(List<Soldier> attackerList, List<Soldier> defenderList ,
                            General generalAttacker, General generalDefender) throws IOException, ClassNotFoundException {
        System.out.println("Sekretarz mówi: Walka zakończona remisem");
        Random random = new Random();
        Soldier soldierAttacker = attackerList.get(random.nextInt(attackerList.size()));
        Soldier soldierDefender = defenderList.get(random.nextInt(attackerList.size()));

        attackerList.remove(soldierAttacker);
        defenderList.remove(soldierDefender);

        generalAttacker.setSoldierAmount(attackerList.size());
        System.out.println("Sekretarz mówi: Żołnierz został roztrzelany.");
        generalDefender.setSoldierAmount(defenderList.size());
        System.out.println("Sekretarz mówi: Żołnierz został roztrzelany.");
    }
}

