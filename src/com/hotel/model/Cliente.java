package com.hotel.model;

import java.util.UUID;

public class Cliente {
  private String names;
  private String lastNames;
  private String email;
  private String room;
  private UUID id;

  public Cliente() {}

  public Cliente(String names, String lastNames, String email, String room, UUID id) {
    this.names = names;
    this.lastNames = lastNames;
    this.email = email;
    this.room = room;
    this.id = id;
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

  public String getFullname() {
    return this.names + " " + this.lastNames;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRoom() {
    return this.room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
