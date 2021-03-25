package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tribe.invoke.IntentInvoker;

public class EcoListItemActivity extends AppCompatActivity {
    ImageView mainImage;
    TextView titleText, problemText, solutionText, recText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_list_item);

        mainImage = (ImageView) findViewById(R.id.mainImage);
        titleText = (TextView) findViewById(R.id.titleText);
        problemText = (TextView) findViewById(R.id.problemText);
        solutionText = (TextView) findViewById(R.id.solutionText);
        recText = (TextView) findViewById(R.id.recText);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            String name = arguments.getString("name");
            int flagRes = arguments.getInt("flagRes");
            String problem = arguments.getString("problem");
            String solution = arguments.getString("solution");
            String rec = arguments.getString("rec");

            mainImage.setImageResource(flagRes);
            titleText.setText(name);
            SpannableStringBuilder spannableProblem = new SpannableStringBuilder("Проблема: " + problem);
            spannableProblem.setSpan(
                    new ForegroundColorSpan(getResources().getColor(R.color.dark_yellow)),
                    0,
                    8,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            );
            problemText.setText(spannableProblem);
            SpannableStringBuilder spannableSolution = new SpannableStringBuilder("Вирішення: " + solution);
            spannableSolution.setSpan(
                    new ForegroundColorSpan(getResources().getColor(R.color.dark_green)),
                    0,
                    9,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            );
            solutionText.setText(spannableSolution);
            SpannableStringBuilder spannableRec = new SpannableStringBuilder("Рекомендації: \n" + rec);
            spannableRec.setSpan(
                    new ForegroundColorSpan(getResources().getColor(R.color.dark_blue)),
                    0,
                    12,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            );
            recText.setText(spannableRec);
        }
    }

    public void getBack(View view) {
        IntentInvoker invoker = new IntentInvoker(this, EcoActivity.class);
        invoker.invokeAndClean();
    }
}