package com.example.motorriders3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response

class AgregarCategoria : AppCompatActivity() {
    var etId: EditText?=null
    var etNombre: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_categoria)

        etNombre = findViewById(R.id.et_nomCategoria)

        etId = findViewById(R.id.et_idCategoria)
    }

    fun Guardar(Vista: View){
        val url = "http://127.0.0.1/MotorRiders_Conexion/insertarCategoria.php"
        val procesoEnCola: RequestQueue = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(Request.Method.POST,url,
            Response.Listener<String> { respuesta ->
                Toast.makeText(this, "Categoria insertada exitosamente", Toast.LENGTH_LONG).show()
                etNombre?.setText("")
            }, Response.ErrorListener { error ->
                Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
            }){

            override fun getParams(): MutableMap<String,String> {
                val parametro = HashMap<String, String>()
                parametro.put("nomCategoria", etNombre?.text.toString())

                return parametro

            }

        }

        procesoEnCola.add(resultadoPost)

    }
}