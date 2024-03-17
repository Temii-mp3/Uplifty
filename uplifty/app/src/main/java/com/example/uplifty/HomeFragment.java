package com.example.uplifty;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private String[] APP_MANTRAS = {
            "You are calm and centered.",
            "You trust yourself and your abilities.",
            "You are worthy of love and respect.",
            "You let go of what you can't control.",
            "You are grateful for this moment.",
            "You embrace change with courage.",
            "You are resilient and strong.",
            "You forgive yourself and others.",
            "You attract positivity into your life.",
            "You are surrounded by abundance.",
            "You choose happiness and peace.",
            "You are capable of achieving your goals.",
            "You are constantly evolving and growing.",
            "You release fear and embrace love.",
            "You are enough just as you are.",
            "You find joy in the present moment.",
            "You are guided by your intuition.",
            "You let go of comparison and embrace uniqueness.",
            "You are at peace with your past.",
            "You radiate love and kindness."};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        MyDatabaseHelper_2 myDB = new MyDatabaseHelper_2(HomeFragment.this.getContext());

        myDB.deleteALlData();
        for(String n: APP_MANTRAS){
            myDB.addALlMantras(n);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}