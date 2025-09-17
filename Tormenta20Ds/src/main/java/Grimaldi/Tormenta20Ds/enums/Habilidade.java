package Grimaldi.Tormenta20Ds.enums;

import lombok.Getter;

@Getter
public enum Habilidade {
    // Habilidades de Guerreiro (exemplo)
    ATAQUE_EXTRA("Ataque Extra", 6, "Guerreiro", "Você pode gastar 2 PM para realizar um ataque adicional."),
    DUREZA("Dureza", 3, "Guerreiro", "Você recebe +2 em todos os testes de resistência.");
    
    private final String nome;
    private final int nivelRequisito;
    private final String classe;  // Pode ser trocado por enum de Classe quando criar
    private final String descricao;

    Habilidade(String nome, int nivelRequisito, String classe, String descricao) {
        this.nome = nome;
        this.nivelRequisito = nivelRequisito;
        this.classe = classe;
        this.descricao = descricao;
    }
}