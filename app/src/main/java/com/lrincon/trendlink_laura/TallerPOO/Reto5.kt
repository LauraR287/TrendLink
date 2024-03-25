package com.lrincon.trendlink_laura.Taller

class Reto5 {
}

class Nequi() {
    private var celular: String = ""
        get(){
            return field
        }
        set(celular) {
            field = celular
        }
    private var clave: Int = 0
        get(){
            return field
        }
        set(clave) {
            field = clave
        }

    constructor(celular: String, clave: Int): this(){
        this.celular = celular
        this.clave = clave
    }

    private var saldoDisponible: Int = 4500

    fun iniciarSesion() {

        println("Por favor ingresa tu número de celular:")
        val celularIngresado = readLine().toString()

        println("Por favor ingresa tu clave de 4 dígitos:")
        val claveIngresada = readln().toInt()

        if (celularIngresado == celular && claveIngresada == clave) {
            println("¡Bienvenido! Has ingresado correctamente a Nequi.")
            println("Saldo disponible: $saldoDisponible ")
            funciones()
        } else {
            println("¡Upps! Parece que tus datos de acceso no son correctos.")

            for (intentos in 1..3) {
                println("Tienes ${4 - intentos} intentos más.")

                println("Por favor ingresa tu número de celular:")
                val celularIngresado = readLine().toString()

                println("Por favor ingresa tu clave de 4 dígitos:")
                val claveIngresada = readln().toInt()

                if (celularIngresado == celular && claveIngresada == clave) {
                    println("¡Bienvenido! Has ingresado correctamente a Nequi.")
                    println("Saldo disponible: $saldoDisponible ")
                    funciones()
                }
            }
            println("No tienes más intentos disponibles.")
        }
    }

    private fun funciones() {
        while (true) {
            println("Selecciona una opción: 1. Sacar, 2. Enviar, 3. Recargar")
            val opcion = readLine()!!.toInt()

            when (opcion) {
                1 -> sacar()
                2 -> enviar()
                3 -> recargar()
                else -> println("Opción no válida. Por favor selecciona una opción del 1 al 3.")
            }
        }
    }

    private fun sacar() {
        println("Selecciona una opción: 1. Cajero, 2. Punto físico")
        val opcion = readLine()!!.toInt()

        if (saldoDisponible < 2000) {
            println("No te alcanza.")
        }

        when (opcion) {
            1, 2 -> {
                println("Por favor ingresa la cantidad a retirar:")
                val cantidadRetiro = readLine()!!.toInt()

                if (cantidadRetiro > saldoDisponible) {
                    println("No tienes suficiente saldo para realizar el retiro.")
                    return
                } else {
                    val codigo = (100000..1000000).random()
                    print("El código para retirar es ${codigo}")
                }
            }
            else -> println("Opción no válida.")
        }
    }

    private fun enviar() {
        println("Por favor ingresa el número de teléfono al que deseas enviar el dinero:")
        val numeroDestino = readLine().toString()

        println("Por favor ingresa el valor a enviar:")
        val valorEnviar = readLine()!!.toInt()

        if (valorEnviar > saldoDisponible) {
            println("No tienes suficiente saldo para realizar la transferencia.")
            return
        }

        saldoDisponible -= valorEnviar
        println("Transferencia exitosa a $numeroDestino por un valor de $valorEnviar. Nuevo saldo: $saldoDisponible")
    }

    private fun recargar() {
        println("Por favor ingresa el valor a recargar:")
        val valorRecarga = readLine()!!.toInt()

        println("¿Deseas confirmar la recarga por $valorRecarga? 1. Si, 2. No")
        val confirmacion = readLine()!!.toInt()

        when(confirmacion){
            1 ->  {saldoDisponible += valorRecarga
            println("Recarga exitosa. Nuevo saldo: $saldoDisponible")}
            2 -> println("Recarga cancelada.")
        }
    }
}

fun main() {
    val nequi = Nequi("1234567890", 1234)
    nequi.iniciarSesion()
}
