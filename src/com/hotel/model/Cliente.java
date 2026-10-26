package com.hotel.model;

public class Cliente {
  private String names;
  private String lastNames;
  private String email;
  private String room;

  public Cliente() {}

  public Cliente(String names, String lastNames, String email, String room) {
    this.names = names;
    this.lastNames = lastNames;
    this.email = email;
    this.room = room;
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
}
