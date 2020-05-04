package com.ricardohg.ejercicioopcional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Clase principal
// Se implementó el método de ordenamiento quick sort en su propia clase: "QuickSort", capaz
// de ordenar ArrayList de Integer. Los resultados se muestran dentro de la misma actividad,
// gracias a un par de RecyclerViews.
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // UI variables:
    EditText etNumber;
    Button btnAdd, btnOrder;

    RecyclerView rvOriginalNumbers;
    AdapterListItem rvOriginalNumbersAdapter;
    RecyclerView rvOrderedNumbers;
    AdapterListItem rvOrderedNumbersAdapter;

    // General variables:
    ArrayList<Integer> numberList = new ArrayList<Integer>();
    ArrayList<Integer> orderedNumberList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test Data
        /*
        numberList.add(5);
        numberList.add(4);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);
        */

        // Find UI
        // Text entries:
        etNumber = findViewById(R.id.etNumber);

        // Text Views:
        rvOriginalNumbers = findViewById(R.id.rvOriginalNumbers);
        rvOriginalNumbers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rvOrderedNumbers = findViewById(R.id.rvOrderedNumbers);
        rvOrderedNumbers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Buttons:
        btnAdd = findViewById(R.id.btnAdd);
        btnOrder = findViewById(R.id.btnOrder);

        // Recycle View Adapters:
        rvOriginalNumbersAdapter = new AdapterListItem(numberList);

        rvOriginalNumbers.setAdapter(rvOriginalNumbersAdapter);

        rvOrderedNumbersAdapter = new AdapterListItem(orderedNumberList);

        rvOrderedNumbers.setAdapter(rvOrderedNumbersAdapter);

        btnAdd.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAdd:
                try {
                    Integer newNumber = Integer.parseInt(etNumber.getText().toString());
                    if(!validateEntry(newNumber)){
                        throw new Exception();
                    }
                    numberList.add(newNumber);
                    rvOriginalNumbersAdapter = new AdapterListItem(numberList);

                    rvOriginalNumbers.setAdapter(rvOriginalNumbersAdapter);

                    // Clear text entry:
                    etNumber.getText().clear();
                } catch (Exception e) {
                    Toast.makeText(this, R.string.entry_error, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
            case R.id.btnOrder:
                orderedNumberList = (ArrayList<Integer>)numberList.clone();
                QuickSort.sortArrayList(orderedNumberList);
                rvOrderedNumbersAdapter = new AdapterListItem(orderedNumberList);

                rvOrderedNumbers.setAdapter(rvOrderedNumbersAdapter);
                break;
        }
    }

    public Boolean validateEntry(Integer entry){
        if(String.valueOf(entry).length() > 4){
            return false;
        }
        return true;
    }
}
