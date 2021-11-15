package com.example.proyectobase_felipepalaciosstgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Pokemon;

public class MainActivity extends AppCompatActivity {

    private EditText user,pass;
    private TextView msj;
    private Button btn;
    private ProgressBar barra;

    private Administrador adm = new Administrador();
    private Pokemon po = new Pokemon();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        msj = findViewById(R.id.msj);
        btn = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                for (int i = 0; i<= 10; i++)
                {
                    Thread.sleep(500);
                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.VISIBLE);

            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario)
            {
                case"Felipe":
                    if(usuario.equals(userObj) && contrasena.equals(passObj))
                    {
                        //Inicio Sesion
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;
                case"":
                    if(usuario.equals("") && contrasena.equals(""))
                    {
                        //Campos Vacios
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Los campos estan vacios intente nuevamente");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        //Campos son incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos incorrectos intente nuevamente");
                    }
                    break;
            }
        }
    }

    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https:/www.facebook.com/"));
        startActivity(i);
    }

    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https:/www.twitter.com/"));
        startActivity(i);
    }

    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https:/www.youtube.com/"));
        startActivity(i);
    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }


}