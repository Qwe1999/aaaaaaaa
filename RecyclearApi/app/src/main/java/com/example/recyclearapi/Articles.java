package com.example.recyclearapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import android.webkit.WebViewFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Articles.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Articles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Articles extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Articll> myDataset;


    private OnFragmentInteractionListener mListener;

    public Articles() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Articles newInstance(String param1, String param2) {
        Articles fragment = new Articles();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);


        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        NetworkService.getInstance().getJSONApi().getPostAll().enqueue(new Callback<List<Articll>>() {
            @Override
            public void onResponse(Call<List<Articll>> call, Response<List<Articll>> response) {
                myDataset = response.body();

                MyAdapter.OnArticlClickListener onArticlClickListener = new MyAdapter.OnArticlClickListener() {
                    @Override
                    public void onAticleClick(String link) {
                        WebViewFragmentNews webViewFragmentNews = new WebViewFragmentNews();
                        Bundle bundle1 = new Bundle();
                        bundle1.putString(WebViewFragmentNews.LINK_KEY,link);
                        webViewFragmentNews.setArguments(bundle1);
                        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.layout_for_veb_view,
                                webViewFragmentNews).commit();
                    }
                };

                MyAdapter.OnUserClickListener onUserClickListener = new MyAdapter.OnUserClickListener() {
                    @Override
                    public void onUserClick(String link) {
                        FragmentUser fragmentUser = new FragmentUser();
                        Bundle bundle = new Bundle();
                        bundle.putString(FragmentUser.keyUserName, link);
                        fragmentUser.setArguments(bundle);

                        getFragmentManager().beginTransaction().addToBackStack(null)
                                .replace(R.id.layout_for_veb_view,
                                fragmentUser).commit();
                    }
                };
                mAdapter = new MyAdapter(myDataset,onArticlClickListener,onUserClickListener);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Articll>> call, Throwable t) {

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
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


    public void onClickNew(View view){

    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }


}
