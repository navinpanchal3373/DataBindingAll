package com.mahir.databindingall.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahir.databindingall.R;
import com.mahir.databindingall.databinding.PostRowItemBinding;
import com.mahir.databindingall.models.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyPostHolder> {

    private Context context;
    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostsAdapterListener listener;

    public PostAdapter(Context context, List<Post> postList, PostsAdapterListener listener) {
        this.context = context;
        this.postList = postList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        PostRowItemBinding itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);
        return new MyPostHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPostHolder holder, final int position) {
        holder.binding.setPost(postList.get(position));
        holder.binding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPostClicked(postList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyPostHolder extends RecyclerView.ViewHolder {
        private final PostRowItemBinding binding;

        public MyPostHolder(PostRowItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }

    public interface PostsAdapterListener {
        void onPostClicked(Post post);
    }
}
