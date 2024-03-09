package com.lrincon.trendlink_laura.Funciones

class funciones {
}

fun Hello(){
    println("Hola Laura")
}

fun printHello(name: String?): Unit{
    println("Hola, ¿cómo estás?")
}

fun printHello2(name: String?){
    println("Holaaa " + name)
}

fun main(){
    Hello()
    printHello("Valentina")
    printHello2("Alejandra")
}