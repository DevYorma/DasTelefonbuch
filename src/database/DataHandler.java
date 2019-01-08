package database;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    protected static List<Entry> entries = new ArrayList();

    public static void addHorst(Entry entry) {
        entries.add(entry);
    }

    public static List getEntries() {
        return entries;
    }
}
