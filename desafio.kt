// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val name: String, val formacoes: List<Formacao>)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    // Método para matricular um usuário
    fun matricular(usuario: Usuario) {
        // Adiciona o usuário na lista de inscritos
        inscritos.add(usuario)
        println("Usuário ${usuario.name} matriculado na formação $nome.")

        // Exibe a lista de usuários matriculados
        println("Lista de inscritos na formação $nome:")
        inscritos.forEach { println(it.name) }
    }
}

fun main() {
    // Criando os conteúdos educacionais
    val conteudoKotlin = ConteudoEducacional(nome = "Kotlin para Android", duracao = 30, nivel = Nivel.INTERMEDIARIO)
    val conteudoAndroid = ConteudoEducacional(nome = "Android para Iniciantes", duracao = 40, nivel = Nivel.BASICO)

    // Criando a formação
    val formacaoAndroid = Formacao(nome = "Formação Android", conteudos = listOf(conteudoKotlin, conteudoAndroid))

    // Criando o usuário
    val usuario = Usuario(name = "Ricardo", formacoes = listOf(formacaoAndroid))

    // Matriculando o usuário na formação
    formacaoAndroid.matricular(usuario)

    // Exibindo mensagem de sucesso
    println("Parabéns ${usuario.name}, você se matriculou na formação ${formacaoAndroid.nome}.")
}
