package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ParaTi : AppCompatActivity() {
    var identificador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_para_ti)
    }

    fun Alrparati(v: View) {
        Toast.makeText(v.context, "You're already in For You", Toast.LENGTH_LONG).show()
    }

    fun Follows(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, Follows::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    /*Botones de abajo */
    fun Alrhome(v: View) {
        Toast.makeText(v.context, "You're already in For You", Toast.LENGTH_LONG).show()
    }

    fun Toptier(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, Toptier::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Settings(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }

    fun Profile(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, ParaTi::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }
}