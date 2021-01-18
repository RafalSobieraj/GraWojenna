package ProgramowanieObiektowe.GryWojenne;

import java.io.Serializable;
import java.util.Objects;

public class General implements Serializable {

    private int goldCoins;

    public General() {

    }

    public int getSoldierAmount() {
        return soldierAmount;
    }

    public void setSoldierAmount(int soldierAmount) {
        this.soldierAmount = soldierAmount;
    }

    private int soldierAmount;

    public General(int goldCoins, int soldierAmount) {
        this.goldCoins = goldCoins;
        this.soldierAmount = soldierAmount;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof General)) return false;
        General general = (General) o;
        return getGoldCoins() == general.getGoldCoins() &&
                Objects.equals(getSoldierAmount(), general.getSoldierAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoldCoins(), getSoldierAmount());
    }

    @Override
    public String toString() {
        return "Złote monety= " + goldCoins +
                ", Liczba żołnierzy= " + soldierAmount;

    }
}
