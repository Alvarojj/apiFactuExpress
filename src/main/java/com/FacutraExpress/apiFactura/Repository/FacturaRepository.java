package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    @Query(value = "select * from factura WHERE idUsuario = :idUser", nativeQuery = true)
    List<Factura> obtenerFacturaIdUsuario(@Param("idUser") int idUser);
}
