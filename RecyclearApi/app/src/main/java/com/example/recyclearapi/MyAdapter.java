package com.example.recyclearapi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
      private List<Articll> mDataset =  new ArrayList<>();
      private   OnArticlClickListener onArticlClickListener;
      private   OnUserClickListener onUserClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        ImageView imageUser;
        ImageView imageArticle;
        TextView userName;
        TextView gitHubName;
        TextView descriptionText;
        TextView title;
        TextView comentsCount;
        TextView positive_reaction_count;
        Context context;
        RequestOptions options = new RequestOptions();


        public MyViewHolder(View v) {
            super(v);
            view = v;
            context = view.getContext();
            imageUser = view.findViewById(R.id.imageUser);
            imageArticle = view.findViewById(R.id.imageArticle);
            userName = view.findViewById(R.id.userName);
            gitHubName = view.findViewById(R.id.git_hub_name);
            descriptionText = view.findViewById(R.id.description);
            title = view.findViewById(R.id.title);
            comentsCount = view.findViewById(R.id.coments_count);
            positive_reaction_count = view.findViewById(R.id.positive_reaction_count);

            view.findViewById(R.id.constaint_bot).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        String link;
                        link = mDataset.get(getLayoutPosition()).getCanonicalUrl();
                        onArticlClickListener.onAticleClick(link);
                }
            });

            view.findViewById(R.id.constaint_top).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String username = mDataset.get(getLayoutPosition()).getUser().getUsername();
                    if(username != null) {
                        onUserClickListener.onUserClick(username);
                    }
                }
            });
        }


        public void bind(Articll article){
            options.centerCrop();
            options.placeholder(new ColorDrawable(Color.LTGRAY));
            Glide
                    .with(context)
                    .load(article.getUser().getProfileImage())
                    .apply(options)
                    .into(imageUser);
            Glide
                    .with(context)
                    .load(article.getCoverImage())
                    .apply(options)
                    .into(imageArticle);
            userName.setText(article.getUser().getName());
            gitHubName.setText(article.getUser().getGithubUsername());
            descriptionText.setText(article.getDescription());
            title.setText(article.getTitle());
            comentsCount.setText(article.getCommentsCount().toString());
            positive_reaction_count.setText(article.getPositiveReactionsCount().toString());
        }
    }



    public MyAdapter(List<Articll> myDataset, OnArticlClickListener onArticlClickListener,
                     OnUserClickListener onUserClickListener) {
        mDataset = myDataset;
        this.onArticlClickListener = onArticlClickListener;
        this.onUserClickListener = onUserClickListener;
    }



    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

      View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_for_recycle_view, parent, false);

       MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mDataset.get(position));
        System.out.println("=========== " + position );

    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    interface  OnArticlClickListener{
        public void onAticleClick(String link);
    }

    interface  OnUserClickListener{
        public void onUserClick(String link);
    }
}
