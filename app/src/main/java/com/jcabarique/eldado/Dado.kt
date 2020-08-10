package com.jcabarique.eldado

class Dado (val numDados: Int){

    fun lanzar(): Int {
        return (1..numDados).random()
    }
}