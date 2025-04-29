package com.mycompany.projetogaragem;

import com.mycompany.projetogaragem.model.*;

public class ProjetoGaragem {

    public static void main(String[] args) {
        Carro carro = new Carro("Gol", "ABC-1234", "Prata");
        Cliente cliente = new Cliente("João", "12345678900", "99999-0000");
        cliente.cadastrarCarro(carro);

        Garagem garagem = new Garagem("Centro", 5);
        Vaga vaga = garagem.procurarVagaDisponivel();

        if (vaga != null) {
            vaga.ocupar(carro);
            Aluguel aluguel = new Aluguel(cliente, vaga);

            System.out.println("Vaga ocupada por: " + cliente.getNome());

            aluguel.finalizarAluguel();
            System.out.println("Aluguel finalizado. Valor: R$" + aluguel.getValorTotal());
        } else {
            System.out.println("Sem vagas disponíveis.");
        }
    }
}