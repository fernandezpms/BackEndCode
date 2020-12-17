package com.taller4.tpfinal.tpfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller4.tpfinal.tpfinal.model.EjercicioUsuario;
import com.taller4.tpfinal.tpfinal.repo.EjercicioUsuarioRepository;

 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EjercicioUsuarioController {
 
  @Autowired
  EjercicioUsuarioRepository repository;
 
  @PostMapping(value = "/ejerciciousuario/create")
  public EjercicioUsuario postUser(@RequestBody EjercicioUsuario ejeruser) {
    EjercicioUsuario _ejeruser = repository.save(ejeruser);
    return _ejeruser;
  }
 
  @DeleteMapping("/ejerciciousuario/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
    System.out.println("Borrando ejercicio usuario con ID = " + id + "...");
 
    repository.deleteById(id);
 
    return new ResponseEntity<>( HttpStatus.OK);
  }
 
  @DeleteMapping("/ejerciciousuario/delete")
  public ResponseEntity<String> deleteAllEjercicioUsuarios() {
    System.out.println("Borrando todos ejercicios de usuario...");
 
    repository.deleteAll();
 
    return new ResponseEntity<>(HttpStatus.OK);
  }
 
  @GetMapping(value = "ejerciciousuario/usuario/{idUsuario}")
  public List<EjercicioUsuario> findByUserId(@PathVariable String idUsuario) {
 
    List<EjercicioUsuario> ejeruser = repository.findByUserId(Integer.parseInt(idUsuario));
    return ejeruser;
  }
 
}
