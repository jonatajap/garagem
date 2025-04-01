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

    // Método para procurar uma vaga disponível
    public Vaga procurarVagaDisponivel() {
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada()) {
                return vaga;
            }
        }
        return null;
    }

    // Método para listar todas as vagas ocupadas
    public List<Vaga> listarVagasOcupadas() {
        List<Vaga> vagasOcupadas = new ArrayList<>();
        for (Vaga vaga : vagas) {
            if (vaga.isOcupada()) {
                vagasOcupadas.add(vaga);
            }
        }
        return vagasOcupadas;
    }
}
