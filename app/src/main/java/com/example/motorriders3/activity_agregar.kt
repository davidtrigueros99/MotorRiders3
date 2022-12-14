package com.example.motorriders3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class activity_agregar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)
    }

    fun btnAddCategoria(Vista: View){
        var ventana: Intent = Intent(applicationContext, AgregarCategoria::class.java)
        startActivity(ventana)
    }

    fun btnAddCargo(Vista: View){
        var ventana: Intent = Intent(applicationContext, AgregarCargo::class.java)
        startActivity(ventana)
    }

    fun btnAddCliente(Vista: View){
        var ventana: Intent = Intent(applicationContext, AgregarCliente::class.java)
        startActivity(ventana)
    }

    fun btnAddEmpleado(Vista: View){
        var ventana: Intent = Intent(applicationContext, AgregarEmpleado::class.java)
        startActivity(ventana)
    }

    fun btnAddMarca(Vista: View){
        var ventana: Intent = Intent(applicationContext, AgregarMarca::class.java)
        startActivity(ventana)
    }

    fun btnAddProducto(Vista: View){
        var ventana: Intent = Intent(applicationContext, AgregarProducto::class.java)
        startActivity(ventana)
    }
}