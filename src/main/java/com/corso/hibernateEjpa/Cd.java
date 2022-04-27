package com.corso.hibernateEjpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cd {
    private Integer id;
    private String name;
    private Integer numberCd;
    private Integer idBrano;
    private Integer numBrani;



    public void addBrano(Brani b){
        this.idBrano=b.getId();
    }
}
