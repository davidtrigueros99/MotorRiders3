package com.example.motorriders3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnAgregar(Vista: View){
        var ventana: Intent = Intent(applicationContext, activity_agregar::class.java)
        startActivity(ventana)
    }
}