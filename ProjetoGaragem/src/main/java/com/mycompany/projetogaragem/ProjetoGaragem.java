/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetogaragem;
import br.unipac.alugueis.alugueis.Aluguel;
import br.unipac.aeroportos.aeroporto.Bilhete;
import br.unipac.aeroportos.aeroporto.Passageiro;
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
