package com.nix.lox;

import java.io.Serializable;

public class Token implements Serializable{
  final TokenType type;
  final String lexeme;
  final Object literal;
  final int line;

  Token(TokenType type, String lexeme, Object literal, int line){
    this.type = type;
    this.lexeme = lexeme;
    this.literal = literal;
    this.line = line;
  }

  public String toString(){
    return type + " " + lexeme + " " + literal;
  }

  public static Token basic() {
    return new Token(TokenType.IDENTIFIER, "basic", null, 0);
  }
}
