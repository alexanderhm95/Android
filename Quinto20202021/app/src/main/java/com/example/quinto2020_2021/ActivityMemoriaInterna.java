package com.example.quinto2020_2021;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityMemoriaInterna extends AppCompatActivity implements View.OnClickListener {

    EditText cajaCedula, cajaApellidos, cajaaNombres;
    Button botonLeer, botonEscribir;
    TextView datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_interna);
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
                    OutputStreamWriter escritor = new OutputStreamWriter(openFileOutput("archivo.txt", Context.MODE_APPEND));
                    escritor.write(cajaCedula.getText().toString() + " " +
                            cajaApellidos.getText().toString() + " " +
                            cajaaNombres.getText().toString() + "\n");
                    escritor.close();
                    cajaCedula.setText("");
                    cajaApellidos.setText("");
                    cajaaNombres.setText("");
                } catch (Exception ex) {
                    Log.e("Error de escritura", ex.getMessage());
                }
                break;
            case R.id.btnLeerMI:
                try {
                    InputStreamReader lectora = new InputStreamReader(openFileInput("archivo.txt"));
                    BufferedReader lectorb=new BufferedReader(lectora);
                    String linea = lectorb.readLine();
                    String cont="";
                    while(linea!=null){
                        cont=cont+linea+"\n";
                        linea=lectorb.readLine();
                    }
                    datos.setText(cont.toString());
                    lectora.close();
                    lectora.close();
                } catch (Exception e) {
                    Log.e("Error de Lectura", e.getMessage());
                }
                break;
        }
    }
}