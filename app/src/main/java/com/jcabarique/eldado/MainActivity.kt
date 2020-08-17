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

    // Variables de funcionamiento
    var jugador: Int = 1
    var terminar: Boolean = false
    var tuplas = arrayOf(0,0,0,0,0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun onClickLanzar(view: View) {
        val turno: TextView = findViewById(R.id.textTurno)
        if(jugador !== 6){
            val dado = Dado(6)
            val valDado = dado.lanzar()

            // Guarda el valor de cada lanzamiento
            tuplas.set(jugador - 1, valDado)

            when (valDado){
                1 -> imageView.setImageResource(R.drawable.dice_1)
                2 -> imageView.setImageResource(R.drawable.dice_2)
                3 -> imageView.setImageResource(R.drawable.dice_3)
                4 -> imageView.setImageResource(R.drawable.dice_4)
                5 -> imageView.setImageResource(R.drawable.dice_5)
                6 -> imageView.setImageResource(R.drawable.dice_6)
            }
            // Muesta el turno en pantalla
            jugador+=1
            turno.text = "Turno jugador: " + jugador.toString()
        }

        if(jugador === 6){
            val resultadoText: TextView = findViewById(R.id.textView)
            var turnos: String = "";

           for (item in tuplas){
                turnos+= item.toString() + '-'
            }

            resultadoText.text = turnos
            turno.text = "Game over"
        }
    }


    fun onClickReiniciar(view: View) {
        terminar = false
        val turno: TextView = findViewById(R.id.textTurno)
        val resultadoText: TextView = findViewById(R.id.textView)
        resultadoText.text = ""
        turno.text = "Turno jugador: 1 "
        jugador = 2
    }
}