package ProgramowanieObiektowe.GryWojenne;

import java.io.Serializable;
import java.util.Objects;

public class Soldier implements Serializable {
    private int experience;
    private Promotion MilitaryRank;


    public Promotion getMilitaryRank() {
        return MilitaryRank;
    }

    public void setMilitaryRank(Promotion militaryRank) {
        MilitaryRank = militaryRank;
    }

    public Soldier(Promotion militaryRank, int experience) {
        this.experience = experience;
        MilitaryRank = militaryRank;
    }

    public Soldier() {

    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrengthValue(){
        return (this.experience * this.MilitaryRank.value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soldier)) return false;
        Soldier soldier = (Soldier) o;
        return getMilitaryRank() == soldier.getMilitaryRank() &&
                getExperience() == soldier.getExperience();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMilitaryRank(), getExperience());
    }

    @Override
    public String toString() {
        return "Soldier: " +
                "Stopień wojskowy= " + MilitaryRank +
                ", Doświadczenie= " + experience +
                ", Siła= " + getStrengthValue();
    }
}

