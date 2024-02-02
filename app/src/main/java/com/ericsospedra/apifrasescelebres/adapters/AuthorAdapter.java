package com.ericsospedra.apifrasescelebres.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.apifrasescelebres.R;
import com.ericsospedra.apifrasescelebres.interfaces.IOnClickListener;
import com.ericsospedra.apifrasescelebres.models.Author;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {
    private final List<Author> authors;
    private final IOnClickListener listener;

    public AuthorAdapter(List<Author> authors, IOnClickListener listener) {
        this.authors = authors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AuthorAdapter.AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AuthorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_author,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorAdapter.AuthorViewHolder holder, int position) {
        holder.onBindAuthor(authors.get(position));
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }

    public class AuthorViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivAuthor;
        private final TextView tvName;
        private final TextView tvBirthday;
        private final TextView tvDeath;
        private final TextView tvProfesions;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAuthor = itemView.findViewById(R.id.ivAuthor);
            tvName = itemView.findViewById(R.id.tvName);
            tvBirthday = itemView.findViewById(R.id.tvBirthday);
            tvDeath = itemView.findViewById(R.id.tvDeath);
            tvProfesions = itemView.findViewById(R.id.tvProfesions);
        }

        public void onBindAuthor(Author author) {
            ivAuthor.setImageResource(itemView.getContext().getResources().getIdentifier(author.getName(),"drawable",itemView.getContext().getPackageName()));
            tvName.setText(author.getName());
            tvBirthday.setText(author.getBirthday());
            if(author.getDeath() != null) {
                tvDeath.setText(author.getName());
            }else {
                tvDeath.setText("Vivo");
            }
            tvProfesions.setText(author.getProfesions());
        }
    }
}
