package com.example.proyectobase_felipepalaciosstgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Pokemon;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Pokemon po = new Pokemon();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw);

        //Obtener la ruta del video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);



        video.start();
    }

    public void Pokemon(View view)
    {
        Intent i = new Intent(this, Kilometros_act.class);
        //Preparo los extras
        Bundle bun = new Bundle();
        bun.putStringArray("pokemon",po.getPokemon());
        i.putExtras(bun);
        startActivity(i);
    }

    public void Clases(View view)
    {
        Intent i = new Intent(this, Clases_act.class);
        startActivity(i);
    }
}