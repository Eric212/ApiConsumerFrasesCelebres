package com.ericsospedra.apifrasescelebres.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.apifrasescelebres.MainActivity;
import com.ericsospedra.apifrasescelebres.R;
import com.ericsospedra.apifrasescelebres.interfaces.IApiService;
import com.ericsospedra.apifrasescelebres.interfaces.IOnClickListener;
import com.ericsospedra.apifrasescelebres.models.ApiConsumer;
import com.ericsospedra.apifrasescelebres.models.Author;
import com.ericsospedra.apifrasescelebres.adapters.AuthorAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorFragment extends Fragment {

    private List<Author> authors;

    private IOnClickListener listener;
    private IApiService api;

    public AuthorFragment() {
        super(R.layout.author_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api.getAllAuthor().enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                if(response.isSuccessful()) {
                    authors = response.body();
                    Log.d(MainActivity.class.getSimpleName(),authors.get(0).toString());
                    RecyclerView rvAuthor = view.findViewById(R.id.rvAuthor);
                    AuthorAdapter adapter = new AuthorAdapter(authors, listener);
                    rvAuthor.setAdapter(adapter);
                    rvAuthor.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
                }
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {
                Log.e(AuthorFragment.class.getSimpleName(),t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        api = ApiConsumer.getInstance();
        listener = (IOnClickListener) context;
    }
}
