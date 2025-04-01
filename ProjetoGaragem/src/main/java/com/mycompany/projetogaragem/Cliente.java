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

    // Cadastra o carro do cliente
    public void cadastrarCarro(Carro carro) {
        this.carro = carro;
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