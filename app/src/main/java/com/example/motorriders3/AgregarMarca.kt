package com.example.motorriders3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class AgregarMarca : AppCompatActivity() {
    var etId: EditText?=null
    var etNombre: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_marca)

        etNombre = findViewById(R.id.et_nomCategoria)

        etId = findViewById(R.id.et_idCategoria)
    }

    fun Guardar(Vista: View){
        val url = "http://192.168.1.5/MotorRiders_Conexion/insertarCargo.php"
        val procesoEnCola: RequestQueue = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(Request.Method.POST,url,
            Response.Listener<String> { respuesta ->
                Toast.makeText(this, "Marca insertada exitosamente", Toast.LENGTH_LONG).show()
                etNombre?.setText("")
            }, Response.ErrorListener { error ->
                Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
            }){

            override fun getParams(): MutableMap<String,String> {
                val parametro = HashMap<String, String>()
                parametro.put("nomMarca", etNombre?.text.toString())

                return parametro

            }

        }

        procesoEnCola.add(resultadoPost)

    }
}