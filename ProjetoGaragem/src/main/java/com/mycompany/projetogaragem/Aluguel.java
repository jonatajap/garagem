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

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    private long horaInicio;
    private long horaFim;
    private double valorTotal;

    public Aluguel(Cliente cliente, Vaga vaga) {
        this.cliente = cliente;
        this.vaga = vaga;
    }

    public void finalizarAluguel() {
        this.horaFim = System.currentTimeMillis();
        long duracao = horaFim - horaInicio;
        this.valorTotal = calcularValor(duracao);
        vagaLiberar();
    }

    private double calcularValor(long duracaoMillis) {

        if (duracaoMillis > 3600000){
        double horas = duracaoMillis / 3600000.0;
        return horas * 10.0;
        }
        else {
            return 10;
        }
    }

    public void vagaOcupar() {
        if (this.cliente.getCarro() == null && this.vaga.isOcupada()) {
            this.vaga.setOcupada(true);
            this.vaga.setCarro(cliente.getCarro());
        }
        else{
            throw new IllegalStateException("Nenhum Carro Associado ao Cliente ou Vaga Ocupada");
        }
    }

    public void vagaLiberar() {
        this.vaga.setOcupada(false);
        this.vaga.setCarro(null);
    }
}