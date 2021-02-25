package com.example.quinto2020_2021;

import android.content.Context;
import android.os.Bundle;

import com.example.quinto2020_2021.controlador.swvolley.ServicioWebVolly;
import com.example.quinto2020_2021.modelos.Alumno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActivityVolleyAlumno extends AppCompatActivity implements View.OnClickListener {
    EditText cajaId, cajanombre,cajaDireccion;
    Button btnguardar, btnBuscartodos;
    TextView datos;
    RecyclerView recyclerViewAlumno;
    ServicioWebVolly servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_alumno);
       cargarComponentes();
    }
    private void cargarComponentes(){
        cajaId= findViewById(R.id.txtid);
        cajanombre=findViewById(R.id.txtNombre);
        cajaDireccion=findViewById(R.id.txtDireccion);
        datos= findViewById(R.id.lbldatos);
        btnguardar=findViewById(R.id.btninsertar);
        btnBuscartodos=findViewById(R.id.btnleer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btninsertar:
                Alumno alumno= new Alumno();
                alumno.setNombre(cajanombre.getText().toString());
                alumno.setDireccion(cajaDireccion.getText().toString());

                try {
                    boolean estado=servicio.insert(alumno);
                    if(estado)
                        Toast.makeText(ActivityVolleyAlumno.this,"Alumno registrado", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(ActivityVolleyAlumno.this,"Alumno no registrado", Toast.LENGTH_SHORT).show();
                    break;

                }catch (Exception ex){
                   ex.printStackTrace();
                }
                break;
        }
    }
}