package com.mahir.databindingall;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.mahir.databindingall.adapters.PostAdapter;
import com.mahir.databindingall.databinding.ActivityBindrecycleBinding;
import com.mahir.databindingall.models.Post;
import com.mahir.databindingall.utilities.GridSpacingItemDecoration;

import java.util.ArrayList;

public class RecycleBinding extends AppCompatActivity {

    private PostAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBindrecycleBinding bindrecycleBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_bindrecycle);

        recyclerView = bindrecycleBinding.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        ArrayList<Post> postArrayList = new ArrayList<>();
        postArrayList.addAll(getPosts());
        postArrayList.addAll(getPosts());
        postArrayList.addAll(getPosts());

        mAdapter = new PostAdapter(RecycleBinding.this, postArrayList, new PostAdapter.PostsAdapterListener() {
            @Override
            public void onPostClicked(Post post) {

            }
        });
        recyclerView.setAdapter(mAdapter);

    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Post post = new Post();
            post.setImageUrl("https://api.androidhive.info/images/nature/" + i + ".jpg");
            posts.add(post);
        }
        return posts;
    }
}
