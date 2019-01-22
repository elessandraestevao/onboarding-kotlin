class GerenciadorDeRotas(urlsInformadas: List<String>) {
    private val urlsMapeadas = urlsInformadas

    fun verificaSeARotaInformadaExiste(rotaInformada: String): Boolean {
        println(urlsMapeadas)
        for (url in urlsMapeadas) {
            val segmentosDaURLMapeada = url.split("/")
            val segmentosDaRotaInformada = rotaInformada.split("/")
            if (segmentosDaURLMapeada.size == segmentosDaRotaInformada.size) {
                for (i in segmentosDaURLMapeada.indices) {
                    if (segmentosDaURLMapeada[i] != (segmentosDaRotaInformada[i])) {
                        if (segmentosDaURLMapeada[i].startsWith("{") && segmentosDaURLMapeada[i].endsWith("}")
                            && (segmentosDaURLMapeada[i] != segmentosDaRotaInformada[i] && segmentosDaRotaInformada[i] != "")
                        ) {
                            if (i == segmentosDaURLMapeada.size - 1) {
                                return true
                            } else {
                                continue
                            }
                        }
                    } else {
                        if (segmentosDaURLMapeada[i].startsWith("{") && segmentosDaURLMapeada[i].endsWith("}")) {
                            break
                        }
                        if (i == segmentosDaURLMapeada.size - 1) {
                            return true
                        }
                    }

                }
            }

        }
        return false
    }
}