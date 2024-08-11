package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Kimetsu : AppCompatActivity() {
    var identificador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kimetsu)
    }

    fun Toptier(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, Toptier::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Trailer(v: View) {
        Toast.makeText(v.context, "In process", Toast.LENGTH_LONG).show()
    }
}