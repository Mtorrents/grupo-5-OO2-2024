package com.unla.grupo3.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.grupo3.entities.Registro;

@Repository("registroRepository")
public interface RegistroRepository extends JpaRepository<Registro, Serializable> {

    @Query("SELECT r FROM Registro r JOIN FETCH r.productos WHERE r.idRegistro = (:idRegistro)")
    public abstract Registro findByIdAndFetchProductosEagerly(@Param("idRegistro") int idRegistro);
}
