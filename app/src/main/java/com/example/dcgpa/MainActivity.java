package com.example.dcgpa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Spinner spinner;
    private EditText f1,f2,f3,f4,f5,f6,f7,f8;
    private TextView show;
    private Button btnw;
    int[]array = {2016,2010};

    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.item,android.R.layout.simple_expandable_list_item_1);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        AlertDialog.Builder builder = alertDialogBuilder;
        builder.setMessage("Do you want exit ?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();
    }


    public void calculate(View view) {

        int sp = spinner.getSelectedItemPosition();

        if(f1.length() == 0 ) {
            f1.setError("not been filled");
        }
            else if( f2.length() == 0){
            f2.setError("not been filled");
            }
        else if( f3.length() == 0){
            f3.setError("not been filled");
        }
        else if( f4.length() == 0){
            f4.setError("not been filled");
        }
        else if( f5.length() == 0){
            f5.setError("not been filled");
        }
        else if( f6.length() == 0){
            f6.setError("not been filled");
        }
        else if( f7.length() == 0){
            f7.setError("not been filled");
        }
        else if( f8.length() == 0){
            f8.setError("not been filled");
        }

        else {

            double first = Double.parseDouble(f1.getText().toString());
            double second = Double.parseDouble(f2.getText().toString());
            double third = Double.parseDouble(f3.getText().toString());
            double four = Double.parseDouble(f4.getText().toString());
            double five = Double.parseDouble(f5.getText().toString());
            double six = Double.parseDouble(f6.getText().toString());
            double seven = Double.parseDouble(f7.getText().toString());
            double eight = Double.parseDouble(f8.getText().toString());


            if (sp == 0) {
                double total = ((first * 5) / 100) + ((second * 5) / 100) + ((third * 7.5) / 100)
                        + ((four * 7.5) / 100) + ((five * 15) / 100)
                        + ((six * 20) / 100) + ((seven * 25) / 100)
                        + ((eight * 15) / 100);

                show.setText(df.format(total));
            } else if (sp == 1) {
                double total = ((first * 5) / 100) + ((second * 5) / 100) + ((third * 5) / 100)
                        + ((four * 15) / 100) + ((five * 15) / 100)
                        + ((six * 20) / 100) + ((seven * 25) / 100)
                        + ((eight * 10) / 100);
                show.setText(df.format(total));
            }

        }
    }

    public void reset(View view) {
        f1.setText("");
        f2.setText("");
        f3.setText("");
        f4.setText("");
        f5.setText("");
        f6.setText("");
        f7.setText("");
        f8.setText("");
        show.setText("0.0");
        f1.requestFocus();
    }

    public void findId(){

        spinner = findViewById(R.id.spinner);
        btnw = findViewById(R.id.btn);
        f1 = findViewById(R.id.first);
        f2 = findViewById(R.id.second);
        f3 = findViewById(R.id.third);
        f4 = findViewById(R.id.four);
        f5 = findViewById(R.id.five);
        f6 = findViewById(R.id.six);
        f7 = findViewById(R.id.seven);
        f8 = findViewById(R.id.finals);
        show = findViewById(R.id.showTV);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
