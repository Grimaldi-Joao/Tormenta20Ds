package Grimaldi.Tormenta20Ds.enums;

import java.util.Set;
import java.util.HashSet;
import lombok.Getter;

@Getter
public enum Poder {
    // Poderes Gerais
    ATAQUE_PODEROSO("Ataque Poderoso", "Força 13", "Você pode gastar 2 PM para receber +5 no teste de ataque.", TipoPoder.GERAL),
    MAGIA_APRIMORADA("Magia Aprimorada", "Inteligência 13", "Você soma seu modificador do atributo-chave nas rolagens de dano de suas magias.", TipoPoder.GERAL),
    
    // Exemplo de poder que concede outro poder
    PODER_MANIFESTO("Poder Manifesto", "Nível 5", "Você recebe um poder da sua classe.", TipoPoder.CLASSE, ATAQUE_PODEROSO);

    private final String nome;
    private final String preRequisito;
    private final String descricao;
    private final TipoPoder tipo;
    private final Set<Poder> poderesRelacionados;

    Poder(String nome, String preRequisito, String descricao, TipoPoder tipo, Poder... poderesRelacionados) {
        this.nome = nome;
        this.preRequisito = preRequisito;
        this.descricao = descricao;
        this.tipo = tipo;
        this.poderesRelacionados = new HashSet<>();
        if (poderesRelacionados != null) {
            for (Poder poder : poderesRelacionados) {
                this.poderesRelacionados.add(poder);
            }
        }
    }

    // Sobrecarga do construtor para poderes sem poderes relacionados
    Poder(String nome, String preRequisito, String descricao, TipoPoder tipo) {
        this(nome, preRequisito, descricao, tipo, new Poder[0]);
    }
}