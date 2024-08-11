package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var identificador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Login(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, TercerActivity::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)

        Toast.makeText(v.context, "Welcome to GeekGG", Toast.LENGTH_LONG).show()
    }

    fun CreatAccount(view: View) {
        val intent = Intent(view.context, SegundoActivity::class.java)
        startActivity(intent)
    }
}