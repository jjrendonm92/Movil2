package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TercerActivity : AppCompatActivity() {
    var identificador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tercer)

        val etidentificador = findViewById<EditText>(R.id.editTextText)
        val identificador = intent.getStringExtra("identificador")
        etidentificador.setText(identificador)
    }

    fun Likes(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, Likes::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Recommendation(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, Recommendation::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Alrpost(v: View) {
        Toast.makeText(v.context, "You're already in Posts", Toast.LENGTH_LONG).show()
    }

    /*Botones de abajo */
    fun Home(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, ParaTi::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
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

    fun Alrprofile(v: View) {
        Toast.makeText(v.context, "You're already in Profile", Toast.LENGTH_LONG).show()
    }
}