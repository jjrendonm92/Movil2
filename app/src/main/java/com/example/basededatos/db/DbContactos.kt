package com.example.basededatos.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.Toast
import com.example.basededatos.entidades.Contactos

class DbContactos(var context: Context?) : DbHelper(context) {
    fun insertarContacto(nombre: String?, telefono: String?, correo: String?): Long {
        var id: Long = 0

        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        try {
            val valores = ContentValues()
            valores.put("nombre", nombre)
            valores.put("telefono", telefono)
            valores.put("correo", correo)

            id = db.insert(DbHelper.Companion.TABLE_CONTACTOS, null, valores)
        } catch (ex: Exception) {
            Toast.makeText(context!!.applicationContext, ex.toString(), Toast.LENGTH_SHORT).show()
        } finally {
            db.close()
        }

        return id
    }

    fun mostrarContactos(): ArrayList<Contactos> {
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        val listaContactos = ArrayList<Contactos>()
        var contacto: Contactos
        val cursorContactos: Cursor

        val query = "SELECT * FROM " + DbHelper.Companion.TABLE_CONTACTOS + " ORDER BY nombre ASC"

        cursorContactos = db.rawQuery(query, null)

        if (cursorContactos.moveToFirst()) {
            do {
                contacto = Contactos()
                contacto.id = cursorContactos.getInt(0)
                contacto.nombre = cursorContactos.getString(1)
                contacto.telefono = cursorContactos.getString(2)
                contacto.correo = cursorContactos.getString(3)
                listaContactos.add(contacto)
            } while (cursorContactos.moveToNext())
        } else {
            Toast.makeText(context!!.applicationContext, "no hay conexion", Toast.LENGTH_LONG)
                .show()
        }

        cursorContactos.close()
        db.close()

        return listaContactos
    }

    fun verContactos(id: Int): Contactos? {
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        var contacto: Contactos? = null
        val cursorContactos: Cursor

        val query =
            "SELECT * FROM " + DbHelper.Companion.TABLE_CONTACTOS + " WHERE id = " + id + " LIMIT 1"

        cursorContactos = db.rawQuery(query, null)

        if (cursorContactos.moveToFirst()) {
            contacto = Contactos()
            contacto.id = cursorContactos.getInt(0)
            contacto.nombre = cursorContactos.getString(1)
            contacto.telefono = cursorContactos.getString(2)
            contacto.correo = cursorContactos.getString(3)
        } else {
            Toast.makeText(context!!.applicationContext, "no hay conexion", Toast.LENGTH_LONG)
                .show()
        }

        cursorContactos.close()
        db.close()

        return contacto
    }

    fun editarContacto(id: Int, nombre: String, telefono: String, correo: String): Boolean {
        var correcto = false

        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        try {
            val query =
                "UPDATE " + DbHelper.Companion.TABLE_CONTACTOS + " SET nombre = '" + nombre + "', telefono = '" + telefono + "', correo = '" + correo + "' WHERE id='" + id + "' "
            db.execSQL(query)
            correcto = true
        } catch (ex: Exception) {
            Toast.makeText(context!!.applicationContext, ex.toString(), Toast.LENGTH_SHORT).show()
        } finally {
            db.close()
        }

        return correcto
    }

    fun eliminarContacto(id: Int): Boolean {
        var correcto = false

        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        try {
            val query =
                "DELETE FROM " + DbHelper.Companion.TABLE_CONTACTOS + " WHERE id = '" + id + "'"
            db.execSQL(query)
            correcto = true
        } catch (ex: Exception) {
            ex.toString()
            correcto = false
        } finally {
            db.close()
        }

        return correcto
    }
}
