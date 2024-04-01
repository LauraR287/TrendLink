package com.example.fundamentoskotlin.tallerPOO
import kotlin.random.Random

class retoo5 {
}

class Nequi(private val numeroCelular: String, private val clave: Int) {
    private var saldoDisponible: Int = 4500

    fun iniciarSesion() {
        println("Por favor ingresa tu celular:")
        val celularIngresado = readLine() ?: ""

        println("Por favor ingresa tu clave de 4 dígitos:")
        val claveIngresada = readLine()?.toIntOrNull() ?: 0

        if (celularIngresado == numeroCelular && claveIngresada == clave) {
            println("Bienvenido, has ingresado correctamente a Nequi.")
            mostrarSaldoDisponible()
            funciones()
        } else {
            println("Ups, Parece que tus datos de acceso no son correctos.")
        }
    }

    fun mostrarSaldoDisponible() {
        println("Saldo Disponible: $$saldoDisponible")
    }

    fun funciones() {
        while (true) {
            println("Selecciona una opción: 1. Sacar, 2. Enviar, 3. Recargar, 4. Salir")
            val opcion = readLine()?.toIntOrNull() ?: 0

            when (opcion) {
                1 -> sacar()
                2 -> enviar()
                3 -> recargar()
                4 -> {
                    println("¡Gracias por usar Nequi!")
                    return
                }
                else -> println("Opcion no válida. Por favor selecciona una opcion del 1 al 4.")
            }
        }
    }

    fun sacar() {
        println("Selecciona una opcion: 1. Cajero, 2. Punto fisico")
        val opcion = readLine()?.toIntOrNull() ?: 0

        if (saldoDisponible < 2000) {
            println("No te alcanza :( ")
            return
        }

        when (opcion) {
            1, 2 -> {
                println("Por favor ingresa la cantidad a retirar:")
                val cantidadRetiro = readLine()?.toIntOrNull() ?: 0

                if (cantidadRetiro > saldoDisponible) {
                    println("No tienes suficiente dinero para retirar :( ")
                    return
                } else {
                    val codigo = Random.nextInt(100000, 1000000)
                    println("El codigo para retirar es $codigo")
                    saldoDisponible -= cantidadRetiro
                    println("Saldo restante: $$saldoDisponible")
                }
            }
            else -> println("Opcion no valida.")
        }
    }

    fun enviar() {
        println("Por favor ingresa el numero de telefono al que deseas enviar el dinero:")
        val numeroDestino = readLine() ?: ""

        println("Ingresa el valor a enviar:")
        val valorEnviar = readLine()?.toIntOrNull() ?: 0

        if (valorEnviar > saldoDisponible) {
            println("No tienes suficiente saldo para realizar la transferencia :( ")
            return
        }

        saldoDisponible -= valorEnviar
        println("Transferencia exitosa a $numeroDestino por un valor de $$valorEnviar. Nuevo saldo: $$saldoDisponible")
    }

    fun recargar() {
        println("Por favor ingresa el valor a recargar:")
        val valorRecarga = readLine()?.toIntOrNull() ?: 0

        println("¿Deseas confirmar la recarga por $$valorRecarga? 1. Si, 2. No")
        val confirmacion = readLine()?.toIntOrNull() ?: 0

        when (confirmacion) {
            1 -> {
                saldoDisponible += valorRecarga
                println("Recarga exitosa. Nuevo saldo: $$saldoDisponible")
            }
            2 -> println("Recarga cancelada.")
            else -> println("Opción no valida")
        }
    }
}

fun main() {
    val nequi = Nequi("0123456789", 2222)
    nequi.iniciarSesion()
}
