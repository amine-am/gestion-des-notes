package com.example.devoirlibre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String module;
    Double note;
    EditText noteInput;
    Button ajouterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> modules = Arrays.asList("Informatique", "Français", "Physique", "Histoire", "Anglais");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, modules);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ListView BulletinList = (ListView) findViewById(R.id.resultatList);
        ArrayList<Bulletin> resultatList = new ArrayList<>();

        BulletinListAdapter adapter1 = new BulletinListAdapter(this, R.layout.list_layout, resultatList);
        BulletinList.setAdapter(adapter1);
        ArrayList<String> bulletinModules = new ArrayList<String>();
        ArrayList<Double> bulletinNotes = new ArrayList<Double>();

        noteInput = (EditText) findViewById(R.id.noteInput);
        ajouterButton = (Button) findViewById(R.id.ajouterButton);
        ajouterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module = spinner.getSelectedItem().toString();
                note = Double.valueOf(noteInput.getText().toString());
                if (note<0 && note>20) {
                    String noteToast = "La note doit être entre 0 et 20";
                    showToast(noteToast);
                }else{
                    Bulletin result = new Bulletin(module, note);
                    String gotModule = result.getModule();
                    if (bulletinModules.contains(gotModule)){
                        String moduleToast = "Module existe deja!";
                        showToast(moduleToast);
                    }else{
                        resultatList.add(result);
                        bulletinModules.add(gotModule);
                        bulletinNotes.add(note);
                        String creationToast ="Résultat ajouté!";
                        showToast(creationToast);

                        if (resultatList.size() == modules.size()) {
                            double sum = 0;
                            for(int i = 0; i < modules.size(); i++)
                                sum += bulletinNotes.get(i);
                            Double moyenne = sum/5;
                            ((TextView)findViewById(R.id.moyenne)).setText(String.valueOf(moyenne));
                        }
                    }
                }
            }
        });

    }

    private void showToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    private void moyenneCalcule(int size, Bulletin resultatList){

    }
}