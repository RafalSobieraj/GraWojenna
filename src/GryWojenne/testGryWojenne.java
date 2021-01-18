package ProgramowanieObiektowe.GryWojenne;

import ProgramowanieObiektowe.GryWojenne.Moves.AttackOtherGeneral;
import ProgramowanieObiektowe.GryWojenne.Moves.BuySoldier;
import ProgramowanieObiektowe.GryWojenne.Moves.MakeManeuvers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


public class testGryWojenne {

    private final General general = new General();
    private final Soldier soldier = new Soldier();


    @Test
    public void testGeneralGold() {
        int input;
        general.setGoldCoins(10);
        input = general.getGoldCoins();
        Assertions.assertEquals(10, input);
    }

    @Test
    public void testSoldierStrength() {
        soldier.setExperience(5);
        soldier.setMilitaryRank(Promotion.SZEREGOWY);
        int exp = soldier.getExperience();
        int rank = soldier.getMilitaryRank().value;
        int strength = exp * rank;
        Assertions.assertEquals(5, strength);
    }


    @Test
    public void testGeneralSoldierBuy() throws IOException, ClassNotFoundException {
        {
            ArrayList<Soldier> soldierList = new ArrayList<>();
            General general = new General(100000, 4);
            BuySoldier.buySoldier(soldierList, general, 4, 2);
            Assert.assertEquals(2, general.getSoldierAmount());

        }
    }

    @Test
    public void testMakeManeuvers() throws IOException, ClassNotFoundException {
        ArrayList<Soldier> list = new ArrayList<>();
        Soldier soldier = new Soldier(Promotion.KAPITAN, 4);
        list.add(soldier);
        General general = new General(50, 5);
        MakeManeuvers.makeManeuvers(list, general);
    }

    @Test
    public void testAttackOtherGeneralWinner() throws IOException, ClassNotFoundException {
        ArrayList<Soldier> attackerList = new ArrayList<>();
        ArrayList<Soldier> defenderList = new ArrayList<>();
        Soldier soldier = new Soldier(Promotion.KAPITAN, 4);
        Soldier soldier1 = new Soldier(Promotion.KAPRAL, 5);
        Soldier soldier2 = new Soldier(Promotion.SZEREGOWY, 2);
        Soldier soldier3 = new Soldier(Promotion.MAJOR, 1);
        General general = new General(100, 2);
        General general1 = new General(78, 2);
        attackerList.add(soldier);
        attackerList.add(soldier1);
        defenderList.add(soldier2);
        defenderList.add(soldier3);
        AttackOtherGeneral.attackOtherGeneral(attackerList, defenderList, general, general1);
    }

    @Test
    public void testAttackOtherGeneralLoser() throws IOException, ClassNotFoundException {
        ArrayList<Soldier> attackerList = new ArrayList<>();
        ArrayList<Soldier> defenderList = new ArrayList<>();
        Soldier soldier = new Soldier(Promotion.KAPITAN, 2);
        Soldier soldier1 = new Soldier(Promotion.KAPRAL, 8);
        Soldier soldier2 = new Soldier(Promotion.SZEREGOWY, 4);
        Soldier soldier3 = new Soldier(Promotion.MAJOR, 10);
        General general = new General(100, 2);
        General general1 = new General(78, 2);
        attackerList.add(soldier);
        attackerList.add(soldier1);
        defenderList.add(soldier2);
        defenderList.add(soldier3);
        AttackOtherGeneral.attackOtherGeneral(attackerList, defenderList, general, general1);
    }

    @Test
    public void testAttackOtherGeneralDraw() throws IOException, ClassNotFoundException {
        ArrayList<Soldier> attackerList = new ArrayList<>();
        ArrayList<Soldier> defenderList = new ArrayList<>();
        Soldier soldier = new Soldier(Promotion.KAPITAN, 4);
        Soldier soldier1 = new Soldier(Promotion.KAPRAL, 6);
        Soldier soldier5 = new Soldier(Promotion.KAPRAL, 6);
        Soldier soldier2 = new Soldier(Promotion.MAJOR, 3);
        Soldier soldier3 = new Soldier(Promotion.MAJOR, 3);
        Soldier soldier4 = new Soldier(Promotion.KAPRAL, 6);
        General general = new General(100, 2);
        General general1 = new General(78, 2);
        attackerList.add(soldier);
        attackerList.add(soldier1);
        attackerList.add(soldier5);
        defenderList.add(soldier2);
        defenderList.add(soldier3);
        defenderList.add(soldier4);
        AttackOtherGeneral.attackOtherGeneral(attackerList, defenderList, general, general1);
    }
}
