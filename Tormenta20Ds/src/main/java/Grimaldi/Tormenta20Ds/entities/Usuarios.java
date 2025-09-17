package Grimaldi.Tormenta20Ds.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tb_Usuario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Usuarios implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String Email;
    private String Senha;

    @OneToMany
    private List<Presonagem> Personagens;


}
