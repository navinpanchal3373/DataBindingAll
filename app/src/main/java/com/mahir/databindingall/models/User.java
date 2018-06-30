package com.mahir.databindingall.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class User extends BaseObservable {

    private String userName;
    private String userPhone;
    private String profileImage;
    private String about;

    private ObservableField<Long> numberOfFollowers = new ObservableField<>();
    private ObservableField<Long> numberOfPosts = new ObservableField<>();
    private ObservableField<Long> numberOfFollowing = new ObservableField<>();

    @BindingAdapter({"profileImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);

        // If you consider Picasso, follow the below
        // Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.placeholder).into(view);
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bindable
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Bindable
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public ObservableField<Long> getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(ObservableField<Long> numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public ObservableField<Long> getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(ObservableField<Long> numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public ObservableField<Long> getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(ObservableField<Long> numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }
}
