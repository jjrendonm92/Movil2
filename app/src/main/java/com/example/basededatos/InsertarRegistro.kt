package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basededatos.db.DbContactos

class InsertarRegistro : AppCompatActivity() {
    var identificador: String = ""
    var etNombre: EditText? = null
    var etTelefono: EditText? = null
    var etCorreo: EditText? = null
    var btnInsertar: Button? = null
    var nombre: String? = null
    var telefono: String? = null
    var correo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_registro)

        InicializarElementos()

        btnInsertar!!.setOnClickListener { InsertarElemento() }
    }

    private fun InicializarElementos() {
        etNombre = findViewById<View>(R.id.etNombre) as EditText
        etTelefono = findViewById<View>(R.id.etTelefono) as EditText
        etCorreo = findViewById<View>(R.id.etCorreo) as EditText
        btnInsertar = findViewById<View>(R.id.btnInsertar) as Button
    }

    fun InsertarElemento() {
        var id: Long = 0

        nombre = etNombre!!.text.toString()
        telefono = etTelefono!!.text.toString()
        correo = etCorreo!!.text.toString()

        try {
            val dbContactos = DbContactos(applicationContext)
            id = dbContactos.insertarContacto(nombre, telefono, correo)
        } catch (ex: Exception) {
            Toast.makeText(applicationContext, "Error en Registro", Toast.LENGTH_LONG).show()
        }

        if (id != 0L) {
            Toast.makeText(applicationContext, "Registro Agregado con éxito", Toast.LENGTH_LONG)
                .show()

            etNombre!!.setText("")
            etTelefono!!.setText("")
            etCorreo!!.setText("")
        }
    }

    fun Profile(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, TercerActivity::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }
}