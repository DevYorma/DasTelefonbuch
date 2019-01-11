package database;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    protected static List<Entry> entries = new ArrayList();

    public static void addEntry(Entry entry) {
        entries.add(entry);
        FileHandler.saveFile();
    }

    public static void removeEntry(Entry entry) {
        entries.remove(entry);
        FileHandler.saveFile();
    }

    public static List getEntries() {
        FileHandler.readFile();
        return entries;
    }
}
