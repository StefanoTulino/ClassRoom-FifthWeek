package com.corso.java.ricorsione;

public class Concatenazione {

    private String str1;
    private String str2;

    public Concatenazione(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }



    //Ricorsione
    public String print(){
        String finale="";

        //Caso base
        if( str2 == "")
            return str1;
        else {
                this.str1+=str2.charAt(0);
                this.str2= str2.substring(1);
            }
        return print();
        }

}
