package Grimaldi.Tormenta20Ds.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Grimaldi.Tormenta20Ds.entities.embeddable.Atributos;
import Grimaldi.Tormenta20Ds.enums.Habilidade;
import Grimaldi.Tormenta20Ds.enums.Poder;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;  
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tb_Personagem")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Presonagem implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String Nome;
    private String Raca;
    private String Classe; // vai virar um string de enum
    private int Nivel;
    private String Origem; // vai virar enum
    private String Divinidade; // vai virar enum

    @Embedded
    private Atributos atributos;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Poder> poderes = new HashSet<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Habilidade> habilidades = new HashSet<>();
    
    private int VidaAtual;
    private int VidaTotal;

    private int ManaAtual;
    private int ManaTotal;

    // Métodos auxiliares para gerenciar poderes e habilidades
    public void adicionarPoder(Poder poder) {
        poderes.add(poder);
        // Se o poder concede outros poderes, adiciona eles também
        poderes.addAll(poder.getPoderesRelacionados());
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        if (habilidade.getClasse().equals(this.Classe) && 
            this.Nivel >= habilidade.getNivelRequisito()) {
            habilidades.add(habilidade);
        }
    }
}
