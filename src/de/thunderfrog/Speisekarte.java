package de.thunderfrog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Speisekarte {

    //  User HomeDir
    private static final String homeDir = System.getProperty("user.home");
    //  Object Save File
    private static final File objFile = new File(homeDir + "\\Desktop\\Speisekarte.obj");
    //  CSV Save File
    private static final File csvfile = new File(homeDir + "\\Desktop\\Speisekarte.csv");

    //  Arraylist Menu
    private static List<Gericht> menu = new ArrayList<>();

    public static List<Gericht> getMenu() {
        return menu;
    }

    //  Save to .csv File
    public static void exportMenu(Gericht g){
        try{
            FileWriter fw = new FileWriter(csvfile,true);
            fw.write(g.getName() + ";" + g.getPreis());
            fw.write("\r\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Load from .csv File
    public static void importMenu(){
        try{
            FileReader fr = new FileReader(csvfile);
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            while((line = br.readLine()) != null){
                String[] attributes = line.split(";");
                Gericht gericht = new Gericht(attributes[0],Double.parseDouble(String.valueOf(attributes[1])));
                menu.add(gericht);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Save to .obj File
    public static void saveMenu(List<Gericht> menu){
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(objFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //  Save to File
            for(Gericht g: menu){
                oos.writeObject(g);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Load from .obj File
    public static void loadMenu(){
        Gericht g = null;

        try{
            FileInputStream fis = new FileInputStream(objFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while((g = (Gericht)ois.readObject()) != null){
                menu.add(g);
            }

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
