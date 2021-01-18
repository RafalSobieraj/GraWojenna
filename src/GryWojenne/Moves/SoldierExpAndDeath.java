package ProgramowanieObiektowe.GryWojenne.Moves;

import ProgramowanieObiektowe.GryWojenne.General;
import ProgramowanieObiektowe.GryWojenne.Promotion;
import ProgramowanieObiektowe.GryWojenne.Soldier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoldierExpAndDeath {
    public static void promotion(List<Soldier> winnerList) throws IOException, ClassNotFoundException {
        for (Soldier soldiers : winnerList) {
            if (soldiers.getExperience() >= soldiers.getMilitaryRank().getValue() * 5) {
                if (soldiers.getMilitaryRank().getValue() < 4) {
                    soldiers.setMilitaryRank(Promotion.getEnum(soldiers.getMilitaryRank().getValue() + 1));
                    System.out.println("Sekretarz mówi: Żołnierz awansował na rangę " + soldiers.getMilitaryRank());
                }
                soldiers.setExperience(1);
            }
        }
    }

    public static void SoldierDeath(List<Soldier> list, General general) throws IOException, ClassNotFoundException {
        List<Soldier> soldierDeath = new ArrayList<>();
        for (Soldier soldier : list) {
                if (soldier.getExperience() == 0) {
                    soldierDeath.add(soldier);
                    System.out.println("Sekretarz mówi: Żołnierz został zabity");
                }
            }
        list.removeAll(soldierDeath);
        general.setSoldierAmount(list.size());
    }
}
