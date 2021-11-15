package com.example.proyectobase_felipepalaciosstgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Pokemon;

public class Kilometros_act extends AppCompatActivity {

    private Spinner pokemon;
    private TextView result;
    private RatingBar calificar;
    private Pokemon po = new Pokemon();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilometros);

        pokemon = findViewById(R.id.spnPokemons);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        //Recibo los extras
        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray( "pokemon");

        ArrayAdapter adaptPokemon = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        pokemon.setAdapter(adaptPokemon);
    }

    public void Calcular(View view)
    {
       String opcion = pokemon.getSelectedItem().toString();
       int resultado = 0;

       for(int i = 0; i < opcion.length(); i++)
       {
           if(opcion.equals(po.getPokemon()[i]))
           {
               resultado = po.anadirAdicional(po.getKilometros()[i], 350);
               calificar.setRating(i);
               break;
           }

       }

       result.setText("Su pokemon es:" + opcion + "\nPor recorrer: " + resultado + "KMS" );
    }
}