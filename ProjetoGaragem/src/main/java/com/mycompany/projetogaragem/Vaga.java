package com.mycompany.projetogaragem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vagas")
@Getter
@Setter
@NoArgsConstructor
public class Vaga {

    @Id
    private int idVaga;

    private boolean ocupada;

    @OneToOne(cascade = CascadeType.ALL)
    private Carro carro;

    private long horaEntrada;

    public Vaga(int idVaga) {
        this.idVaga = idVaga;
        this.ocupada = false;
        this.carro = null;
    }

    public void ocupar(Carro carro) {
        this.ocupada = true;
        this.carro = carro;
        this.horaEntrada = System.currentTimeMillis();
    }

    public void liberar() {
        this.ocupada = false;
        this.carro = null;
    }
}