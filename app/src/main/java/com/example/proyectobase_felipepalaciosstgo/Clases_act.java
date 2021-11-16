package com.example.proyectobase_felipepalaciosstgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobase_felipepalaciosstgo.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {

    private EditText code, clas, intens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.code);
        clas = findViewById(R.id.clas);
        intens = findViewById(R.id.intens);
    }

    public void guardarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "FITGO", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intens.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty()) {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.insert("clases", null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has Guardado una clase", Toast.LENGTH_SHORT).show();

        } else{

            Toast.makeText(getBaseContext(), "Tiene campos vacios porfavor rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "FITGO", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor file =
                    db.rawQuery("SELECT clase, intensidad FROM clases WHERE codigo=" + codigo, null);

            if(file.moveToFirst())
            {
                clas.setText(file.getString(0));
                intens.setText(file.getString(1));


            }else{
                Toast.makeText(getBaseContext(), "No hay clase asociada", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getBaseContext(), "El codigo esta vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "FITGO", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            db.delete("clases", "codigo"+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has eliminado la clase: "+ codigo, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(), "El codigo no debe venir vacio", Toast.LENGTH_SHORT).show();
        }

    }

    public void actualizarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "FITGO", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intens.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.update("clases", cont, "codigo"+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has Actualizado la clase", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(), "Campos vacios porfavor rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    public void Clean()
    {
        code.setText("");
        clas.setText("");
        intens.setText("");

    }
}