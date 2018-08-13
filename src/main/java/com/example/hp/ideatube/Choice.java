package com.example.hp.ideatube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class Choice extends AppCompatActivity
{
    Button btnSales, btnSd, btnA;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        btnSd=(Button)findViewById(R.id.btnSd);
        btnSales=(Button)findViewById(R.id.btnSales);
        btnA=(Button)findViewById(R.id.btnAll);
    }
    public void onClick(View view)
    {
        Intent sdIntent= new Intent(getApplicationContext(), Sd.class);
        startActivity(sdIntent);
    }

    public void onClickSales(View view)
    {
        Intent salesIntent= new Intent(Choice.this, Sales.class);
        Choice.this.startActivity(salesIntent);
    }
    public void onAll(View view)
    {
        Intent allIntent= new Intent(getApplicationContext(), All.class);
        startActivity(allIntent);
    }
}
