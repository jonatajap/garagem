/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetogaragem;

/**
 *
 * @author Jona
 */
public class Vaga {

   
    private int idVaga;
    private boolean ocupada;
    private Carro carro;
    private long horaEntrada;
    
    

    public Vaga(int idVaga) {
        this.idVaga = idVaga;
        this.ocupada = false;
        this.carro = null;
    }

    // Ocupa a vaga
    public void ocupar(Carro carro) {
        this.setOcupada(true);
        this.setCarro(carro);
        this.setHoraEntrada(System.currentTimeMillis());  // Marca o horário de entrada
    }

    // Libera a vaga
    public void liberar() {
        this.setOcupada(false);
        this.setCarro(null);
    }

    // Verifica se a vaga está ocupada
    public boolean isOcupada() {
        return ocupada;
    }

    // Obtém a hora de entrada
    public long getHoraEntrada() {
        return horaEntrada;
    }

    // Obtém o carro que ocupa a vaga
    public Carro getCarro() {
        return carro;
    }
    
     /**
     * @param idVaga the idVaga to set
     */
    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    /**
     * @param ocupada the ocupada to set
     */
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(long horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    
}
