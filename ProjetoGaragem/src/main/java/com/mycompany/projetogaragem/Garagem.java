/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetogaragem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jona
 */
public class Garagem {

    private int idGaragem;
    private String localizacao;
    private List<Vaga> vagas;
    
    public Garagem(int idGaragem, String localizacao, int numVagas) {
        this.idGaragem = idGaragem;
        this.localizacao = localizacao;
        this.vagas = new ArrayList<>();
        for (int i = 1; i <= numVagas; i++) {
            vagas.add(new Vaga(i));  // Inicializa as vagas
        }
    }
    /**
     * @return the idGaragem
     */
    public int getIdGaragem() {
        return idGaragem;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @return the vagas
     */
    public List<Vaga> getVagas() {
        return vagas;
    }
    
     /**
     * @param idGaragem the idGaragem to set
     */
    public void setIdGaragem(int idGaragem) {
        this.idGaragem = idGaragem;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @param vagas the vagas to set
     */
    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
    
  
    // Método para procurar uma vaga disponível
    public Vaga procurarVagaDisponivel() {
        for (Vaga vaga : getVagas()) {
            if (!vaga.isOcupada()) {
                return vaga;
            }
        }
        return null;
    }

    // Método para listar todas as vagas ocupadas
    public List<Vaga> listarVagasOcupadas() {
        List<Vaga> vagasOcupadas = new ArrayList<>();
        for (Vaga vaga : getVagas()) {
            if (vaga.isOcupada()) {
                vagasOcupadas.add(vaga);
            }
        }
        return vagasOcupadas;
    }
}
