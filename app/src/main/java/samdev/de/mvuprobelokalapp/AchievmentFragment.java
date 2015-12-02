package samdev.de.mvuprobelokalapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import samdev.de.mvuprobelokalapp.adapters.AchievmentListAdapter;
import samdev.de.mvuprobelokalapp.other.Achievment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AchievmentFragment extends Fragment {
    public static final java.lang.String ARG_PAGE = "arg_page";
    private ListView achievmentView;


    public AchievmentFragment() {
        // Required empty public constructor
    }

    public static AchievmentFragment newInstance(int pageNumber) {
        AchievmentFragment achievmentFragment = new AchievmentFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE, pageNumber);
        achievmentFragment.setArguments(arguments);
        return achievmentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle arguments = getArguments();
        int pageNumber = arguments.getInt(ARG_PAGE);

        View myInflatedView = inflater.inflate(R.layout.fragment_achievment, container, false);

        achievmentView = (ListView) myInflatedView.findViewById(R.id.listview_achievments);

        Achievment achievment1 = new Achievment();
        achievment1.setTitle("Armin");
        achievment1.setComment("Armiin arbeitet bei Junker");
        achievment1.setThumbnail(R.drawable.ic_mailsend);

        Achievment achievment2 = new Achievment();
        achievment2.setTitle("Mike");
        achievment2.setComment("Mike arbeitet auch bei Junker");
        achievment2.setThumbnail(R.drawable.ic_mailsend);


        ArrayList<Achievment> achievmentList = new ArrayList<Achievment>();
        achievmentList.add(achievment1);
        achievmentList.add(achievment2);


        achievmentView.setAdapter(new AchievmentListAdapter(achievmentList, getActivity()));


        return myInflatedView;
    }

}

