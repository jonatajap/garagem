package com.mycompany.projetogaragem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jonata_alugueis")
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
        this.horaInicio = System.currentTimeMillis();
    }

    public void finalizarAluguel(long adcionarHora) {
        this.horaFim = System.currentTimeMillis() + adcionarHora;
        long duracao = horaFim - horaInicio;
        this.valorTotal = calcularValor(duracao);
        vagaLiberar();
    }

    private double calcularValor(long duracaoMillis) {

        if (duracaoMillis > 3600000){
        double horas = duracaoMillis / 3600000.0;
        double valor = horas * 10.0;
        return Math.round(valor * 100.0) / 100.0; // Arredonda para 2 casas decimais
        }
        else {
            return 10;
        }
    }

    public void vagaOcupar() {
        if (this.cliente.getCarro() == null || this.vaga.isOcupada()) {

            throw new IllegalStateException("Nenhum Carro Associado ao Cliente ou Vaga Ocupada");
        }
        else{
            this.vaga.setOcupada(true);
            this.vaga.setCarro(cliente.getCarro());
        }
    }

    public void vagaLiberar() {
        this.vaga.setOcupada(false);
        this.vaga.setCarro(null);
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public long getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(long horaInicio) {
        this.horaInicio = horaInicio;
    }

    public long getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(long horaFim) {
        this.horaFim = horaFim;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}