package com.mycompany.projetogaragem;

import com.mycompany.forms.*;
import jakarta.persistence.*;

import java.util.List;

public class ProjetoGaragem {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
        new TelaInicial().setVisible(true);
        });
    }

    //simula o processo de cadastrar clientes, carros, garagem e vagas.
    public static void adicionandoValores1() {

        // Criação da fábrica e gerenciador de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("umbler_database");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Criação dos carros
        Carro.Builder builderC1= new Carro.Builder();
        builderC1.addPlaca("XXXX-YYYY").addCor("Preto").addModelo("Corsa");
        Carro carro1 = builderC1.build();

        Carro.Builder builderC2= new Carro.Builder();
        builderC1.addPlaca("PPPP-CCCC").addCor("Branco").addModelo("Fusca");
        Carro carro2 = builderC1.build();

        // Criação dos clientes e Relacionamento entre seus respectivos carros
        Cliente cliente1 = new Cliente(
                "Carlos",
                "12345678900",
                "99999-0000");

        cliente1.cadastrarCarro(carro1);

        Cliente cliente2 = new Cliente(
                "Jose",
                "99999999999",
                "00000-0000");

        cliente2.cadastrarCarro(carro2);


        // Criação da garagem
        Garagem garagem = new Garagem("Centro", 5);

        em.persist(garagem);

        //Criação das Vagas relacionadas com a garagem
        Vaga vaga1 = garagem.getVagas().get(0);
        Vaga vaga2 = garagem.getVagas().get(1);


        //Inserção dos dados no BD
        em.persist(garagem);

        em.persist(carro1);
        em.persist(carro2);

        em.persist(cliente1);
        em.persist(cliente2);

        em.persist(vaga1);
        em.persist(vaga2);

        //Criação e inserção dos dados do aluguel
        Aluguel aluguel2 = new Aluguel(cliente2, vaga2);

        aluguel2.vagaOcupar();
        aluguel2.finalizarAluguel(7200000);

        em.persist(aluguel2);
        em.persist(cliente2);
        em.persist(vaga2);

        Aluguel aluguel1 = new Aluguel(cliente1, vaga1);

        aluguel1.vagaOcupar();

        em.persist(aluguel1);
        em.persist(cliente1);
        em.persist(vaga1);

        //Finaliza as transações e fechas as conexões
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void puxandoDados() {

        System.out.println("Buscando os Clientes...\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("umbler_database");
        EntityManager em = emf.createEntityManager();

        // Quantidade de clientes (JPQL Dinâmica)
        Query qtd = em.createQuery("SELECT COUNT(c) FROM Cliente c");
        long qtdClientes = (long)qtd.getSingleResult();
        System.out.println("Quantidade de Clientes: " + qtdClientes + "\n---");

        // Buscar todos os clientes (Named Querry)
        TypedQuery<Cliente> queryTodos = em.createNamedQuery("Cliente.buscaTodos", Cliente.class);
        List<Cliente> todos = queryTodos.getResultList();


        System.out.println("Todos os clientes:\n -----");
        for (Cliente c : todos) {
            System.out.println("Nome: " + c.getNome() + "\nCPF: " + c.getCpf() + "\nContato: " + c.getContato() + "\n-----");
        }

        // Buscar clientes por nome (Named Querry)
        TypedQuery<Cliente> queryPorNome = em.createNamedQuery("Cliente.buscaNome", Cliente.class);
        queryPorNome.setParameter("nome", "Carlos");
        List<Cliente> encontrados = queryPorNome.getResultList();

        System.out.println("Clientes com nome Carlos:\n-----");
        for (Cliente encontrado : encontrados) {

            System.out.println("Nome: " + encontrado.getNome() + "\nCPF: " + encontrado.getCpf() + "\nContato: " + encontrado.getContato() + "\n-----");
        }

        emf.close();
        em.close();
    }

    public static void atualizarDados(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("umbler_database");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Requisição para Atualizar os dados
        Query uptQuerry = em.createQuery("UPDATE Cliente c SET c.nome = 'Joao' WHERE c.cliente_id = 2");
        int qtdUpdate = uptQuerry.executeUpdate();

        //Executa as mudanças;
        em.getTransaction().commit();

        System.out.println("\nForam Atualizados " + qtdUpdate + "Clientes!");


        em.close();
        emf.close();

    }

    public static void deletarDados(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("umbler_database");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Requisição para Deletar os dados
        Query dltQuerry = em.createQuery("DELETE FROM Carro c WHERE c.id = :id");
        dltQuerry.setParameter("id", "1");

        int qtdDelete = dltQuerry.executeUpdate();

        //Executa as mudanças;
        em.getTransaction().commit();

        System.out.println("Foram Deletados " + qtdDelete + " Carros!");

        em.close();
        emf.close();
    }
}
