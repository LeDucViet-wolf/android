package com.example.leducviet_b8829;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leducviet_b8829.dao.FinanceManagement;
import com.example.leducviet_b8829.dao.IFinanceDAO;
import com.example.leducviet_b8829.entity.Finance;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        Button button = findViewById(R.id.btnAddNew);
        button.setOnClickListener(view -> {
            EditText edtName = (EditText) findViewById(R.id.edtName);
            EditText edtMoney = (EditText) findViewById(R.id.edtMoney);

            String name = edtName.getText().toString();
            String money = edtMoney.getText().toString();

            Finance finance = new Finance(name, Double.parseDouble(money));
            IFinanceDAO iFinanceDAO = new FinanceManagement(AddNewActivity.this);
            boolean result = iFinanceDAO.insert(finance);
            if (result) {
                Toast.makeText(AddNewActivity.this, "Add new successfully", Toast.LENGTH_SHORT).show();

                // go to main activity
                Intent intent = new Intent(AddNewActivity.this, MainActivity.class);
                startActivity(intent);
            } else
                Toast.makeText(AddNewActivity.this, "Add new error", Toast.LENGTH_SHORT).show();
        });
    }
}