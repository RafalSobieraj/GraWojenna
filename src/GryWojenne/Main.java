package ProgramowanieObiektowe.GryWojenne;

import java.io.IOException;
import ProgramowanieObiektowe.GryWojenne.ArmyCreation;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArmyCreation armyCreation = new ArmyCreation();

        armyCreation.addTeamRedSoldier();
        armyCreation.addTeamBlueSoldier();

    }
}
