package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Likes : AppCompatActivity() {
    var identificador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_likes)

        val etidentificador = findViewById<EditText>(R.id.editTextText)
        val identificador = intent.getStringExtra("identificador")
        etidentificador.setText(identificador)
    }

    fun Posts(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, TercerActivity::class.java)

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

    fun Alrlikes(v: View) {
        Toast.makeText(v.context, "You're already in Likes", Toast.LENGTH_LONG).show()
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