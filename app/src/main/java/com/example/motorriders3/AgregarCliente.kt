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

class AgregarCliente : AppCompatActivity() {
    var etId: EditText?=null
    var etDui: EditText?=null
    var etNombre: EditText?=null
    var etTelefono: EditText?=null
    var etDireccion: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        etId = findViewById(R.id.et_idCliente)
        etDui = findViewById(R.id.et_Dui)
        etNombre = findViewById(R.id.et_NomCliente)
        etTelefono = findViewById(R.id.et_Telefono)
        etDireccion = findViewById(R.id.et_Direccion)
    }

    fun Guardar(Vista: View){
        val url = "http://192.168.1.5/MotorRiders_Conexion/insertarCliente.php"
        val procesoEnCola: RequestQueue = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(Request.Method.POST,url,
            Response.Listener<String> { respuesta ->
                Toast.makeText(this, "Cliente insertado exitosamente", Toast.LENGTH_LONG).show()
                etDui?.setText("")
                etNombre?.setText("")
                etTelefono?.setText("")
                etDireccion?.setText("")
            }, Response.ErrorListener { error ->
                Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
            }){

            override fun getParams(): MutableMap<String,String> {
                val parametro = HashMap<String, String>()
                parametro.put("dui", etDui?.text.toString())
                parametro.put("nombre", etNombre?.text.toString())
                parametro.put("telefono", etTelefono?.text.toString())
                parametro.put("direccion", etDireccion?.text.toString())

                return parametro

            }

        }

        procesoEnCola.add(resultadoPost)

    }
}