package com.ifsc.listview;

import android.content.Intent; // Importando corretamente a classe Intent
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] nomes = new String[]{"Pera", "Uva", "Maça", "Goiaba", "Morango", "Melão"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.ListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ActivityB.class);
                Bundle b = new Bundle();
                b.putInt("posicao", position);
                b.putString("fruta", nomes[position]);

                i.putExtras(b); // Passando os dados para a próxima Activity
                startActivity(i); // Inicia a ActivityB
            }
        });
    }
}
