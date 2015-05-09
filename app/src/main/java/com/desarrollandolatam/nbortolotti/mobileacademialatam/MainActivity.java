package com.desarrollandolatam.nbortolotti.mobileacademialatam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText textNombre;
    private Button buttonMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias de los controles iniciales
        textNombre = (EditText)findViewById(R.id.textNombre);
        buttonMostrar = (Button)findViewById(R.id.buttonMostrar);

        //accion para el boton principal
        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creamos el intent
                Intent inMostrar = new Intent(MainActivity.this, mostrarInformacion.class);

                //pasar informacion entreactividades
                Bundle b = new Bundle();
                b.putString("nombre", textNombre.getText().toString());

                inMostrar.putExtras(b);

                startActivity(inMostrar);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
