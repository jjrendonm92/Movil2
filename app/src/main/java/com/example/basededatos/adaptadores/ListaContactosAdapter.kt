package com.example.basededatos.adaptadores

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basededatos.R
import com.example.basededatos.Ver
import com.example.basededatos.adaptadores.ListaContactosAdapter.ContactoViewHolder
import com.example.basededatos.entidades.Contactos
import java.util.Locale
import java.util.stream.Collectors

class ListaContactosAdapter(var listaContactos: ArrayList<Contactos>) :
    RecyclerView.Adapter<ContactoViewHolder>() {
    var listaOriginal: ArrayList<Contactos> = ArrayList()

    init {
        listaOriginal.addAll(listaContactos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_item_contacto, parent, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        holder.viewNombre.text = listaContactos[position].nombre
        holder.viewTelefono.text = listaContactos[position].telefono
        holder.viewCorreo.text = listaContactos[position].correo
    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewNombre: TextView = itemView.findViewById(R.id.viewNombre)
        var viewTelefono: TextView = itemView.findViewById(R.id.viewTelefono)
        var viewCorreo: TextView = itemView.findViewById(R.id.viewCorreo)

        init {
            itemView.setOnClickListener { v ->
                val context = v.context
                val intent = Intent(context, Ver::class.java)
                intent.putExtra("ID", listaContactos[bindingAdapterPosition].id)
                context.startActivity(intent)
            }
        }
    }

    fun filtrado(txtBuscar: String) {
        val longitud = txtBuscar.length

        if (longitud == 0) {
            listaContactos.clear()
            listaContactos.addAll(listaOriginal)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val collecion = listaContactos.stream()
                    .filter { i: Contactos ->
                        i.nombre.lowercase(Locale.getDefault()).contains(
                            txtBuscar.lowercase(
                                Locale.getDefault()
                            )
                        )
                    }
                    .collect(Collectors.toList())
                listaContactos.clear()
                listaContactos.addAll(collecion)
            } else {
                for (c in listaOriginal) {
                    if (c.nombre.lowercase(Locale.getDefault())
                            .contains(txtBuscar.lowercase(Locale.getDefault()))
                    ) {
                        listaContactos.add(c)
                    }
                }
            }
        }

        notifyDataSetChanged()
    }
}
