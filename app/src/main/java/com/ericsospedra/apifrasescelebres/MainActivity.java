package com.ericsospedra.apifrasescelebres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.ericsospedra.apifrasescelebres.fragments.AuthorFragment;
import com.ericsospedra.apifrasescelebres.fragments.CategoryFragment;
import com.ericsospedra.apifrasescelebres.fragments.SentenceFragment;
import com.ericsospedra.apifrasescelebres.fragments.StartMenuFragment;
import com.ericsospedra.apifrasescelebres.interfaces.IApiService;
import com.ericsospedra.apifrasescelebres.interfaces.IOnClickListener;
import com.ericsospedra.apifrasescelebres.models.ApiConsumer;
import com.ericsospedra.apifrasescelebres.models.Author;
import com.ericsospedra.apifrasescelebres.models.StartMenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements StartMenuFragment.IOnAttach, IOnClickListener {

    private enum START_MENU_ITEM {Autores,Categorias,Frases}
    private FragmentManager manager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        toolbar = findViewById(R.id.tbMenu);
        toolbar.setTitle("Frases Celebres");
        IApiService api = ApiConsumer.getInstance();
        api.getAllAuthor().enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                List<Author> authors = response.body();
                for (Author author : authors){
                    Log.d(MainActivity.class.getSimpleName(),author.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(),t.getMessage());
            }
        });
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
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, AuthorFragment.class,null).commit();
        }else if (s.equals(START_MENU_ITEM.Categorias.toString())){
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, CategoryFragment.class,null).commit();
        }else {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, SentenceFragment.class,null).commit();
        }
    }
}