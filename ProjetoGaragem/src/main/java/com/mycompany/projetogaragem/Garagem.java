package com.mycompany.projetogaragem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "garagem")
@NoArgsConstructor
public class Garagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long garagem_id;

    private String localizacao;

    @OneToMany(mappedBy = "garagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaga> vagas = new ArrayList<>();

    public Garagem(String localizacao, int numVagas) {
        this.localizacao = localizacao;
        for (int i = 1; i <= numVagas; i++) {
            vagas.add(new Vaga(i, this));
        }
    }

    public Vaga procurarVagaDisponivel() {
        return vagas.stream().filter(v -> !v.isOcupada()).findFirst().orElse(null);
    }

    public List<Vaga> listarVagasOcupadas() {
        List<Vaga> ocupadas = new ArrayList<>();
        for (Vaga v : vagas) {
            if (v.isOcupada()) ocupadas.add(v);
        }
        return ocupadas;
    }
}