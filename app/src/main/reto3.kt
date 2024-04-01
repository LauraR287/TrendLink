package com.example.fundamentoskotlin.tallerPOO

class reto3 {
}
class Articulo(val nombre: String, val precioBase: Double) {
    var precioVenta: Double = precioBase

    fun ofertar(precioOferta: Double) {
        if (precioOferta > precioVenta) {
            precioVenta = precioOferta
        }
    }

    fun vender() {
        println("El artículo '$nombre' se vende por $precioVenta")
    }

    fun noVendido() {
        println("El artículo '$nombre' no fue vendido y se queda en la casa de subastas")
    }
}

class Subasta {
    private val articulos = mutableListOf<Articulo>()

    fun agregarArticulo(articulo: Articulo) {
        articulos.add(articulo)
    }

    fun recibirOferta(nombreArticulo: String, precioOferta: Double) {
        val articulo = articulos.find { it.nombre == nombreArticulo }
        articulo?.ofertar(precioOferta)
    }

    fun finalizarSubasta() {
        println("Resultados de la subasta:")
        for (articulo in articulos) {
            if (articulo.precioVenta > articulo.precioBase) {
                articulo.vender()
            } else {
                articulo.noVendido()
            }
        }
    }
}

fun main() {
    val subasta = Subasta()

    subasta.agregarArticulo(Articulo("Libro", 15.0))
    subasta.agregarArticulo(Articulo("Esfero", 9.0))
    subasta.agregarArticulo(Articulo("Camisa", 30.0))

    subasta.recibirOferta("Libro", 18.0)
    subasta.recibirOferta("Camisa", 13.0)

    subasta.finalizarSubasta()
}
