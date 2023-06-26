package com.nix.lox;

enum TokenType {
  // Single-character tokens.
  LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
  COMMA, DOT, SEMICOLON, 

  PLUS, PLUS_ASSIGN, INCREMENT,

  MINUS, MINUS_ASSIGN, DECREMENT,

  STAR, STAR_ASSIGN, POWER,
  
  SLASH, SLASH_ASSIGN,

  // One or two character tokens.
  BANG, BANG_EQUAL,
  EQUAL, EQUAL_EQUAL,
  GREATER, GREATER_EQUAL,
  LESS, LESS_EQUAL,

  // Literals.
  IDENTIFIER, STRING, NUMBER,

  // Keywords.
  AND, CLASS, ELSE, FALSE, FUN, FOR, IF, NIL, OR,
  PRINT, RETURN, SUPER, THIS, TRUE, VAR, CONST, WHILE,

  EOF,
  WHEN,
  FINALLY,
  STATIC,

  OBJECT, NULL_GET, NULL_EQUAL, NULL_EQUAL_EQUAL
}