package de.thunderfrog;

import java.io.Serial;
import java.io.Serializable;

public class Gericht implements Serializable {

    @Serial
    private static final long serialVersionUID = 2767186812265037785L;

    private String name;
    private double preis;

    public Gericht(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Preis: " + preis;
    }
}
