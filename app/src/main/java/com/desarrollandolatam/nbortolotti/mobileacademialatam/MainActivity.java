package com.desarrollandolatam.nbortolotti.mobileacademialatam;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.ui.auth.core.AuthProviderType;
import com.firebase.ui.auth.core.FirebaseLoginBaseActivity;
import com.firebase.ui.auth.core.FirebaseLoginError;


public class MainActivity extends FirebaseLoginBaseActivity {

    private Firebase mFirebaseRef;

    private ImageButton buttonMostrar;
    private ImageButton buttonMostrarJirafa;
    private ImageButton buttonMostrarPanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_main);

        mFirebaseRef = new Firebase("https://androidlevel1.firebaseio.com/");

        Button loginButton = (Button) this.findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFirebaseLoginPrompt();
            }
        });

        //referencias de los controles iniciales
        buttonMostrar = (ImageButton)findViewById(R.id.buttonMostrar);

        //accion para el boton principal
        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getWindow().setExitTransition(new Explode());

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
                //getWindow().setExitTransition(new Explode());

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


        //Panda en Vivo
        //referencias de los controles iniciales
        buttonMostrarPanda = (ImageButton)findViewById(R.id.buttonMostrarPanda);

        //accion para el boton principal
        buttonMostrarPanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getWindow().setExitTransition(new Explode());

                //Creamos el intent
                Intent inMostrar = new Intent(MainActivity.this, mostrarInformacion.class);

                //pasar informacion entreactividades
                Bundle b = new Bundle();
                b.putString("nombre", "Panda");

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
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setEnabledAuthProvider(AuthProviderType.PASSWORD);
    }

    @Override
    protected void onFirebaseLoggedIn(AuthData authData) {
        Context context = getApplicationContext();
        CharSequence text = "Autenticado!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected Firebase getFirebaseRef() {
        return mFirebaseRef;
    }

    @Override
    protected void onFirebaseLoginProviderError(FirebaseLoginError firebaseLoginError) {

    }

    @Override
    protected void onFirebaseLoginUserError(FirebaseLoginError firebaseLoginError) {
        Context context = getApplicationContext();
        CharSequence text = "Error de autenticacion";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
