package Grimaldi.Tormenta20Ds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Grimaldi.Tormenta20Ds.entities.Usuarios;

public interface UsuarioRepository extends JpaRepository <Usuarios, Long> {
    
}
