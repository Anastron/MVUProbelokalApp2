package samdev.de.mvuprobelokalapp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

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
        checkForAchievments();

        return myInflatedView;
    }

    private void checkForAchievments(){

        SharedPreferences statistik = this.getActivity().getSharedPreferences("statistik", 0);
        ArrayList<Achievment> achievmentList = new ArrayList<>();
        int anzahlBier = statistik.getInt("Bier", 0);
        boolean bNoAchievment = true;

        if(anzahlBier >= 24){
            Achievment bier24Achievment = new Achievment();
            bier24Achievment.setTitle("1 Kasten");
            bier24Achievment.setComment("Du hast 24 Biere im Probelokal getrunken");
            bier24Achievment.setThumbnail(R.drawable.ic_mailsend);
            achievmentList.add(bier24Achievment);
            bNoAchievment = false;
        }
        if(anzahlBier >= 120){
            Achievment bier24Achievment = new Achievment();
            bier24Achievment.setTitle("5 Kästen");
            bier24Achievment.setComment("Du hast 120 Biere im Probelokal getrunken");
            bier24Achievment.setThumbnail(R.drawable.ic_mailsend);
            achievmentList.add(bier24Achievment);
            bNoAchievment = false;
        }

        if(bNoAchievment){
            Achievment noAchievment = new Achievment();
            noAchievment.setTitle("Keine Erfolge");
            noAchievment.setComment("Du hast noch nichts besonderliches Erreicht");
            noAchievment.setThumbnail(R.drawable.noachievment);
            achievmentList.add(noAchievment);
        }

        achievmentView.setAdapter(new AchievmentListAdapter(achievmentList, getActivity()));
    }

}

