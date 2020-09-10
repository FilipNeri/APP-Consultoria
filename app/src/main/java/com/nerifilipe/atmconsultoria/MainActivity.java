package com.nerifilipe.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //botao para enviar email
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               enviarEmail();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.menu_principal,
                R.id.menu_servicos,
                R.id.menu_cliente,
                R.id.menu_contato,
                R.id.menu_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

//  MENU DO TOOLBAR
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    public void enviarEmail(){
        String telefone ="tel:048985031830";
        String imagem ="https://www.google.com/search?q=zoro&sxsrf=ALeKk00ky9JepOjAL915DxOQD4RhFYmwaw:1594825320761&source=lnms&tbm=isch&sa=X&ved=2ahUKEwi57OOlw8_qAhWkF7kGHcOUCEIQ_AUoAXoECBgQAw&biw=1600&bih=702#imgrc=aTotKuWCkdsxSM&imgdii=awdw-JWzc_n8tM";
        String endereco ="https://www.google.com/maps/place/Stage+Music+Park/@-27.476018,-48.489733,15z/data=!4m5!3m4!1s0x0:0x50edb0618a87281f!8m2!3d-27.476018!4d-48.489733";

//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(telefone));
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);//compartilhar
        intent.putExtra(intent.EXTRA_EMAIL, new String[] {"atendimento@atmconsultoria.com.br"});
        intent.putExtra(intent.EXTRA_SUBJECT, "Contato pelo APP");
        intent.putExtra(intent.EXTRA_TEXT,"mensagem automatica");

//        intent.setType("mensage/rfc822");//tipo de dado a ser compartilhado
//        intent.setType("text/plan");//tipo de dado a ser compartilhado
        intent.setType("image/*");//tipo de dado a ser compartilhado



        startActivity(intent.createChooser(intent,"Compartilhar"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
