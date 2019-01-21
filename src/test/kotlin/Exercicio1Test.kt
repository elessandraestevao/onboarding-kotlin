import org.junit.Assert
import org.junit.Test

class Exercicio1Test{

    @Test
    fun validaRotaValidaDeApenasUmSegmento(){
        val listaDeRotas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val exercicio1 = Exercicio1(listaDeRotas)
        Assert.assertTrue(exercicio1.existeARota("/posts"))

    }

    @Test
    fun validaRotaInvalidaDeApenasUmSegmento(){
        val listaDeRotas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val exercicio1 = Exercicio1(listaDeRotas)
        Assert.assertFalse(exercicio1.existeARota("/naoexiste"))

    }
}