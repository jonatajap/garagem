/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetogaragem;

/**
 *
 * @author Jona
 */
public class Cliente {

    private String nome;
    private String cpf;
    private String contato;
    private Carro carro;
    
    // Abaixo método costrutor
    public Cliente(String nome, String cpf, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

/**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @return the carro
     */
    public Carro getCarro() {
        return carro;
    }
    
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    

    // Cadastra o carro do cliente
    public void cadastrarCarro(Carro carro) {
        this.setCarro(carro);
    }

    // Método para alugar uma vaga
    public Aluguel alugarVaga(Garagem garagem) {
        Vaga vagaDisponivel = garagem.procurarVagaDisponivel();
        if (vagaDisponivel != null) {
            Aluguel aluguel = new Aluguel(this, vagaDisponivel);
            vagaDisponivel.ocupar(this.getCarro());
            return aluguel;
        }
        return null;
    }

}
/*
public class CpfInvalidoException extends Exception {
    public CpfInvalidoException() {
        super();
    }

    public CpfInvalidoException(String message) {

        super(message);

    }


}

}
*/
