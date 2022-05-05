package com.web.usuario.SpringWeb.repositorio;

import com.web.usuario.SpringWeb.models.UsuarioUrbana;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
public interface UsuariosRepo extends CrudRepository<UsuarioUrbana, Integer> {



    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from usuarios where id = :id", nativeQuery = true)
    public boolean exist(int id);
  
    @Query(value="select * from usuarios where email = :email and senha = :senha", nativeQuery = true)
    public UsuarioUrbana Login2(String email, String senha);
  }
    