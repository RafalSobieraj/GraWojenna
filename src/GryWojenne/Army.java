package ProgramowanieObiektowe.GryWojenne;

import java.io.*;
import java.util.ArrayList;

public class Army implements Serializable {
    General generalRed;
    General generalBlue;
    ArrayList<Soldier> soldiersRed;
    ArrayList<Soldier> soldiersBlue;

    public Army(General generalRed, General generalBlue, ArrayList<Soldier> soldiersRed, ArrayList<Soldier> soldiersBlue) {
        this.generalRed = generalRed;
        this.generalBlue = generalBlue;
        this.soldiersRed = soldiersRed;
        this.soldiersBlue = soldiersBlue;
    }

    public General getGeneralRed() {
        return generalRed;
    }

    public General getGeneralBlue() {
        return generalBlue;
    }

    public ArrayList<Soldier> getSoldiersRed() {
        return soldiersRed;
    }

    public ArrayList<Soldier> getSoldiersBlue() {
        return soldiersBlue;
    }

    public static Army army() {
        General generalRed = ArmyCreation.generalRed;
        General generalBlue = ArmyCreation.generalBlue;
        ArrayList<Soldier> soldiersRed = ArmyCreation.soldiersRed;
        ArrayList<Soldier> soldiersBlue = ArmyCreation.soldiersBlue;
        return new Army(generalRed, generalBlue, soldiersRed, soldiersBlue);
    }

    public static void save(Army army) throws IOException, ClassNotFoundException {
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("general.bin"));
         out.writeObject(army);
         out.close();
     }

     public static Army load() throws IOException, ClassNotFoundException {
         ObjectInputStream in = new ObjectInputStream(new FileInputStream("general.bin"));
         Object loadedArmy = in.readObject();
         Army army = (Army) loadedArmy;
         in.close();
         return army;
     }
}
