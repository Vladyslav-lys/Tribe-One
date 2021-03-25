package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tribe.adapters.EcoAdapter;
import com.example.tribe.entities.Eco;
import com.example.tribe.invoke.IntentInvoker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EcoActivity extends AppCompatActivity {

    ArrayList<Eco> ecos = new ArrayList();
    ListView ecoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco);

        setInitialData();
        ecoList = (ListView) findViewById(R.id.ecoList);

        EcoAdapter ecoAdapter = new EcoAdapter(this, R.layout.eco_list_item, ecos);
        ecoList.setAdapter(ecoAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Eco eco = (Eco) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), EcoListItemActivity.class);
                intent.putExtra("name", eco.getName());
                intent.putExtra("flagRes", eco.getFlagRes());
                intent.putExtra("problem", eco.getProblem());
                intent.putExtra("solution", eco.getSolution());
                intent.putExtra("rec", eco.getRecommendation());
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        };
        ecoList.setOnItemClickListener(itemClickListener);
    }

    private void setInitialData(){
        String[] ecoNames = getResources().getStringArray(R.array.eco_name);
        String[] ecoDescribes = getResources().getStringArray(R.array.eco_describe);
        String[] ecoProblems = getResources().getStringArray(R.array.eco_problem);
        String[] ecoSolutions = getResources().getStringArray(R.array.eco_solution);
        String[] ecoRecomendations = getResources().getStringArray(R.array.eco_rec);
        String[] ecoDates = getResources().getStringArray(R.array.eco_date);
        TypedArray ecoPictures = getResources().obtainTypedArray(R.array.eco_images);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date();

        try{
            for(int i=0; i<ecoNames.length; i++) {
                if(curDate.after(formatter.parse(ecoDates[i])) || curDate.equals(formatter.parse(ecoDates[i])))
                    ecos.add(new Eco(ecoNames[i], ecoDescribes[i], ecoPictures.getResourceId(i,0),
                            ecoProblems[i], ecoSolutions[i], ecoRecomendations[i]));
            }
        } catch (ParseException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
        }

    }

    public void goToMain(View view) {
        IntentInvoker invoker = new IntentInvoker(this, MainActivity.class);
        invoker.invokeAndClean();
    }
}