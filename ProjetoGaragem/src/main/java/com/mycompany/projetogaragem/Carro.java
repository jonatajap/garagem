/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetogaragem;

mport jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "carros")
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Carro {

/**
 *
 * @author Jona
 */
public class Carro {
    
    private String modelo;
    private String placa;
    private String cor;
    
    
    // Abaixo método costrutor
    public Carro(String modelo, String placa, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }
    
     
    public Carro() {
       
    }


    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

  
    // FIM do método costrutor

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }
    
    

}
