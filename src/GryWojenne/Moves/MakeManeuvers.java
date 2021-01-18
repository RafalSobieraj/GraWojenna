package ProgramowanieObiektowe.GryWojenne.Moves;

import ProgramowanieObiektowe.GryWojenne.General;
import ProgramowanieObiektowe.GryWojenne.Soldier;

import java.io.IOException;
import java.util.List;

public class MakeManeuvers {
    public static void makeManeuvers(List<Soldier> list,  General general) throws IOException, ClassNotFoundException {
        for (Soldier soldier : list) {
            soldier.setExperience(soldier.getExperience() + 1);
            System.out.println("Sekretarz mówi: Doświadczenie żołnierza zostało zwiększone");

           int cost = soldier.getMilitaryRank().getValue();
           general.setGoldCoins(general.getGoldCoins() - cost);
           System.out.println("Sekretarz mówi: Za manewry generał płaci " + cost + " złota");
        }
    }
    public static void goToPromotion(List<Soldier> list) throws IOException, ClassNotFoundException {
        SoldierExpAndDeath.promotion(list);
    }
}
