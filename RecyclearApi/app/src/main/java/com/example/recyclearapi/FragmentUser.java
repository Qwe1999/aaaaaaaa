package com.example.recyclearapi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentUser.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUser extends Fragment {

    private ImageView imageUser;
    private TextView userName;
    private TextView userUrl;
    private TextView followingCount;
    private TextView followersCount;
    final static String keyUserName = "KEY_USER_NAME";
    private OnFragmentInteractionListener mListener;

    public FragmentUser() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentUser newInstance(String param1, String param2) {
        FragmentUser fragment = new FragmentUser();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageUser = getActivity().findViewById(R.id.image_user_page);
        userName = getActivity().findViewById(R.id.user_name_page);
        userUrl = getActivity().findViewById(R.id.web_site_url);
        followersCount = getActivity().findViewById(R.id.followers_count);
        followingCount = getActivity().findViewById(R.id.following_count);

        String username = getArguments().getString(keyUserName);
        NetworkService.getInstance().getJSONApi()
                .getPostWithUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                RequestOptions options = new RequestOptions();
                options.placeholder(new ColorDrawable(Color.BLACK));
                options.centerCrop();

                Glide
                        .with(getContext())
                        .load(user.getProfileImage())
                        .apply(options)
                        .into(imageUser);
                userName.setText(user.getName());
                userUrl.setText(user.getWebsiteUrl().toString());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_user, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
