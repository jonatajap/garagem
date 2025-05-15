package com.mycompany.projetogaragem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Cliente.buscaTodos", query = "SELECT c FROM Cliente c"),
        @NamedQuery(name = "Cliente.buscaNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    private String nome;

    private String cpf;
    private String contato;

    @OneToOne(mappedBy = "dono", orphanRemoval = true, cascade = CascadeType.ALL)
    private Carro carro;

    public Cliente(String nome, String cpf, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

    public void cadastrarCarro(Carro carro) {

        this.carro = carro;
        carro.setDono(this);
    }
}