package com.example.fundamentoskotlin.tallerPOO

class reto2 {
}

class Cancion(val titulo: String, val artista: String, val fechaPublicacion: Int, var reproducciones: Int) {
    fun descripcionCancion() {
        println("$titulo, interpretada por $artista, se lanzó en $fechaPublicacion, y tiene $reproducciones reproducciones")
    }
}

class Album(val nombre: String, val tipoMusica: String, val canciones: MutableList<Cancion>) {

    fun cantidadCanciones(): Int {
        return canciones.size
    }

    fun cancionMasPopular(): Cancion? {
        var masPopular: Cancion? = null
        var maxReproducciones = 0
        for (cancion in canciones) {
            if (cancion.reproducciones > maxReproducciones) {
                masPopular = cancion
                maxReproducciones = cancion.reproducciones
            }
        }
        return masPopular
    }

    fun evaluarPopularidad() {
        println("Popularidad de las canciones del album $nombre: ")
        for (cancion in canciones) {
            val popularidad = if (cancion.reproducciones < 1000) "poco popular" else "popular"
            println("${cancion.titulo} es $popularidad (${cancion.reproducciones} reproducciones)")
        }
    }

    fun imprimirDescripciones() {
        println("Descripciones de las canciones del album $nombre:")
        for (cancion in canciones) {
            cancion.descripcionCancion()
        }
    }
}

fun main() {
    val cancionesAlbum = mutableListOf(
        Cancion("Cancion 1", "Artista 1", 2020, 1530),
        Cancion("Cancion 2", "Artista 2", 2019, 811),
        Cancion("Cancion 3", "Artista 3", 2021, 2000)
    )

    val miAlbum = Album("Mi album prueba ", "Rock", cancionesAlbum)

    println("El album ${miAlbum.nombre} tiene ${miAlbum.cantidadCanciones()} canciones")

    val cancionPopular = miAlbum.cancionMasPopular()
    println("La cancion mas popular del album es ${cancionPopular?.titulo ?: "Ninguna"}")

    miAlbum.evaluarPopularidad()

    miAlbum.imprimirDescripciones()
}
