package com.taller4.tpfinal.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "ejerciciousuario")
public class EjercicioUsuario {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
 
  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;
 
  @Column(name = "idUsuario")
  private int idUsuario;

  @Column(name = "repeticiones")
  private int repeticiones;

  @Column(name = "series")
  private int series;
 
 
  public EjercicioUsuario() {
  }
 
  public EjercicioUsuario(String nombre, String descripcion, int idUsu, int rep, int serie) {

    this.nombre = nombre;
    this. descripcion = descripcion;
    this.idUsuario = idUsu;
    this.repeticiones = rep;
    this.series = serie;
  }
 
  public long getId() {
    return id;
  }
 
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
 
  public String getNombre() {
    return this.nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
 
  public String getDescripcion() {
    return this.descripcion;
  }
 
  public void setIdUsuario(int idUsu) {
    this.idUsuario = idUsu;
  }
 
  public int getIdUsuario() {
    return this.idUsuario;
  }
 
  public void setRepeticiones(int rep) {
    this.repeticiones = rep;
  }
 
  public int getSeries() {
    return this.series;
  }
 
  public void setSeries(int serie) {
    this.series = serie;
  }
 
  public int getRepeticiones() {
    return this.repeticiones;
  }


}