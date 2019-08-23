package com.example.recyclearapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WebViewFragmentNews.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WebViewFragmentNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebViewFragmentNews extends Fragment {

    private OnFragmentInteractionListener mListener;
    public final static String LINK_KEY = "LINK";
    WebView webView;
    String link;
    public WebViewFragmentNews() {
        // Required empty public constructor
    }




    public static WebViewFragmentNews newInstance() {
        WebViewFragmentNews fragment = new WebViewFragmentNews();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        link = getArguments().getString(LINK_KEY);
        webView = getActivity().findViewById(R.id.web_view_fragment);
        webView.loadUrl(link);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_view_fragment_news, container, false);
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
