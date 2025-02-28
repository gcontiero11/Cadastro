package com.example.projeto_cadastro

class Formulario(
    private val nome: String,
    private val email: String,
    private val telefone: String,
    private val endereco: String
) {
    override fun toString(): String {
        return "Nome: $nome || Email: $email || Telefone: $telefone || Endereco: $endereco"
    }
}