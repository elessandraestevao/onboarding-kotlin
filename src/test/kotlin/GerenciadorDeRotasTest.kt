import org.junit.Assert
import org.junit.Test

class GerenciadorDeRotasTest{

    @Test
    fun verificaQueExisteUmaRotaInformadaComApenasUmSegmento(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/posts"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaComApenasUmSegmento(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/naoexiste"))
    }

    @Test
    fun verificaQueExisteUmaRotaInformadaComParametro(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/2/testando"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaComParametro(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/2"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaComUmaBarraNoFinal(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/posts/"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaComDuasBarrasNoInicio(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("//posts"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaEmBranco(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste(""))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaSemBarra(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("posts"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaApenasComParametros(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/1/2/3"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaApenasComBarras(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("///"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaComBarraApenasNoFinal(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("posts/"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaSemBarraNoInicio(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("users/1/testando"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformadaSemInformarOParametroRequerido(){
        val urlsInformadas = listOf<String>("/users/{user_id}/testando","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/users/{user_id}/testando"))
    }

    @Test
    fun verificaQueExisteUmaRotaInformandoParametroQualquer(){
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
    fun verificaQueExisteUmaRotaInformadaApenasComParametros(){
        val urlsInformadas = listOf<String>("/{user_id}/{user_id}/{user_id}","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/1/2/3"))
    }

    @Test
    fun verificaQueNaoExisteUmaRotaInformandoParametrosIdenticosAosMapeados(){
        val urlsInformadas = listOf<String>("/{user_id}/{user_id}/{user_id}","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertFalse(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/{user_id}/{user_id}/{user_id}"))
    }

    @Test
    fun verificaQueExisteUmaRotaInformandoParametroComoUltimoSegmento(){
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
    fun verificaQueExisteUmaRotaInformandoParametroComoPrimeiroSegmento(){
        val urlsInformadas = listOf<String>("/{user_id}/id/edit/","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/3/id/edit/"))
    }

    @Test
    fun verificaQueExisteUmaRotaInformandoDoisParametros(){
        val urlsInformadas = listOf<String>("/{user_id}/{id}/edit/","/posts","/comments")
        val gerenciadorDeRotas = GerenciadorDeRotas(urlsInformadas)
        Assert.assertTrue(gerenciadorDeRotas.verificaSeARotaInformadaExiste("/{user}/3/edit/"))
    }
}