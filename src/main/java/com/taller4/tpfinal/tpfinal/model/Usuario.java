package com.taller4.tpfinal.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "usuario")
public class Usuario {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  @Column(name = "username")
  private String username;
 
  @Column(name = "password")
  private String password;
 
  @Column(name = "active")
  private boolean active;
 
  public Usuario() {
  }
 
  public Usuario(String username, String password) {
    this.username = username;
    this.password = password;
    this.active = true;
  }
 
  public long getId() {
    return id;
  }
 
  public void setUserName(String username) {
    this.username = username;
  }
 
  public String getUserName() {
    return this.username;
  }
 
  public void setPassword(String password) {
    this.password = password;
  }
 
  public String getPassword() {
    return this.password;
  }
 
  public boolean isActive() {
    return active;
  }
 
  public void setActive(boolean active) {
    this.active = active;
  }
 
  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + password + ", active=" + active + "]";
  }
}