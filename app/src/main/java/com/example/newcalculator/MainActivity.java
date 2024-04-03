package com.example.newcalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbarMain;

    EditText firstNumberET;
    EditText secondNumberET;

    Button plusBTN;
    Button minBTN;
    Button multiplyBTN;
    Button divideBTN;

    TextView resultTV;

    String title = "Calculate";
    String subtitle = "Version 1.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        onButtonsClick();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.resetMenuMain:
                firstNumberET.getText().clear();
                secondNumberET.getText().clear();
                resultTV.setText("Результат");
                Toast.makeText(this, "Данные удалены", Toast.LENGTH_LONG).show();
                break;
            case R.id.exitMenuMain:
                finish();
                Toast.makeText(this, "Работа приложения завершена", Toast.LENGTH_LONG).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void initUI() {
        toolbarMain = findViewById(R.id.toolBarMain);

        firstNumberET = findViewById(R.id.firstNumberET);
        secondNumberET = findViewById(R.id.secondNumberET);

        plusBTN = findViewById(R.id.plusBTN);
        minBTN = findViewById(R.id.minBTN);
        multiplyBTN = findViewById(R.id.multiplyBTN);
        divideBTN = findViewById(R.id.divideBTN);


        resultTV = findViewById(R.id.resultTV);

        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setSubtitle(subtitle);
        getSupportActionBar().setLogo(R.drawable.ic_calculate);
    }

    private void onButtonsClick() {
        plusBTN.setOnClickListener(this);
        minBTN.setOnClickListener(this);
        multiplyBTN.setOnClickListener(this);
        divideBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (firstNumberET.getText().toString().isEmpty() ||
        secondNumberET.getText().toString().isEmpty()){
            return;
        }

        boolean check = true;

        double result = 0;

        double firstNumber = Double.parseDouble(firstNumberET.getText().toString());
        double secondNumber = Double.parseDouble(secondNumberET.getText().toString());

        Operations operations = new Operations(firstNumber, secondNumber);

        switch (v.getId()){
            case R.id.plusBTN:
                result = operations.sum();
                break;
            case R.id.minBTN:
                result = operations.min();
                break;
            case R.id.multiplyBTN:
                result = operations.multiply();
                break;
            case R.id.divideBTN:
                result = operations.divide();
                break;
        }

        if (!check){
            resultTV.setText("0.000");
        } else {
            resultTV.setText(String.valueOf(result));
        }

    }
}