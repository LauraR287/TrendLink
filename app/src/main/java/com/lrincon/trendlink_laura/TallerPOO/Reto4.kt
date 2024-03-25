package com.lrincon.trendlink_laura.Taller

class Reto4 {
}

class plato() {
    var nombre: String = ""
        get(){
            return field
        }
        set(nombre) {
            field = nombre
        }
    var descripcion: String = ""
        get(){
            return field
        }
        set(descripcion) {
            field = descripcion
        }
    var precio: Int = 0
        get(){
            return field
        }
        set(precio) {
            field = precio
        }
    constructor(nombre: String, descripcion: String, precio: Int): this() {
        this.nombre = nombre
        this.descripcion = descripcion
        this.precio = precio
    }
}

class menu() {
    private val menu = mutableMapOf<String, MutableList<plato>>(
        "Entradas" to mutableListOf(),
        "Platos Fuertes" to mutableListOf(),
        "Postres" to mutableListOf(),
        "Bebidas" to mutableListOf()
    )

    fun agregarPlato(categoria: String, plato: plato) {
        menu[categoria]?.add(plato)
    }

    fun mostrarPlatos() {
        menu.forEach { (categoria, platos) ->
            println("$categoria:")
            platos.forEachIndexed { index, plato ->
                println("${index + 1}. ${plato.nombre} - ${plato.descripcion} - ${plato.precio}")
            }
            println()
        }
    }

    fun codigoPlatos(codigo: Int) {
        menu.forEach { (categoria, platos) ->
            if (codigo in 1..platos.size) {
                val plato = platos[codigo - 1]
                println("$categoria:")
                println("${codigo}. ${plato.nombre} - ${plato.descripcion} - ${plato.precio}")
                return
            }
        }
        println("No se encontró ningún plato con el código ingresado.")
    }

    fun modificarMenu(categoria: String, nuevosPlatos: List<plato>) {
        menu[categoria] = nuevosPlatos.toMutableList()
    }

    fun modificarPlato(categoria: String, codigo: Int, nuevoPlato: plato) {
        menu[categoria]?.let { platos ->
            if (codigo in 1..platos.size) {
                platos[codigo - 1] = nuevoPlato
            } else {
                println("No se encontró ningún plato con el código $codigo en la categoría $categoria.")
            }
        }
    }

    fun eliminarPlato(categoria: String, codigo: Int) {
        menu[categoria]?.let { platos ->
            if (codigo in 1..platos.size) {
                platos.removeAt(codigo - 1)
                println("Plato eliminado exitosamente.")
            } else {
                println("No se encontró ningún plato con el código $codigo en la categoría $categoria.")
            }
        }
    }
}

fun main() {
    val menu = menu()
    menu.agregarPlato("Entradas", plato("Empanadas", "4 empanadas mixtas tipo coctel", 15000))
    menu.agregarPlato("Platos Fuertes", plato("Chuleta valluna", "chuleta, papas, arroz y ensalada", 35000))
    menu.agregarPlato("Postres", plato("Copa de helado", "3 sabores de helado a elección con fruta", 15000))
    menu.agregarPlato("Bebidas", plato("Jugo de maracuyá", "Jugo de maracuya en agua o leche", 10000))

    println("--------------------Menú--------------------")
    menu.mostrarPlatos()

    println("---------La entrada con el código 1 es:------------")
    menu.codigoPlatos(1)

    println("-------------Modificando menú-------------")
    menu.modificarMenu("Platos Fuertes", listOf(
        plato("Bandeja paisa", "Frijoles, arroz, carne, platano y aguacate", 38000),
        plato("Hamburguesa", "Carne de res, vegetales, queso y papas", 30000)
    ))
    menu.mostrarPlatos()
}
