package com.taller4.tpfinal.tpfinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.taller4.tpfinal.tpfinal.model.EjercicioUsuario;

@Repository
public interface EjercicioUsuarioRepository extends JpaRepository<EjercicioUsuario, Long> {
    
    @Query("select ue from EjercicioUsuario ue where ue.idUsuario = ?1")
    List<EjercicioUsuario> findByUserId(int idUsuario);

    @Query("delete from EjercicioUsuario ue where ue.id = ?1")
    void deleteById(int idUsuario);

}
