package com.lrincon.trendlink_laura.Quiz
import kotlin.math.sqrt

class Calculadora {
}

fun suma(n1: Double, n2: Double){
    println("La suma es ${n1 + n2}")
}

fun resta(n1: Double, n2: Double){
    println("La resta es ${n1 - n2}")
}

fun multiplicacion(n1: Double, n2: Double){
    println("La multiplicación es ${n1 * n2}")
}

fun division(n1: Double, n2: Double){
    println("La división es ${n1/n2}")
}

fun raiz(n1: Double, n2: Double){
    println("La raíz cuadrada del primer número es ${sqrt(n1)} y del segundo número es ${sqrt(n2)}")
}

fun potencia(n1: Double, n2: Double){
    println("La potencia es ${Math.pow(n2, n1)}")
}


fun main(){
    println("La opciones de operaciones son: 1.Suma, 2.Resta, 3.Multiplicacion, 4.Division, 5.Raiz cuadrada, 6.Potenciacion" +
            ". Por favor escriba el número de la operacion que desea hacer:")
    var operacion= readLine()!!.toInt()

    print("Ingrese primer número: ")
    var n1= readLine()!!.toDouble()

    print("Ingrese segundo número: ")
    var n2= readLine()!!.toDouble()

    when (operacion){
        1-> suma(n1,n2)
        2-> resta(n1,n2)
        3-> multiplicacion(n1,n2)
        4-> division(n1,n2)
        5-> raiz(n1,n2)
        6-> potencia(n1,n2)
    }
}