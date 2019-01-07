package database;

import java.io.*;

import static database.DataHandler.horsts;

public class FileHandler {
    private static String file = "/Users/database.csv";

    public static void readFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            horsts = null;
            while((line = br.readLine()) != null) {
                String[] result = line.split(",");
                horsts.add(new Horst(result[0], result[1], result[2], result[3], result[4], result[5], Integer.getInteger(result[6])));
            }
        } catch(IOException e) {
        }
    }

    public static void saveFile() {
        try(FileWriter fw = new FileWriter(file)) {
            for(Horst horst : horsts) {
                fw.append(horst.getLastname());
                fw.append(",");
                fw.append(horst.getFirstname());
                fw.append(",");
                fw.append(horst.getPhonenumber());
                fw.append(",");
                fw.append(horst.getStreet());
                fw.append(",");
                fw.append(String.valueOf(horst.getHousenumber()));
                fw.append(",");
                fw.append(String.valueOf(horst.getPLZ()));
                fw.append(",");
                fw.append(horst.getTown());
            }
            fw.flush();
            fw.close();
        } catch(Exception e) {
        }
    }
}
