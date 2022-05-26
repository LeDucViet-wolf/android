package com.example.leducviet_b8829.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leducviet_b8829.MainActivity;
import com.example.leducviet_b8829.R;
import com.example.leducviet_b8829.dao.FinanceManagement;
import com.example.leducviet_b8829.dao.IFinanceDAO;
import com.example.leducviet_b8829.entity.Finance;

import java.util.List;

public class AdapterFinance extends ArrayAdapter<Finance> {
    private final Context mCtx;
    private final List<Finance> mList;

    public AdapterFinance(@androidx.annotation.NonNull Context context, @androidx.annotation.NonNull List<Finance> objects) {
        super(context, R.layout.item_finance, objects);
        this.mCtx = context;
        this.mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @androidx.annotation.Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(this.mCtx).inflate(R.layout.item_finance, null);
        }
        Finance f = mList.get(position);
        TextView txtName = v.findViewById(R.id.itemName);
        TextView txtMoney = v.findViewById(R.id.itemMoney);
        ImageView btnDelete = v.findViewById(R.id.itemBtnDelete);

        txtName.setText(f.getName());
        txtMoney.setText(f.getMoney().toString());

        btnDelete.setOnClickListener(view -> {
            IFinanceDAO iFinanceDAO = new FinanceManagement(mCtx);
            boolean result = iFinanceDAO.delete(f.getId());
            if (result) {
                Toast.makeText(mCtx, "Delete Succesfully", Toast.LENGTH_SHORT).show();
                AdapterFinance.this.notifyDataSetChanged();

                // go to main activity
                Intent intent = new Intent(mCtx, MainActivity.class);
                mCtx.startActivity(intent);
            } else Toast.makeText(mCtx, "Delete Error", Toast.LENGTH_SHORT).show();
        });

        return v;
    }
}
