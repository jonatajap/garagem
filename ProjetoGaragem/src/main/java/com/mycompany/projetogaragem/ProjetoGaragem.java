package com.mycompany.projetogaragem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProjetoGaragem {

    public static void main(String[] args) {

        // Executa o método que cadastra dados de exemplo no banco
        adicionandoValores1();

    }

    //simula o processo de cadastrar clientes, carros, garagem e vagas.
    public static void adicionandoValores1() {

        // Criação da fábrica e gerenciador de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Criação dos carros
        Carro carro1 = new Carro(
                "Gol",
                "ABC-1234",
                "Prata");

        Carro carro2 = new Carro(
                "BMW",
                "CBA-4321",
                "Preta");

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
        Vaga vaga1 = garagem.procurarVagaDisponivel();
        Vaga vaga2 = garagem.procurarVagaDisponivel();


        //Inserção dos dados no BD
        em.persist(garagem);

        em.persist(carro1);
        em.persist(carro2);

        em.persist(cliente1);
        em.persist(cliente2);

        em.persist(vaga1);
        em.persist(vaga2);

        //Finaliza as transações e fechas as conexões
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void puxandoDados() {

        System.out.println("Buscando os Clientes...\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
        EntityManager em = emf.createEntityManager();

        // Buscar todos os clientes
        TypedQuery<Cliente> queryTodos = em.createNamedQuery("Cliente.buscaTodos", Cliente.class);
        List<Cliente> todos = queryTodos.getResultList();


        System.out.println("Todos os clientes:");
        for (Cliente c : todos) {
            System.out.println("Nome: " + c.getNome() + "\nCPF: " + c.getCpf() + "\nContato: " + c.getContato());
        }

        // Buscar clientes por nome
        TypedQuery<Cliente> queryPorNome = em.createNamedQuery("Cliente.buscaNome", Cliente.class);
        queryPorNome.setParameter("nome", "Carlos");
        List<Cliente> encontrados = queryPorNome.getResultList();

        System.out.println("Clientes com nome Carlos:");
        for (Cliente encontrado : encontrados) {

            System.out.println("Nome: " + encontrado.getNome() + "\nCPF: " + encontrado.getCpf() + "\nContato: " + encontrado.getContato());
        }
    }
}
