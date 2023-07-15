package com.study.gtnext.security.dto;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
  public JwtResponse(String token, String username, List<String> roles, Long idDipendente, Long idAzienda) {
    this.token = token;
    this.username = username;
    this.roles = roles;
    this.type = "Bearer";
    this.idDipendente = idDipendente;
    this.idAzienda = idAzienda;
  }
  public JwtResponse(){}
  private  String type ;
  private String token;
  private String username;
  private List<String> roles;
  private Long idDipendente;
  private Long idAzienda;
}
