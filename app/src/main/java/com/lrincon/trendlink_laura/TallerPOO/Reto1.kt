package com.lrincon.trendlink_laura.Taller

class Reto1() {
}
class notificacion(){
    var cantidad:Int = 0
        get(){
            return field
        }
        set(cantidad) {
            field = cantidad
        }
    constructor(cantidad:Int) : this() {
        this.cantidad = cantidad
    }

    fun pedirDatos() {
        println("Inserte la cantidad de mensajes que mandará")
        cantidad = readln().toInt()
    }
}

fun main() {
    val notificacion = notificacion()
    notificacion.pedirDatos()
    when {
        notificacion.cantidad == 0 -> println("No existen mensajes disponibles")
        notificacion.cantidad < 100 -> println("Tienes ${notificacion.cantidad} notificaciones")
        else -> println("Tienes 99+ notificaciones")
    }
}
