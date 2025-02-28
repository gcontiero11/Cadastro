data class Formulario(
    val nomeCompleto: String,
    val telefone: String,
    val email: String,
    val listaEmails: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
) {
    override fun toString(): String {
        return "Nome: $nomeCompleto\n" +
                "Telefone: $telefone\n" +
                "Email: $email\n" +
                "Ingressar na lista: $listaEmails\n" +
                "Sexo: $sexo\n" +
                "Cidade: $cidade\n" +
                "UF: $uf"
    }
}