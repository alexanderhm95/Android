package com.example.quinto2020_2021.controlador.swvolley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quinto2020_2021.modelos.Alumno;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServicioWebVolly {
    String host = "http://reneguaman.000webhostapp.com/";
    String insertar_url = "insertar_alumnos.php";
    String GET = "obtener_alumnos.php";
    Context context;
    boolean estado;

    List<Alumno> listaAlumnos;
    public ServicioWebVolly(Context context){
        this.context=context;
        listaAlumnos=new ArrayList<Alumno>();
    }

    public boolean insert(Alumno alumno) throws JSONException {
        String url= host+insertar_url;
        JSONObject json=new JSONObject();

        json.put("nombre",alumno.getNombre());
        json.put("direccion",alumno.getDireccion());

        JsonObjectRequest request= new JsonObjectRequest(
                Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                estado = true;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                estado=false;
            }
        }
        );
        return estado;
    }
    public boolean obtenerAlumnos(){
        return Boolean.FALSE;
    }


}
