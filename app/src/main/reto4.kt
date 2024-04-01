package com.example.fundamentoskotlin.tallerPOO

class reto4 {
}
class Plato(
    var nombre: String = "",
    var descripcion: String = "",
    var precio: Double = 0.0
)

class MenuRestaurante {
    private val menu = mutableMapOf<String, MutableList<Plato>>(
        "Entradas" to mutableListOf(),
        "Platos Fuertes" to mutableListOf(),
        "Postres" to mutableListOf(),
        "Bebidas" to mutableListOf()
    )

    fun agregarPlato(categoria: String, plato: Plato) {
        menu[categoria]?.add(plato)
    }

    fun mostrarPlatos() {
        menu.forEach { (categoria, platos) ->
            println("$categoria:")
            platos.forEachIndexed { index, plato ->
                println("${index + 1}. ${plato.nombre} - ${plato.descripcion} - \$${plato.precio}")
            }
            println()
        }
    }

    fun mostrarPlatoPorCodigo(codigoCategoria: String, codigoPlato: Int) {
        val platosCategoria = menu[codigoCategoria]
        platosCategoria?.let {
            if (codigoPlato in 1..it.size) {
                val plato = it[codigoPlato - 1]
                println("$codigoCategoria ${codigoPlato}: ${plato.nombre} - ${plato.descripcion} - \$${plato.precio}")
            } else {
                println("Código de plato inválido.")
            }
        } ?: println("Categoría no encontrada.")
    }

    fun modificarMenu(categoria: String, nuevosPlatos: List<Plato>) {
        menu[categoria] = nuevosPlatos.toMutableList()
    }

    fun modificarPlato(categoria: String, codigoPlato: Int, nuevoPlato: Plato) {
        val platosCategoria = menu[categoria]
        platosCategoria?.let {
            if (codigoPlato in 1..it.size) {
                it[codigoPlato - 1] = nuevoPlato
                println("Plato modificado exitosamente.")
            } else {
                println("Código de plato inválido.")
            }
        } ?: println("Categoría no encontrada.")
    }

    fun eliminarPlato(categoria: String, codigoPlato: Int) {
        val platosCategoria = menu[categoria]
        platosCategoria?.let {
            if (codigoPlato in 1..it.size) {
                it.removeAt(codigoPlato - 1)
                println("Plato eliminado exitosamente.")
            } else {
                println("Código de plato inválido.")
            }
        } ?: println("Categoría no encontrada.")
    }
}

fun main() {
    val menu = MenuRestaurante()

    // Agregar algunos platos al menú
    menu.agregarPlato("Entradas", Plato("Ensalada", "Mezcla de lechuga, pollo, crutones y aderezo", 15.900))
    menu.agregarPlato("Platos Fuertes", Plato("Filete", "Filete de carne de res con vegetales y puré de papa", 44.900))
    menu.agregarPlato("Postres", Plato("Torta de Chocolate", "Torta de chocolate", 11.900))
    menu.agregarPlato("Bebidas", Plato("Vino", "Botella de vino", 32.900))

    // Mostrar el menú completo
    println("---- Menú ----")
    menu.mostrarPlatos()
    println()

    // Mostrar un plato por código
    println("---- Mostrar Plato Por Código ----")
    menu.mostrarPlatoPorCodigo("Entradas", 1)
    println()

    // Modificar el menú
    println("---- Modificar Menú ----")
    menu.modificarMenu("Platos Fuertes", listOf(
        Plato("Bandeja Paisa", "Plato típico con arroz, frijoles, carne, aguacate y plátano", 37.900),
        Plato("Pasta con pollo", "Pasta con salsa blanca y pollo", 25.900)
    ))
    menu.mostrarPlatos()
    println()

    // Modificar un plato existente
    println("---- Modificar Plato ----")
    menu.modificarPlato("Postres", 1, Plato("Torta de Manzana", "Tarta de manzana con helado", 10.000))
    menu.mostrarPlatos()
    println()

    // Eliminar un plato
    println("---- Eliminar Plato ----")
    menu.eliminarPlato("Bebidas", 1)
    menu.mostrarPlatos()
}
