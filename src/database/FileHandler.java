package database;

import java.io.*;
import java.util.ArrayList;

import static database.DataHandler.entries;

public class FileHandler {
    private static String[] split = FileHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("\\\\");
    private static String path = FileHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(split[split.length-1], "") + "database.csv";
    private static File file = new File(path);

    public static void readFile() {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            entries = new ArrayList<Entry>();
            while((line = br.readLine()) != null) {
                String[] result = line.split(",");
                entries.add(new Entry(result[0], result[1], result[2], result[3], result[4], result[5], result[6]));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile() {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(FileWriter fw = new FileWriter(file)) {
            for(Entry entry : entries) {
                fw.append(entry.getFirstname());
                fw.append(",");
                fw.append(entry.getLastname());
                fw.append(",");
                fw.append(entry.getPhonenumber());
                fw.append(",");
                fw.append(entry.getStreet());
                fw.append(",");
                fw.append(entry.getHousenumber());
                fw.append(",");
                fw.append(entry.getTown());
                fw.append(",");
                fw.append(entry.getPostcode());
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch(Exception e) {
        }
    }
}
