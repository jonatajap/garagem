package com.mycompany.projetogaragem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jonata_vagas")
@Getter
@Setter
@NoArgsConstructor
public class Vaga {

    @Id
    private int vaga_id;

    private boolean ocupada;

    @OneToOne(cascade = CascadeType.ALL)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "garagem_id")
    private Garagem garagem;

    public Vaga(int idVaga, Garagem garagem) {
        this.vaga_id = idVaga;
        this.ocupada = false;
        this.carro = null;
        this.garagem = garagem;
    }

}