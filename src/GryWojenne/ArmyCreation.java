package ProgramowanieObiektowe.GryWojenne;

import ProgramowanieObiektowe.GryWojenne.Moves.AttackOtherGeneral;
import ProgramowanieObiektowe.GryWojenne.Moves.BuySoldier;
import ProgramowanieObiektowe.GryWojenne.Moves.MakeManeuvers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static ProgramowanieObiektowe.GryWojenne.Promotion.SZEREGOWY;

public class ArmyCreation{

    static ArrayList<Soldier> soldiersRed = new ArrayList<>();
    static ArrayList<Soldier> soldiersBlue = new ArrayList<>();
    static General generalRed = new General();
    static General generalBlue = new General();

    public void addTeamRedGeneral() {
        generalRed= new General(100, soldiersRed.size());


        System.out.println("Generał Czerwonej Armii: " + generalRed.toString() + '\n');
        }

    public void addTeamBlueGeneral() throws IOException, ClassNotFoundException {
        generalBlue = new General(100, soldiersBlue.size());

        System.out.println("Generał Niebieskiej Armii: " + generalBlue.toString() + '\n');

        makeDecision();
    }

    public void addTeamRedSoldier() {

        Soldier soldier = new Soldier(
                SZEREGOWY,
                1
        );
        soldiersRed.add(soldier);

        Soldier soldier1 = new Soldier(
                SZEREGOWY,
                1
        );
        soldiersRed.add(soldier1);

        addTeamRedGeneral();
    }

    public void addTeamBlueSoldier() throws IOException, ClassNotFoundException {

        Soldier soldier = new Soldier(
                SZEREGOWY,
                1
        );
        soldiersBlue.add(soldier);


        Soldier soldier1 = new Soldier(
                SZEREGOWY,
                1
        );
        soldiersBlue.add(soldier1);

        addTeamBlueGeneral();
    }

    public static void makeDecision() throws IOException, ClassNotFoundException {
        System.out.println("Co chcesz zrobić?" + '\n' +
                "1. Kup żołnierza" + '\n' +
                "2. Wykonaj manewry" + '\n' +
                "3. Zaatakuj drugiego generała" + '\n' +
                "4. Wyświetl armię" + '\n' +
                "5. Zapisz stan armii" + '\n' +
                "6. Wczytaj stan armii" + '\n' +
                "7. Zakończ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if (input == 3) {
            System.out.println("Wybierz generała:" + '\n' +
                    "1. Blue" + '\n' +
                    "2. Red");
            Scanner scanner = new Scanner(System.in);
            int team = scanner.nextInt();
            if (team == 1) {
                AttackOtherGeneral.attackOtherGeneral(soldiersBlue, soldiersRed, generalBlue, generalRed);
                makeDecision();
            }
            else if (team == 2) {
                AttackOtherGeneral.attackOtherGeneral(soldiersRed, soldiersBlue, generalRed, generalBlue);
                makeDecision();
                }
            else {
                System.out.println("Podano błędne dane. Spróbuj jeszcze raz");
            }
        } else if (input == 2) {
            System.out.println("Wybierz generała:" + '\n' +
                    "1. Blue" + '\n' +
                    "2. Red");
            Scanner scanner1 = new Scanner(System.in);
            int team1 = scanner1.nextInt();
            if (team1 == 1){
                MakeManeuvers.makeManeuvers(soldiersBlue, generalBlue);
                MakeManeuvers.goToPromotion(soldiersBlue);
            }
            else if (team1 == 2){
                MakeManeuvers.makeManeuvers(soldiersRed, generalRed);
                MakeManeuvers.goToPromotion(soldiersRed);
            }
            else {
                System.out.println("Podano błędne dane. Spróbuj jeszcze raz");
            }
        }
        else if (input == 1) {
            System.out.println("Wybierz generała:" + '\n' +
                    "1. Blue" + '\n' +
                    "2. Red");
            Scanner scanner2 = new Scanner(System.in);
            int team2 = scanner2.nextInt();
            if (team2 == 1) {
                BuySoldier.soldierAndRank(soldiersBlue, generalBlue);
                makeDecision();
            }
            else if (team2 == 2) {
                BuySoldier.soldierAndRank(soldiersRed, generalRed);
                makeDecision();
            }
            else {
                System.out.println("Podano błędne dane. Spróbuj jeszcze raz");
            }
        }
        else if (input == 4){
            printArmy();
        }
        else if (input == 7){
            System.exit(1);
        }
        else if (input == 5){
            Army.save(Army.army());
            System.out.println("Armia została zapisana");
            ArmyCreation.makeDecision();
        }
        else if (input == 6){
            Army loadedArmy = Army.load();
            generalRed = loadedArmy.getGeneralRed();
            generalBlue = loadedArmy.getGeneralBlue();
            soldiersRed = loadedArmy.getSoldiersRed();
            soldiersBlue = loadedArmy.getSoldiersBlue();
            System.out.println("Wczytano poprzedni zapis");
            makeDecision();
        }

        else throw new UnsupportedOperationException("Podano błędne dane. Spróbuj jeszcze raz");
    }

    public static void printArmy() throws IOException, ClassNotFoundException {
        System.out.println("Blue Army: " + '\n' + "Generał Niebieskiej Armii: " + generalBlue.toString() + '\n');
        for (Soldier soldier : soldiersBlue)
            System.out.println(soldier.toString() + '\n');
        System.out.println("Red Army: " + '\n' + "Generał Czerwonej Armii: " + generalRed.toString() + '\n');
        for (Soldier soldier : soldiersRed)
            System.out.println(soldier.toString() + '\n');
        makeDecision();
    }
}
