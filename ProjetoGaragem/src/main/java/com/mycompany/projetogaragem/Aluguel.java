package com.mycompany.projetogaragem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alugueis")
@Getter
@Setter
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Vaga vaga;

    private long horaInicio;
    private long horaFim;
    private double valorTotal;

    public Aluguel(Cliente cliente, Vaga vaga) {
        this.cliente = cliente;
        this.vaga = vaga;
        this.horaInicio = System.currentTimeMillis();
    }

    public void finalizarAluguel() {
        this.horaFim = System.currentTimeMillis();
        long duracao = horaFim - horaInicio;
        this.valorTotal = calcularValor(duracao);
        this.vaga.liberar();
    }

    private double calcularValor(long duracaoMillis) {
        double horas = duracaoMillis / 3600000.0;
        return horas * 10.0;
    }
}