package ProgramowanieObiektowe.GryWojenne.Moves;

import ProgramowanieObiektowe.GryWojenne.General;
import ProgramowanieObiektowe.GryWojenne.Promotion;
import ProgramowanieObiektowe.GryWojenne.Soldier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuySoldier {
    public static void soldierAndRank(ArrayList<Soldier> soldierList, General general) throws IOException, ClassNotFoundException {
        System.out.println("Podaj ilość kupowanych żołnierzy");
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        System.out.println("Jaki stopień ma posiadać?");
        int rank = scan.nextInt();
        buySoldier(soldierList, general ,rank, amount);
    }
        public static void buySoldier(ArrayList<Soldier> soldierList,
                                      General general, int rank, int amount) throws IOException, ClassNotFoundException{
            if (rank < 5 && rank >= 0) {
                int soldierPrice = amount * (10 * rank);
                    if (soldierPrice > general.getGoldCoins()){
                        System.out.println("Sekretarz informuje: Za mało złotych monet" + '\n');
                    }
                    else {
                        general.setGoldCoins(general.getGoldCoins() - soldierPrice);
                        for (int i = 0; i < amount; i++) {
                            soldierList.add(new Soldier(Promotion.getEnum(rank), 1));
                        }
                        System.out.println("Sekretarz mówi: Żołnierz o stopniu " + rank + " został dodany w ilości: " + amount + '\n');
                        general.setSoldierAmount(soldierList.size());
                    }

                }
            else {
                System.out.println("Sekretarz informuje: Taka ranga nie istnieje");
                buySoldier(soldierList, general, rank, amount);
            }
        }
}
