package com.example.leducviet_b8829;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.leducviet_b8829.adapter.AdapterFinance;
import com.example.leducviet_b8829.dao.FinanceManagement;
import com.example.leducviet_b8829.dao.IFinanceDAO;
import com.example.leducviet_b8829.databinding.ActivityMainBinding;
import com.example.leducviet_b8829.entity.Finance;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> lst;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadContact();
    }

    private void loadContact() {
        IContactDAO contactDAO = new ContactDAOImpl(this);
        lst = contactDAO.select();

        AdapterContact adapterContact = new AdapterContact(this, lst);
        binding.listContact.setAdapter(adapterContact);

        binding.listContact.setOnItemClickListener((adapterView, view, pos, l) -> {
            Intent intent = new Intent(MainActivity.this, UpdateContactActivity.class);
            int idB = lst.get(pos).getId();
            intent.putExtra("idb", idB);
            startActivity(intent);
        });

        registerForContextMenu(binding.listContact);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadContact();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuAdd:
                Intent intent = new Intent(this, AddNewActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}