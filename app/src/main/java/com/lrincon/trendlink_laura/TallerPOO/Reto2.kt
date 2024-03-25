package com.lrincon.trendlink_laura.Taller

class Reto2 {
}

class Cancion(var titulo: String, var artista: String, var anioPublicacion: Int, var reproducciones: Int) {
    fun infoCancion(): String {
        return "La canción $titulo interpretada por $artista se lanzó en el año $anioPublicacion y obtuvo " +
                "$reproducciones cantidad de reproducciones"
    }
}

class Album(val tipoMusica: String, val canciones: List<Cancion>) {
    fun cantidadCanciones(): Int {
        return canciones.size
    }

    fun cancionPopular(): Cancion? {
        return canciones.maxByOrNull { it.reproducciones }
    }

    fun popularidadCanciones() {
        println("---------------------Canciones populares del álbum---------------------")
        for (cancion in canciones) {
            val popularidad = if (cancion.reproducciones >= 1000){
                "Popular"
            } else {
                "Poco popular"
            }
            println("La canción ${cancion.titulo} es $popularidad")
        }
    }
}

fun main() {
    val canciones = listOf(
        Cancion("Primera", "Cantante 1", 2024, 1000),
        Cancion("Segunda", "Cantante 2", 2023, 100),
        Cancion("Tercera", "Cantante 3", 2022, 3000),
        Cancion("Cuarta", "Cantante 3", 2021, 999)
    )

    val album = Album("Salsa", canciones)

    println("El álbum tiene ${album.cantidadCanciones()} canciones y el tipo de música es ${album.tipoMusica}")

    val cancionPopular = album.cancionPopular()
    if (cancionPopular != null) {
        println("La canción más popular es ${cancionPopular.titulo} y tiene ${cancionPopular.reproducciones} reproducciones")
    }

    album.popularidadCanciones()

    println("---------------------Información canciones---------------------")
    for (cancion in canciones) {
        println(cancion.infoCancion())
    }
}
