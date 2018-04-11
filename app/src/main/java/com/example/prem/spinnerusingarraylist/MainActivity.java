package com.example.prem.spinnerusingarraylist;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextInputLayout textInputLayout;
    TextInputEditText textEt;
    Spinner spinner;
    Button addBtn;
    ArrayList<String> al = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        textInputLayout = findViewById(R.id.textInputLayout);
        textEt = findViewById(R.id.textEt);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, al);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        al.add(0,"--Select--");




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addBtn:
                addToSpinner();
                break;
        }
    }

    private void addToSpinner() {
        String text = textInputLayout.getEditText().getText().toString().trim();
        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        al.add(text);
        adapter.notifyDataSetChanged();
        textEt.setText("");


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position>0){
            Toast.makeText(this, parent.getItemAtPosition(position).toString()+" is clicked", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
