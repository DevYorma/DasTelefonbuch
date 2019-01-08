package database;

import java.io.*;

import static database.DataHandler.entries;

public class FileHandler {
    private static String file = "/Users/database.csv";

    public static void readFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            entries = null;
            while((line = br.readLine()) != null) {
                String[] result = line.split(",");
                entries.add(new Entry(result[0], result[1], result[2], result[3], result[4], result[5], Integer.getInteger(result[6])));
            }
        } catch(IOException e) {
        }
    }

    public static void saveFile() {
        try(FileWriter fw = new FileWriter(file)) {
            for(Entry entry : entries) {
                fw.append(entry.getLastname());
                fw.append(",");
                fw.append(entry.getFirstname());
                fw.append(",");
                fw.append(entry.getPhonenumber());
                fw.append(",");
                fw.append(entry.getStreet());
                fw.append(",");
                fw.append(String.valueOf(entry.getHousenumber()));
                fw.append(",");
                fw.append(String.valueOf(entry.getPLZ()));
                fw.append(",");
                fw.append(entry.getTown());
            }
            fw.flush();
            fw.close();
        } catch(Exception e) {
        }
    }
}