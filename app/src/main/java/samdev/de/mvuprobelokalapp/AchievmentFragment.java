package samdev.de.mvuprobelokalapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import samdev.de.mvuprobelokalapp.adapters.AdapterAchievments;
import samdev.de.mvuprobelokalapp.other.Achievment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AchievmentFragment extends Fragment {
    public static final java.lang.String ARG_PAGE = "arg_page";
    private RecyclerView achievmentList;
    private ArrayList<Achievment>listAchivments = new ArrayList<>();
    private AdapterAchievments adapterAchievments;

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




        achievmentList = (RecyclerView) myInflatedView.findViewById(R.id.listAchievments);
   //     achievmentList.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterAchievments = new AdapterAchievments(getActivity());
        achievmentList.setAdapter(adapterAchievments);

        // sollte doch so gehen? :D
        Achievment achievment = new Achievment();
        achievment.setTitle("Test");
        achievment.setComment("Testing");
        achievment.setThumbnail("@mipmap/ic_launcher");
        listAchivments.add(achievment);
        adapterAchievments.setAchievmentList(listAchivments);





        return myInflatedView;
    }




}



