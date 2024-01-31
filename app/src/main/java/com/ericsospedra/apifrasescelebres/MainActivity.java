package com.ericsospedra.apifrasescelebres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ericsospedra.apifrasescelebres.fragments.StartMenuFragment;
import com.ericsospedra.apifrasescelebres.interfaces.IOnClickListener;
import com.ericsospedra.apifrasescelebres.models.StartMenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StartMenuFragment.IOnAttach, IOnClickListener {

    private enum START_MENU_ITEM {Autores,Categorias,Frases}
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
    }

    @Override
    public List<StartMenuItem> getList() {
        List<StartMenuItem> startMenuItemList = new ArrayList<>();
        for(START_MENU_ITEM item : START_MENU_ITEM.values()){
            StartMenuItem startMenuItem = new StartMenuItem(item.toString().toLowerCase(),item.toString());
            startMenuItemList.add(startMenuItem);
        }
        return startMenuItemList;
    }
    @Override
    public void onClick(String s) {
        if(s.equals(START_MENU_ITEM.Autores.toString())){

        }
    }
}