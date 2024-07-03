package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "select * from Usuario where correo = ?1", nativeQuery = true)
    Usuario findByCorreo(String correo);

    @Query(value = "select * from Usuario where id_usuario = ?1", nativeQuery = true)
    Usuario findById(int id);
}
