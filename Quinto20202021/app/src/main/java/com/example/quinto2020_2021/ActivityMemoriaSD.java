package com.example.quinto2020_2021;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityMemoriaSD extends AppCompatActivity implements View.OnClickListener {
    EditText cajaCedula, cajaApellidos, cajaaNombres;
    Button botonLeer, botonEscribir;
    TextView datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_s_d);
        cajaCedula = findViewById(R.id.txtCedulaMI);
        cajaApellidos = findViewById(R.id.txtApellidosMI);
        cajaaNombres = findViewById(R.id.txtNombresMI);
        botonEscribir = findViewById(R.id.btnEscribirMI);
        botonLeer = findViewById(R.id.btnLeerMI);
        datos = findViewById(R.id.lblDatosMI);
        botonEscribir.setOnClickListener(this);
        botonLeer.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEscribirMI:
                try {
                    String nomarchivo="archivosd";
                    File file =new  File(getExternalFilesDir(null), nomarchivo);
                    OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream(file));
                    escritor.write(cajaCedula.getText().toString() + " " +
                            cajaApellidos.getText().toString() + " " +
                            cajaaNombres.getText().toString() + "\n");
                    escritor.close();
                    cajaCedula.setText("");
                    cajaApellidos.setText("");
                    cajaaNombres.setText("");
                } catch (Exception ex) {

                    Toast.makeText(ActivityMemoriaSD.this, "Leyendo.."+ex.getMessage(), Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.btnLeerMI:
                String nomarchivo="archivosd";
                File file =new  File(getExternalFilesDir(null), nomarchivo.toString());
                try {
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader archivo = new InputStreamReader(fIn);
                    BufferedReader br = new BufferedReader(archivo);
                    String linea = br.readLine();
                    String cont="";
                    while(linea!=null){
                        cont=cont+linea+"\n";
                        linea=br.readLine();
                    }
                    datos.setText(cont.toString());
                    br.close();
                } catch (Exception e) {
                    Log.e("Error de Lectura", e.getMessage());
                }
                break;
        }
    }
}