package com.jcabarique.eldado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Views
    val turno: TextView = findViewById(R.id.textTurno)
    val listGanadores: ListView = findViewById(R.id.listGanadores)
    val listJugadores: ListView = findViewById(R.id.listJugadores)

    // Variables de funcionamiento
    var jugador: Int = 1
    val arrayLanzamientos: ArrayList<Int> = arrayListOf<Int>()
    val arrayGanadores: ArrayList<String> = arrayListOf<String>()
    var arrayAdapterJugadores: ArrayAdapter<Int> = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, arrayLanzamientos)
    var arrayAdapterGanadores: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayGanadores)
    var terminar: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun onClickLanzar(view: View) {
        if(!terminar){
            turno.text = "Turno jugador: " + jugador.toString()
            val dado = Dado(6)
            val valDado = dado.lanzar()
            arrayLanzamientos.add(valDado)

            when (valDado){
                1 -> imageView.setImageResource(R.drawable.dice_1)
                2 -> imageView.setImageResource(R.drawable.dice_2)
                3 -> imageView.setImageResource(R.drawable.dice_3)
                4 -> imageView.setImageResource(R.drawable.dice_4)
                5 -> imageView.setImageResource(R.drawable.dice_5)
                6 -> imageView.setImageResource(R.drawable.dice_6)
            }
            jugador+=1
        }
    }

    fun onClickTerminar(view: View) {
        var mayor: Int = 0
        for ((i, value) in arrayLanzamientos.withIndex()){
            if (value > mayor) {
                mayor = value
            }
        }
        // Añade cual o cuales jugadores tienen el numero de dado mayor
        for ((i, value) in arrayLanzamientos.withIndex()){
            if (value == mayor) {
               arrayGanadores.add("Jugador " + (i + 1).toString())
            }
        }

        listJugadores.adapter = arrayAdapterJugadores
        listGanadores.adapter = arrayAdapterGanadores

        terminar = true
    }

    fun onClickReiniciar(view: View) {
        terminar = false
        arrayLanzamientos.clear()
        arrayGanadores.clear()
    }
}