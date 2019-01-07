package database;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    protected static List<Horst> horsts = new ArrayList();

    public static void addHorst(Horst horst) {
        horsts.add(horst);
    }

    public static List getHorsts() {
        return horsts;
    }
}
