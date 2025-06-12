package com.mycompany.projetogaragem;

import com.mysql.cj.xdevapi.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jonata_carros")
@Getter
@Setter
@NoArgsConstructor
public class Carro {
    
    public void setDono(Cliente dono){
        this.dono = dono;
    }

    public Cliente getDono() {
        return dono;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "dono_id")
    private Cliente dono;

    private String modelo;
    private String placa;
    private String cor;

    private Carro(Builder builder) {
        this.modelo = builder.modelo;
        this.placa = builder.placa;
        this.cor = builder.cor;
    }

    public static class Builder{
         public String modelo;
         public String placa;
         public String cor;

         public Builder(){}

         public Builder addModelo(String modelo){

             this.modelo = modelo;
             return this;
         }

        public Builder addCor(String cor){

            this.cor = cor;
            return this;
        }

        public Builder addPlaca(String placa){

            this.placa = placa;
            return this;
        }

        public Carro build(){

             return new Carro(this);
         }
    }
}