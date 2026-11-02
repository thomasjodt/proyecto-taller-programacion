package com.hotel.model;

public class Integrante {
  private String name;
  private String code;
  private String role;
  private String career;

  public Integrante() {}
  public Integrante(String name, String code, String role, String career) {
    this.name = name;
    this.code = code;
    this.role = role;
    this.career = career;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }
}
