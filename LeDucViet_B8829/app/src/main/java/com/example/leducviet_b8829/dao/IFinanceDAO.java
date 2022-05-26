package com.example.leducviet_b8829.dao;

import com.example.leducviet_b8829.entity.Finance;

import java.util.List;

public interface IFinanceDAO {
    public List<Finance> select();

    public Finance selectById(int id);

    public boolean insert(Finance c);

    public boolean delete(int id);
}
