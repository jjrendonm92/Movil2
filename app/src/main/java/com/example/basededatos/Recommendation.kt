package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basededatos.db.DbHelper

class Recommendation : AppCompatActivity() {
    var identificador: String = ""

    var btCrear: Button? = null
    var btnInsertarActivity: Button? = null
    var btnMostrarActivity: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        val etidentificador = findViewById<EditText>(R.id.editTextText)
        val identificador = intent.getStringExtra("identificador")
        etidentificador.setText(identificador)

        InicializarElementos()

        btCrear!!.setOnClickListener { CrearBaseDeDatos() }

        btnInsertarActivity!!.setOnClickListener {
            val etidentificador = findViewById<EditText>(R.id.editTextText)
            val identificador = intent.getStringExtra("identificador")
            etidentificador.setText(identificador)
            val intent = Intent(applicationContext, InsertarRegistro::class.java)
            intent.putExtra("identificador", identificador)
            startActivity(intent)
        }

        btnMostrarActivity!!.setOnClickListener {
            val etidentificador = findViewById<EditText>(R.id.editTextText)
            val identificador = intent.getStringExtra("identificador")
            etidentificador.setText(identificador)
            val intent = Intent(applicationContext, MostrarRegistros::class.java)
            intent.putExtra("identificador", identificador)
            startActivity(intent)
        }
    }

    private fun InicializarElementos() {
        btCrear = findViewById<View>(R.id.btnCrear) as Button
        btnInsertarActivity = findViewById<View>(R.id.btnInsertarActivity) as Button
        btnMostrarActivity = findViewById<View>(R.id.btnMostrarActivity) as Button
    }

    fun CrearBaseDeDatos() {
        val dbHelper = DbHelper(this@Recommendation)
        val db = dbHelper.writableDatabase

        if (db != null) {
            Toast.makeText(applicationContext, "Base de Datos Creada", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                applicationContext,
                "Error al Crear Base de Datos Creada",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun Posts(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, TercerActivity::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Likes(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, Likes::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }

    fun Alrrecommendation(v: View) {
        Toast.makeText(v.context, "You're already in Tier List", Toast.LENGTH_LONG).show()
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