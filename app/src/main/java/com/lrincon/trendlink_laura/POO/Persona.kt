package com.lrincon.trendlink_laura.POO

class Persona() {

    /*Atributos*/

    var nombre:String = ""
        get(){
            return field
        }
        set(nombre) {
        field=nombre
        }
    var edad:Int=0
        get(){
           return field

        }
        set(edad) {
        field=edad
        }
    var estatura:Double=0.0
        get(){
            return field
        }
        set(estatura) {
        field=estatura
        }
    var sexo:Boolean=false
        get(){
            return sexo
        }
        set(sexo) {
        field=sexo
        }


    //Constructor con parámetros
   constructor(nombre:String,edad:Int,estatura:Double,sexo:Boolean) : this() {
       this.nombre=nombre
        this.edad=edad
        this.estatura=estatura
        this.sexo=sexo
   }
    fun pedirDatos(){
        println("Por favor ingrese su nombre")
        nombre= readLine().toString()
        println("Por favor ingrese su sexo")
        sexo= readLine().toBoolean()
        println("Por favor ingrese su edad")
        edad= readln().toInt()
        println("Por favor ingrese su estatura")
        estatura= readln().toDouble()
    }
}

fun main(){
    val person1 = Persona()
    person1.pedirDatos()
    println("el nombre es: "+person1.nombre+"la edad es: "+person1.edad)
}