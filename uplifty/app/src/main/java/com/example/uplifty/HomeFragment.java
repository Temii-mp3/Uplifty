package com.example.uplifty;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private Handler onClickHandler = new Handler();
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

   private MyDatabaseHelper myDB;
    ArrayList<String> mantras = new ArrayList<String>();
    //private CustomAdapter customAdapter = new CustomAdapter(mantras);
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        showMantras(APP_MANTRAS, rootView);
        return rootView;
    }



    /**
     * This method shows all the mantras dynamically by creating a text view & button for each mantra
     * performance will definately worsen as more mantras get added, temp fix cuz recycler view not working lel
     * @param arr the array of mantras
     * @param rootView root view of the layout(fragment)
     */
    void showMantras(String[] arr, View rootView){
         myDB = new MyDatabaseHelper(HomeFragment.this.getContext());

        ScrollView scrv = (ScrollView) rootView.findViewById(R.id.relative_layout_mantras);
        //linear layout to hold both mantras and button
        LinearLayout linearLayout = new LinearLayout(this.getContext());
        linearLayout.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                                    LinearLayout.LayoutParams.MATCH_PARENT));


        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrv.addView(linearLayout);
        for(String n : arr){
            //adding new linear layout to button and text side by side
            LinearLayout itemLayout = new LinearLayout(this.getContext());
            itemLayout.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView mantraDisplay = new TextView(this.getContext());
            ImageButton button = new ImageButton(this.getContext());
            mantraDisplay.setText(n);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1;
            mantraDisplay.setLayoutParams(layoutParams);
            button.setMinimumWidth(80);
            button.setBackgroundResource(R.drawable.favourite_icon);
            AtomicBoolean isClicked = new AtomicBoolean(false);
            button.setOnClickListener(v->{
                    button.setBackgroundResource(R.drawable.favourite_icon_pressed);
                    myDB.addMantra(mantraDisplay.getText().toString());
            });

            button.setOnLongClickListener(v->{
                button.setBackgroundResource(R.drawable.favourite_icon);
                myDB.removeData(mantraDisplay.getText().toString());
                return true;
            });


            itemLayout.addView(mantraDisplay);
            itemLayout.addView(button);

            linearLayout.addView(itemLayout);
        }
    }

}