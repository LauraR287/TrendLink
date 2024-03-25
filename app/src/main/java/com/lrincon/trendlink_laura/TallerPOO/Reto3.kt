package com.lrincon.trendlink_laura.Taller

class Reto3 {
}

class Articulo(){
    var nombre: String = ""
        get(){
            return field
        }
        set(nombre) {
            field = nombre
        }
    var precioInicial: Int = 0
        get(){
            return field
        }
        set(precioInicial) {
            field = precioInicial
        }
    constructor(nombre: String, precioInicial: Int): this() {
        this.nombre = nombre
        this.precioInicial = precioInicial
    }
}

class Subasta(var articulo: Articulo) {

    var mejorOferta: Int = 0
        get(){
        return field
    }
        set(mejorOferta) {
            field = mejorOferta
        }
    var comprador: String = ""
        get(){
            return field
        }
        set(comprador) {
            field = comprador
        }

    fun oferta(precioOfertado: Int, compradorOferta: String) {
        if (precioOfertado > mejorOferta) {
            mejorOferta = precioOfertado
            comprador = compradorOferta
        }
    }

    fun vendido() {
        if (mejorOferta >= articulo.precioInicial) {
            println("El artículo ${articulo.nombre} ha sido vendido a $comprador por $mejorOferta.")
        } else {
            println("El artículo ${articulo.nombre} ha sido adquirido por la casa dado que no se recibieron" +
                    " ofertas.")
        }
    }
}

fun main() {
    val articulos = listOf(
        Articulo("PlayStation", 1000000),
        Articulo("Libro antiguo", 50000)
    )
    val subastas = articulos.map { Subasta(it) }

    subastas.forEachIndexed { index, subasta ->
        val ofertas = (0..3).random()
        println("----------------Se recibieron $ofertas ofertas para el artículo ${subasta.articulo.nombre}----------------")
        repeat(ofertas) {
            val precioOferta = (subasta.articulo.precioInicial..(subasta.articulo.precioInicial * 2)).random().toInt()
            val comprador = "Comprador ${it + 1}"
            println("$comprador ofrece $precioOferta")
            subasta.oferta(precioOferta, comprador)
        }

        subasta.vendido()
    }
}
