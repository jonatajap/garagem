/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetogaragem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jona
 */
public class Aluguel {

   
    private Cliente cliente;
    private Vaga vaga;
    private long horaInicio;
    private long horaFim;
    private double valorTotal;
    
      /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @return the vaga
     */
    public Vaga getVaga() {
        return vaga;
    }

    /**
     * @return the horaInicio
     */
    public long getHoraInicio() {
        return horaInicio;
    }

    /**
     * @return the horaFim
     */
    public long getHoraFim() {
        return horaFim;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }
    
      /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @param vaga the vaga to set
     */
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(long horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(long horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}

   