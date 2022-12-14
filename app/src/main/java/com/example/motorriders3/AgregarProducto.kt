package com.example.motorriders3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class AgregarProducto : AppCompatActivity() {
    var etId: EditText?=null
    var etNombre: EditText?=null
    var etCosto: EditText?=null
    var etPrecio: EditText?=null
    var cbMarca: Spinner?=null
    var cbCategoria: Spinner?=null
    var etStock: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)

        etId = findViewById(R.id.et_idProducto)
        etNombre = findViewById(R.id.et_nomProducto)
        etCosto = findViewById(R.id.et_Costo)
        etPrecio = findViewById(R.id.et_Precio)
        cbMarca = findViewById(R.id.cb_Marca)
        cbCategoria = findViewById(R.id.cb_Categoria)
        etStock = findViewById(R.id.et_Stock)
    }

    fun Guardar(Vista: View){
        val url = "http://127.0.0.1/MotorRiders_Conexion/insertarProducto.php"
        val procesoEnCola: RequestQueue = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(Request.Method.POST,url,
            Response.Listener<String> { respuesta ->
                Toast.makeText(this, "Producto insertado exitosamente", Toast.LENGTH_LONG).show()
                etNombre?.setText("")
                etCosto?.setText("")
                etPrecio?.setText("")
                //cbMarca?.setText("")
                //cbCategoria?.setText("")
                etStock?.setText("")

            }, Response.ErrorListener { error ->
                Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
            }){

            override fun getParams(): MutableMap<String,String> {
                val parametro = HashMap<String, String>()
                parametro.put("nomProducto", etNombre?.text.toString())
                parametro.put("costo", etCosto?.text.toString())
                parametro.put("precio", etPrecio?.text.toString())
                //parametro.put("idMarca", cbMarca?.text.toString())
                //parametro.put("idCategoria", cbCategoria?.text.toString())
                parametro.put("stock", etStock?.text.toString())

                return parametro

            }

        }

        procesoEnCola.add(resultadoPost)

    }
}