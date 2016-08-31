package com.example.adriana.colores;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    Button btn;
    Spinner spn;
    TableLayout lyt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        cargaDatos();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_Click(v);
            }
        });
    }

    private void inicializaComponentes(){
        btn= (Button) findViewById(R.id.button);
        spn=(Spinner) findViewById(R.id.spinner);
        lyt= (TableLayout) findViewById(R.id.Lay1);
    }

    private void cargaDatos(){
        String [] colores= new String []{
                "rojo",
                "verde",
                "azul",
                "amarillo"
        };
        ArrayList<String> lista= new ArrayList<String>();
        for (String s: colores){
            lista.add(s);
        }
        ArrayAdapter adp= new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, lista);
        spn.setAdapter(adp);
    }

    private void btn_Click(View sender){
        String colorSel=this.spn.getSelectedItem().toString();
        int color=0;
        if(colorSel.equals("rojo"))
            lyt.setBackgroundColor(Color.parseColor("#CB1313"));
        else if(colorSel.equals("verde"))
            lyt.setBackgroundColor(Color.parseColor("#38CB13"));
        else if(colorSel.equals("azul"))
            lyt.setBackgroundColor(Color.parseColor("#13A0CB"));
        else if(colorSel.equals("amarillo"))
            lyt.setBackgroundColor(Color.parseColor("#EAE439"));
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
