package ProgramowanieObiektowe.GryWojenne;

import java.util.Arrays;
import java.util.List;

public enum Promotion {

    SZEREGOWY(1),
    KAPRAL(2),
    KAPITAN(3),
    MAJOR(4);


    int value;

    public int getValue() {
        return value;
    }

    public static Promotion getEnum(int rank) {
        switch (rank) {
            case 1: {
                return SZEREGOWY;
            }
            case 2: {
                return KAPRAL;
            }
            case 3: {
                return KAPITAN;
            }
            case 4: {
                return MAJOR;
            }
        }
        return null;
    }

    Promotion(int value) {
        this.value = value;
    }

    public static List<Promotion> getAllpromotions(){
        return Arrays.asList(SZEREGOWY, KAPRAL, KAPITAN, MAJOR);
    }
}
