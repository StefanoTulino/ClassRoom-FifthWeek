package com.corso.java.stringhe;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InsiemeDiStringhe s= new InsiemeDiStringhe();
        String [] array={"ciao","cdooo     ", "holjjhhhhhhhhjjaa ", "hihi"};
        s.setT(array);
       System.out.println("1"+  s.preStringa("cd"));
        System.out.println("2"+ s.spaziStringa());
        System.out.println("3"+ s.stringaLunga());
    }
}
