package com.example.andre.healthyplus;

import com.example.andre.healthyplus.Object.Almuerzo;
import com.example.andre.healthyplus.Object.Cena;
import com.example.andre.healthyplus.Object.Desayuno;
import com.example.andre.healthyplus.Object.Dieta;
import com.example.andre.healthyplus.Object.Merienda;

public class Dietario {

    private Desayuno des;
    private Almuerzo almu;
    private Merienda meri;
    private Cena cen;

    public Dietario(Desayuno desayuno, Almuerzo almu, Merienda mer, Cena cena) {
        des = desayuno;
        almu = almu;
        meri = mer;
        cen = cena;
    }
    public Dietario() {
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
        return cen;
    }

    public void setCena(Cena cen) {
        this.cen = cen;
    }
    Dietario desayuno = null;
    Dietario almuerzo = null;
    Dietario merienda = null;
    Dietario cena = null;
    Desayuno desayunos[] = new Desayuno[3];
    Almuerzo almuerzos[] = new Almuerzo[3];
    Merienda meriendas[] = new Merienda[3];
    Cena cenas[] = new Cena[3];
    Dietario dietario[] =  new Dietario[3];

    public Desayuno generarDesa(){
        desayunos[0] = new Desayuno("Leche de almendras (1 vaso)\n"+"Pan integral (1)\n"+"Queso blanco (1)");
        desayunos[1] = new Desayuno("Yogurt descremado\n" +
                "Galletas ducales (4)");
        desayunos[2] = new Desayuno("Batido\n" +
                "Fajita integral con queso y jamón");
        int i = (int) (Math.random() * 2);
        Desayuno desayuno = desayunos[i];
        return desayuno;
    }

    public Almuerzo generarAlmu(){
        almuerzos[0] = new Almuerzo("Pechuga de pollo, carne, cerdo o pescado a la plancha\n"+"Arroz integral (3 cucharadas)\n"+
                "Ensalada de repollo, tomatte y remolacha rallada\n"+
                "Naranja (1)");
        almuerzos[1] = new Almuerzo("Pescado cocido\n" +
                "Papas\n" +
                "Ensalada de coles\n" +
                "Patilla");
        almuerzos[2] = new Almuerzo("Filete de pollo, carne o cerdo con\n" +
                "verduras\n" +
                "Ensalada de zanahoria y brocoli\n" +
                "Fresas (1/2 taza)");
        int i = (int) (Math.random() * 2);
        return almuerzos[i];
    }

    public Merienda generarMeri(){
        meriendas[0] = new Merienda("Yogurt descremado\n" +
                "Nuez (5)");
        meriendas[1] = new Merienda("Pan\n" +
                "Queso\n" +
                "Nueces (5)");
        meriendas[2] = new Merienda("Jugo detox con naranja, piña y linaza\n" +
                "Maní (10)");
        int i = (int) (Math.random() * 2);
        return meriendas[i];
    }

    public Cena generarCena(){
        cenas[0] = new Cena("Pescado cocido\n" +
                "Papas\n" +
                "Ensalada de coles\n" +
                "Patilla");
        cenas[1] = new Cena("Filete de pollo, carne o cerdo con\n" +
                "verduras\n" +
                "Ensalada de zanahoria y brocoli\n" +
                "Fresas (1/2 taza)");
        cenas[2] = new Cena("Pollo, carne, cerdo o pescado\n" +
                "Papa\n" +
                "Ensalada\n" +
                "Naranja (1)");
        int i = (int) (Math.random() * 2);
        return cenas[i];
    }

    public Dietario  generarDieta (){

        dietario[0] = new Dietario(desayuno.generarDesa(),almuerzo.generarAlmu(), merienda.generarMeri()
        ,cena.generarCena());
        dietario[1] = new Dietario(desayuno.generarDesa(),almuerzo.generarAlmu(), merienda.generarMeri()
                ,cena.generarCena());
        dietario[2] = new Dietario(desayuno.generarDesa(),almuerzo.generarAlmu(), merienda.generarMeri()
                ,cena.generarCena());
        int i = (int) (Math.random() * 2);
        return dietario[i];
    }
}
