/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetogaragem;

import com.mycompany.alugueis.alugueis.Aluguel;
import com.mycompany.carros.carros.Carro;
import com.mycompany.clientesj.clientesj.Clientej;
import br.unipac.garagens.garagens.Garagem;
import com.mycompany.vagas.vagas.Vaga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Jona
 */
public class ProjetoGaragem {//

     public static void main(String[] args) {
        Carro novoCarro = new Carro();
        novoCarro.setModelo("teste 2");
        
        System.out.println(novoCarro.getModelo());
    }
}
