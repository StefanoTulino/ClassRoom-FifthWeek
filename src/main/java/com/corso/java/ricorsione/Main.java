package com.corso.java.ricorsione;
/*
Il seguente esercizio si propone di risolvere la concatenazione di due stringhe,
fondere cioè una stringa con un’altra. Per far ciò, si crea un oggetto di classe
Concatenazione avente come parametri espliciti due stringhe, disposte
nell’ordine con cui verranno unite. Poi si crea un metodo che restituisce una
nuova stringa frutto della concatenazione delle due stringhe.
 */
public class Main {

    public static void main(String[] args) {
        Concatenazione c=new Concatenazione("ciao","1234");
        System.out.println(c.print());
    }
}
