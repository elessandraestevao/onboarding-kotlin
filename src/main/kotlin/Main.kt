fun main(args: Array<String>) {

    val listaDeRotas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
    val exercicio1 = Exercicio1(listaDeRotas)

    println(exercicio1.existeARota("/users"))

}