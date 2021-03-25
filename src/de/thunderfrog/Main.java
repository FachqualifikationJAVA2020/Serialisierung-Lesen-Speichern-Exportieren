package de.thunderfrog;

public class Main {
    public static void main(String[] args) {
        //  Gerichte
        Gericht gericht = new Gericht("Schnitzel Wienerart", 4.99);
        Gericht gericht1 = new Gericht("Chilli", 3.99);
        Gericht gericht2 = new Gericht("Hähnchengeschnetzeltes", 7.99);

        //  Output Gericht
        System.out.println("Mein Gericht: " + gericht);
        System.out.println("Mein Gericht: " + gericht1);
        System.out.println("Mein Gericht: " + gericht2);

        //  Save to .csv
        System.out.println(".csv SAVE!");
        Speisekarte.exportMenu(gericht);
        Speisekarte.exportMenu(gericht1);
        Speisekarte.exportMenu(gericht2);

        //  Load from .csv to Arraylist<Gericht> menu
        Speisekarte.importMenu();

        //  Output ArrayList<Gericht> menu
        System.out.println("Load from .csv:" + Speisekarte.getMenu());

        //  Save to .obj
        // System.out.println(".obj SAVE!");
        Speisekarte.saveMenu(Speisekarte.getMenu());

        //  Load from .obj to ArrayList<Gericht> menu
         Speisekarte.loadMenu();

        //  Output ArrayList<Gericht> menu
        System.out.println("Load From .obj" + Speisekarte.getMenu());
    }
}
