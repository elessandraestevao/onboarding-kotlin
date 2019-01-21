class Exercicio1 (listaDeRotas: List<String>) {
    private val listOfRoutes = listaDeRotas

    fun existeARota(route: String): Boolean {
        for (rota in listOfRoutes) {
            val segmentsOfRota = rota.split("/")
            val segmentsOfRoute = route.split("/")
            if (segmentsOfRota.size == segmentsOfRoute.size) {
                for (i in segmentsOfRota.indices) {
                    if (segmentsOfRota[i] != (segmentsOfRoute[i])) {
                        break
                    } else {
                        segmentsOfRota[i]
                        if (i == segmentsOfRota.size - 1) {
                            return true
                        }
                    }

                }
            }

        }
        return false
    }

}