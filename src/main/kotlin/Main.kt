fun main(args: Array<String>) {

    val listaDeRotas = listOf<String>("/users/{user_id}/testando", "/posts", "/comments")
    val exercicio1 = GerenciadorDeRotas(listaDeRotas)

    println(exercicio1.verificaSeARotaInformadaExiste("/users/{user_id}/testando"))

}