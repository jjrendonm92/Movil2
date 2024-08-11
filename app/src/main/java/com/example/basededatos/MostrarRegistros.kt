package com.example.basededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basededatos.adaptadores.ListaContactosAdapter
import com.example.basededatos.db.DbContactos
import com.example.basededatos.entidades.Contactos

class MostrarRegistros : AppCompatActivity(), SearchView.OnQueryTextListener {
    var identificador: String = ""
    var listaContactos: RecyclerView? = null
    var listaArrayContactos: ArrayList<Contactos>? = null
    var adapter: ListaContactosAdapter? = null

    var txtBuscar: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_registros)

        InicializarElementos()

        val dbContactos = DbContactos(this@MostrarRegistros)

        listaArrayContactos = ArrayList()

        adapter = ListaContactosAdapter(dbContactos.mostrarContactos())
        listaContactos!!.adapter = adapter

        listaContactos!!.layoutManager = LinearLayoutManager(this)

        txtBuscar!!.setOnQueryTextListener(this)
    }

    private fun InicializarElementos() {
        txtBuscar = findViewById(R.id.txtBuscar)
        listaContactos = findViewById(R.id.listaContactos)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        adapter!!.filtrado(newText)
        return false
    }

    fun Profile(v: View) {
        val etidentificador = findViewById<EditText>(R.id.editTextText)
        identificador = etidentificador.text.toString()

        val intent = Intent(v.context, TercerActivity::class.java)

        intent.putExtra("identificador", identificador)
        startActivity(intent)
    }
}