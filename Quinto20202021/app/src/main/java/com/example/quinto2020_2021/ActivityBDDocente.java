package com.example.quinto2020_2021;

import android.os.Bundle;

import com.example.quinto2020_2021.adapters.DocenteAdapter;
import com.example.quinto2020_2021.modelos.Docente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityBDDocente extends AppCompatActivity implements View.OnClickListener {
    EditText cajaCedula, cajaApellidos, cajaaNombres;
    Button btninsertar, btnmodificar,btneliminar,btneliminartodo,btnbuscar , btnbuscartodo;
    TextView datos;
    HelperBDDocente helper;
    RecyclerView recyclerView;
    List<Docente> lista;
    DocenteAdapter docenteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_d_docente);
        cargarcomponentes();
        helper= new HelperBDDocente(this,"bda1",null,1);
        lista =new ArrayList<Docente>();
        lista=helper.getAllDocentes();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        docenteAdapter= new DocenteAdapter(lista);
    }


 private  void cargarcomponentes(){
     cajaCedula = findViewById(R.id.txtCedulaDB);
     cajaApellidos = findViewById(R.id.txtApellidosDB);
     cajaaNombres = findViewById(R.id.txtNombresDB);

     btninsertar=findViewById(R.id.btninsertar);
     btnmodificar= findViewById(R.id.btnmodificar);
     btneliminar = findViewById(R.id.btneliminarced);
     btneliminartodo= findViewById(R.id.btneliminarall);
     btnbuscar = findViewById(R.id.btnbuscarced);
     btnbuscartodo = findViewById(R.id.btnlistarall);
     datos=findViewById(R.id.lblDatosAP);
     recyclerView =findViewById(R.id.Recycledocente);
     btninsertar.setOnClickListener(this);
     btnmodificar.setOnClickListener(this);
     btneliminar.setOnClickListener(this);
     btneliminartodo.setOnClickListener(this);
     btnbuscar.setOnClickListener(this);
     btnbuscartodo.setOnClickListener(this);
 }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btninsertar:
                Docente docente=new Docente();
                docente.setCedula(cajaCedula.getText().toString());
                docente.setNombres(cajaApellidos.getText().toString());
                docente.setApellidos(cajaaNombres.getText().toString());
                helper.insertar(docente);
                break;
            case R.id.btnlistarall:
                datos.setText(helper.leerTodos());
                break;
        }
    }
}