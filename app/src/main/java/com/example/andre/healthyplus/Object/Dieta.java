package com.example.andre.healthyplus.Object;

public class Dieta {
    private Desayuno des;
    private Almuerzo almu;
    private Merienda meri;
    private Cena cena;

    public Dieta(Desayuno desayuno, Almuerzo almu, Merienda mer, Cena cena) {
    }
    public Desayuno getDes() {
        return des;
    }

    public void setDes(Desayuno des) {
        this.des = des;
    }

    public Almuerzo getAlmu() {
        return almu;
    }

    public void setAlmu(Almuerzo almu) {
        this.almu = almu;
    }

    public Merienda getMeri() {
        return meri;
    }

    public void setMeri(Merienda meri) {
        this.meri = meri;
    }

    public Cena getCena() {
        return cena;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }
}
