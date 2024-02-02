package com.ericsospedra.apifrasescelebres.interfaces;

import com.ericsospedra.apifrasescelebres.models.Author;
import com.ericsospedra.apifrasescelebres.models.Category;
import com.ericsospedra.apifrasescelebres.models.Sentence;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApiService {
    @GET("autor/all")
    public Call<List<Author>> getAllAuthor();

    @GET("autor/all/{page}")
    public Call<List<Author>> getAuthorByPages(@Path("page") int page);

    @GET("autor/{id}")
    public Call<Author> getAuthorById(@Path("id") int id);

    @GET("categoria/all")
    public Call<List<Category>> getAllCategories();

    @GET("categoria/all/{page}")
    public Call<List<Category>> getCategoriesByPages(@Path("page") int page);

    @GET("categoria/{id}")
    public Call<Category> getCategoryById(@Path("id") int id);

    @GET("frase/all")
    public Call<List<Sentence>> getAllSentences();

    @GET("frase/all/{page}")
    public Call<List<Sentence>> getAllSentencesByPage(@Path("page") int page);

    @GET("frase/{id}}")
    public Call<Sentence> getSetenceById(@Path("id") int id);

    @GET("frase/categoria/{id}")
    public Call<List<Sentence>> getSentencesByCategory(@Path("id") int id);

    @GET("frase/author/{id}")
    public Call<List<Sentence>> getSentencesByAuthor(@Path("id") int id);

    @GET("frase/dia/{date}")
    public Call<Sentence> getSentenceByDate(@Path("date") String date);
}
