package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Toptier : AppCompatActivity() {
    var identificador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toptier)
    }

    /*Botones de abajo */
    fun Home(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, ParaTi::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Alrtoptier(v: View) {
        Toast.makeText(v.context, "You're already in Top Tier", Toast.LENGTH_LONG).show()
    }

    fun Settings(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun Profile(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, TercerActivity::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Mushoku(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun Kimetsu(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun Scarface(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun Pulp(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun TWD(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun Theboys(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }
}