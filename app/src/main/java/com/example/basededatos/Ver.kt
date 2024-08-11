package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.basededatos.db.DbContactos
import com.example.basededatos.entidades.Contactos
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ver : AppCompatActivity() {
    var identificador: String = ""
    var txtNombre: EditText? = null
    var txtTelefono: EditText? = null
    var txtCorreo: EditText? = null
    var btnGuardar: Button? = null
    var btnSalir: Button? = null
    var fabEditar: FloatingActionButton? = null
    var fabEliminar: FloatingActionButton? = null

    var contacto: Contactos? = null
    var id: Int = 0

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

        val dbContactos = DbContactos(this@Ver)
        contacto = dbContactos.verContactos(id)

        if (contacto != null) {
            txtNombre!!.setText(contacto!!.nombre)
            txtTelefono!!.setText(contacto!!.telefono)
            txtCorreo!!.setText(contacto!!.correo)
            txtNombre!!.inputType = InputType.TYPE_NULL
            txtTelefono!!.inputType = InputType.TYPE_NULL
            txtCorreo!!.inputType = InputType.TYPE_NULL
        }

        fabEditar!!.setOnClickListener {
            val etidentificador = findViewById<EditText>(R.id.editTextText4)
            identificador = etidentificador.text.toString()
            val intent = Intent(this@Ver, EditarActivity::class.java)
            intent.putExtra("identificador", identificador)
            intent.putExtra("ID", id)
            startActivity(intent)
        }

        fabEliminar!!.setOnClickListener {
            val builder = AlertDialog.Builder(this@Ver)
            builder.setMessage("¿Desea eliminar este contacto?")
                .setPositiveButton("SI") { dialogInterface, i ->
                    if (dbContactos.eliminarContacto(id)) {
                        lista()
                    }
                }
                .setNegativeButton("NO") { dialogInterface, i -> }.show()
        }


        btnSalir!!.setOnClickListener {
            val etidentificador = findViewById<EditText>(R.id.editTextText4)
            identificador = etidentificador.text.toString()
            val intent = Intent(this@Ver, TercerActivity::class.java)
            intent.putExtra("identificador", identificador)
            startActivity(intent)
        }
    }

    private fun InicializarElementos() {
        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtCorreo = findViewById(R.id.txtCorreoElectronico)
        fabEditar = findViewById(R.id.fabEditar)
        fabEliminar = findViewById(R.id.fabEliminar)
        btnGuardar = findViewById(R.id.btnGuarda)
        btnGuardar.setVisibility(View.INVISIBLE)
        btnSalir = findViewById(R.id.btnSalir)
    }

    private fun lista() {
        val etidentificador = findViewById<EditText>(R.id.editTextText4)
        identificador = etidentificador.text.toString()
        val intent = Intent(this, TercerActivity::class.java)
        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }
}