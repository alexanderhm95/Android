package com.example.quinto2020_2021;

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
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityMemoriaPrograma extends AppCompatActivity  implements View.OnClickListener {
     Button btn;
     TextView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_programa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        datos = findViewById(R.id.lblDatosAP);
        btn= findViewById(R.id.btnLeerAP);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
           case R.id.btnLeerAP:
               try {

                   InputStream input =getResources().openRawResource(R.raw.archivo_raw);
                   Toast.makeText(ActivityMemoriaPrograma.this, "Leyendo..", Toast.LENGTH_SHORT).show();
                   InputStreamReader lectora = new InputStreamReader(input);
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
               }catch (Exception ex){
                   Toast.makeText(ActivityMemoriaPrograma.this, "Leyendo.."+ex, Toast.LENGTH_SHORT).show();

                    }
                break;
        }
    }

}