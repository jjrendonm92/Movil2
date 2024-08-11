package com.example.basededatos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basededatos.db.DbContactos
import com.example.basededatos.entidades.Contactos
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditarActivity : AppCompatActivity() {
    var identificador: String = ""
    var txtNombre: EditText? = null
    var txtTelefono: EditText? = null
    var txtCorreo: EditText? = null
    var btnGuarda: Button? = null
    var btnSalir: Button? = null
    var fabEditar: FloatingActionButton? = null
    var fabEliminar: FloatingActionButton? = null
    var correcto: Boolean = false
    var contacto: Contactos? = null
    var id: Int = 0

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver)

        InicializarElementos()

        if (savedInstanceState == null) {
            val extras = intent.extras
            id = extras?.getInt("ID") ?: null!!.toInt()
        } else {
            id = savedInstanceState.getSerializable("ID") as Int
        }

        val dbContactos = DbContactos(this@EditarActivity)
        contacto = dbContactos.verContactos(id)

        if (contacto != null) {
            txtNombre!!.setText(contacto!!.nombre)
            txtTelefono!!.setText(contacto!!.telefono)
            txtCorreo!!.setText(contacto!!.correo)
        }

        btnGuarda!!.setOnClickListener {
            if (txtNombre!!.text.toString() != "" && txtTelefono!!.text.toString() != "") {
                correcto = dbContactos.editarContacto(
                    id,
                    txtNombre!!.text.toString(),
                    txtTelefono!!.text.toString(),
                    txtCorreo!!.text.toString()
                )

                if (correcto) {
                    Toast.makeText(this@EditarActivity, "REGISTRO MODIFICADO", Toast.LENGTH_LONG)
                        .show()
                    verRegistro()
                } else {
                    Toast.makeText(
                        this@EditarActivity,
                        "ERROR AL MODIFICAR REGISTRO",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(
                    this@EditarActivity,
                    "DEBE LLENAR LOS CAMPOS OBLIGATORIOS",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun InicializarElementos() {
        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtCorreo = findViewById(R.id.txtCorreoElectronico)
        btnGuarda = findViewById(R.id.btnGuarda)
        btnSalir = findViewById(R.id.btnSalir)
        btnSalir.setVisibility(View.INVISIBLE)
        fabEditar = findViewById(R.id.fabEditar)
        fabEditar.setVisibility(View.INVISIBLE)
        fabEliminar = findViewById(R.id.fabEliminar)
        fabEliminar.setVisibility(View.INVISIBLE)
    }

    private fun verRegistro() {
        val etidentificador = findViewById<EditText>(R.id.editTextText4)
        identificador = etidentificador.text.toString()
        val intent = Intent(this, Ver::class.java)
        intent.putExtra("identificador", identificador)
        intent.putExtra("ID", id)
        startActivity(intent)
    }
}