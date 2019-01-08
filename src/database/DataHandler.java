package database;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    protected static List<Entry> entries = new ArrayList();

    public static void addEntry(Entry entry) {
        entries.add(entry);
    }

    public static void removeEntry(Entry entry) { entries.remove(entry); }

    public static boolean editEntry(Entry entry, String field, String value) {
        entries.remove(entry);
        if(field.equalsIgnoreCase("firstname")) {
            entry.setFirstname(value);
            entries.add(entry);
            return true;
        }
        if(field.equalsIgnoreCase("lastname")) {
            entry.setLastname(value);
            entries.add(entry);
            return true;
        }
        if(field.equalsIgnoreCase("phonenumber")) {
            entry.setPhonenumber(value);
            entries.add(entry);
            return true;
        }
        if(field.equalsIgnoreCase("street")) {
            entry.setStreet(value);
            entries.add(entry);
            return true;
        }
        if(field == "housenumber") {
            entry.setHousenumber(value);
            entries.add(entry);
            return true;
        }
        if(field == "town") {
            entry.setTown(value);
            entries.add(entry);
            return true;
        }
        if(field == "plz") {
            entry.setPLZ(Integer.valueOf(value));
            entries.add(entry);
            return true;
        }
        return false;
    }

    public static List getEntries() {
        return entries;
    }
}
