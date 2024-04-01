package com.example.fundamentoskotlin.tallerPOO

class reto1 {
}

class Telefono {
    private var conteoNotificaciones: Int = 0
    private var mensajeResumen: String = ""

    fun recibirNotificaciones(cantidad: Int) {
        conteoNotificaciones = cantidad
        mensajeResumen = when {
            cantidad == 0 -> "No hay mensajes disponibles"
            cantidad < 100 -> "Tienes $cantidad notificaciones"
            else -> "Tienes 99+ notificaciones"
        }
    }

    fun mostrarResumen() {
        println(mensajeResumen)
    }
}

fun main() {
    val miTelefono = Telefono()

    println("Prueba 1: 0 notificaciones")
    miTelefono.recibirNotificaciones(0)
    miTelefono.mostrarResumen()

    println("\nPrueba 2: 50 notificaciones")
    miTelefono.recibirNotificaciones(50)
    miTelefono.mostrarResumen()

    println("\nPrueba 3: 100 notificaciones")
    miTelefono.recibirNotificaciones(100)
    miTelefono.mostrarResumen()

    println("\nPrueba 4: 150 notificaciones")
    miTelefono.recibirNotificaciones(150)
    miTelefono.mostrarResumen()
}
