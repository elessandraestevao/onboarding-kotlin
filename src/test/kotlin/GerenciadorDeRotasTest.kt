import org.junit.Assert
import org.junit.Test

class GerenciadorDeRotasTest{

    @Test
    fun verificaQueExisteUmaRotaValidaInformadaDeApenasUmSegmento(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/posts"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaDeApenasUmSegmento(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/naoexiste"))
    }

    @Test
    fun verificaQueExisteUmaRotaValidaInformadaComParametro(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/2/testando"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaComParametro(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/2"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaComUmaBarraNoFinal(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/posts/"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaComDuasBarras(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("//posts"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaEmBranco(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste(""))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaSemBarra(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("posts"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaApenasComParametros(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/1/2/3"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaApenasComBarras(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("///"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaComBarraApenasNoFinal(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("posts/"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaSemBarraNoInicio(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("users/1/testando"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInvalidaInformadaSemInformarOParametroRequerido(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/{user_id}/testando"))
    }

    @Test
    fun verificaQueExisteUmaRotaValidaInformandoParametroQualquer(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/{usuario}/testando"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaSemInformarAsUrls(){
        val urlsInformadas = listOf<String>()
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/1/testando"))
    }

    @Test
    fun verificaQueExisteUmaRotaValidaInformadaDeApenasParametros(){
        val urlsInformadas = listOf<String>("/{user_id}/{user_id}/{user_id}","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/1/2/3"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaValidaInformandoParametrosIdenticosAosMapeados(){
        val urlsInformadas = listOf<String>("/{user_id}/{user_id}/{user_id}","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/{user_id}/{user_id}/{user_id}"))
    }

    @Test
    fun verificaQueExisteUmaRotaValidaInformandoParametroComoUltimoSegmento(){
        val urlsInformadas = listOf<String>("/users/edit/{user_id}","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/edit/2"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaNaoInformandoParametroRequeridoNoUltimoSegmento(){
        val urlsInformadas = listOf<String>("/users/edit/{user_id}","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/edit/"))
    }

    @Test
    fun verificaQueExisteUmaRotaValidaInformandoParametroComoPrimeiroSegmento(){
        val urlsInformadas = listOf<String>("/{user_id}/id/edit/","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/3/id/edit/"))
    }

    @Test
    fun verificaQueExisteUmaRotaValidaInformandoDoisParametro(){
        val urlsInformadas = listOf<String>("/{user_id}/{id}/edit/","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/{user}/3/edit/"))
    }
}