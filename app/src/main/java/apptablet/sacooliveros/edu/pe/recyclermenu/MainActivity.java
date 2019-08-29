package apptablet.sacooliveros.edu.pe.recyclermenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerView.Adapter adapter;


    private List<MyList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        list.add(new MyList("Estudio", "Ingles"));
        list.add(new MyList("Seleccion", "Matematica"));
        list.add(new MyList("Ingenieria", "Sofftware"));
        list.add(new MyList("Fisica", "Metalurgia"));

        adapter = new CustomAdapter(list, this);

        ((CustomAdapter) adapter).setOnDiaListener(new onDiaListener() {
            @Override
            public void onFondoClicked(int position) {

                Toast.makeText(MainActivity.this, "fondo Click " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAccionClicked(int position) {
                Toast.makeText(MainActivity.this, "item CLick" + position, Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setAdapter(adapter);

    }
}
