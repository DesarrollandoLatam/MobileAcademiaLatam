package com.desarrollandolatam.nbortolotti.mobileacademialatam;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;


public class MainActivity extends Activity {

    private ImageButton buttonMostrar;
    private ImageButton buttonMostrarJirafa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        //referencias de los controles iniciales
        buttonMostrar = (ImageButton)findViewById(R.id.buttonMostrar);

        //accion para el boton principal
        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(new Explode());

                //Creamos el intent
                Intent inMostrar = new Intent(MainActivity.this, mostrarInformacion.class);

                //pasar informacion entreactividades
                Bundle b = new Bundle();
                b.putString("nombre", "Tigre");

                inMostrar.putExtras(b);

                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this);

                startActivity(inMostrar, options.toBundle());


            }
        });


        //referencias de los controles iniciales
        buttonMostrarJirafa = (ImageButton)findViewById(R.id.buttonMostrarJirafa);

        //accion para el boton principal
        buttonMostrarJirafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(new Explode());

                //Creamos el intent
                Intent inMostrar = new Intent(MainActivity.this, mostrarInformacion.class);

                //pasar informacion entreactividades
                Bundle b = new Bundle();
                b.putString("nombre", "Jirafa");

                inMostrar.putExtras(b);

                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this);

                startActivity(inMostrar, options.toBundle());


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
