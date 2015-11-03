package samdev.de.mvuprobelokalapp;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllgStatistik extends Fragment {
    public static final java.lang.String ARG_PAGE = "arg_page";

    public AllgStatistik() {
        // Required empty public constructor
    }

    public static AllgStatistik newInstance(int pageNumber){
        AllgStatistik allgemeinStatistikFragment = new AllgStatistik();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE, pageNumber);
        allgemeinStatistikFragment.setArguments(arguments);
        return allgemeinStatistikFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle arguments = getArguments();
        int pageNumber = arguments.getInt(ARG_PAGE);

        return inflater.inflate(R.layout.fragment_allg_statistik, container, false);
    }


}
