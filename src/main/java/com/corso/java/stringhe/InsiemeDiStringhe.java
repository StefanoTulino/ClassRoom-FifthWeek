package com.corso.java.stringhe;

import java.util.ArrayList;
import java.util.List;

public class InsiemeDiStringhe {

  private String value;
  private String[] T;


public InsiemeDiStringhe(){

}

public InsiemeDiStringhe(int max ){
    this.T=new String[max];
}


    //1
    public String stringaLunga(){
        String count="";
        for(int i=0;i<T.length;i++){
            this.value= T[i];
            if(this.value.length()>count.length())
                count=this.value;
        }
        return count;
    }


    //2
    public String spaziStringa(){
        String spazi="";
        int count=0;
        int temp=0;
        for(String s: T){
                temp = (int) s.chars().filter(value1 -> value1== ' ').count();
                if(count<temp) {
                    count = temp;
                    spazi = s;
                }
            }
            return spazi;
    }

    public List<String> preStringa(String prefix){
        List<String> list=new ArrayList<>();
        for(int i=0;i<T.length;i++){
            this.value= T[i];

            if(value.startsWith(prefix))
                list.add(this.value);
            }
            return list;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getT() {
        return T;
    }

    public void setT(String[] t) {
        T = t;
    }

}
