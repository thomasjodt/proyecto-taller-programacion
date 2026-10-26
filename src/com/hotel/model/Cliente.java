package com.hotel.model;

import java.util.UUID;

public class Cliente {
  private String names;
  private String lastNames;
  private String email;
  private UUID id;

  public Cliente() {
    this.id = UUID.randomUUID();
  }

  public Cliente(String names, String lastNames, String email) {
    this.names = names;
    this.lastNames = lastNames;
    this.email = email;
    this.id = UUID.randomUUID();
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getLastnames() {
    return this.lastNames;
  }

  public void setLastnames(String lastNames) {
    this.lastNames = lastNames;
  }

  public String getFullName() {
    return this.names + " " + this.lastNames;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
