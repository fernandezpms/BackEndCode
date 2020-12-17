package com.taller4.tpfinal.tpfinal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller4.tpfinal.tpfinal.model.Usuario;
import com.taller4.tpfinal.tpfinal.repo.UsuarioRepository;

 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {
 
  @Autowired
  UsuarioRepository repository;
 
  @GetMapping("/usuarios")
  public List<Usuario> getAllUsers() {
    System.out.println("Obteniendo usuarios...");
 
    List<Usuario> users = new ArrayList<>();
    repository.findAll().forEach(users::add);
 
    return users;
  }
 
  @PostMapping(value = "/usuarios/create")
  public Usuario postUser(@RequestBody Usuario user) {
    var BCryprPE =  new BCryptPasswordEncoder();  
    var passEncoded = BCryprPE.encode(user.getPassword());
    Usuario _user = repository.save(new Usuario(user.getUserName(), passEncoded));
    return _user;
  }
 
  @DeleteMapping("/usuarios/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
    System.out.println("Borrado usuario con ID = " + id + "...");
 
    repository.deleteById(id);
 
    return new ResponseEntity<>("El usuario fue borrado!", HttpStatus.OK);
  }
 
  @DeleteMapping("/usuarios/delete")
  public ResponseEntity<String> deleteAllUsers() {
    System.out.println("Borrando usuarios...");
 
    repository.deleteAll();
 
    return new ResponseEntity<>("Todos los usuarios borrados!", HttpStatus.OK);
  }
 
  @GetMapping(value = "usuarios/username/{username}")
  public Usuario findByUserName(@PathVariable String username) {
 
    Usuario user = repository.findByUserName(username);
    return user;
  }
 
  @PutMapping("/usuarios/{id}")
  public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario user) {
    System.out.println("Actualizando usuario ID = " + id + "...");
 
    Optional<Usuario> userData = repository.findById(id);
 
    if (userData.isPresent()) {
      Usuario _user = userData.get();
      _user.setUserName(user.getUserName());
      _user.setPassword(user.getPassword());
      _user.setActive(user.isActive());
      return new ResponseEntity<>(repository.save(_user), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}