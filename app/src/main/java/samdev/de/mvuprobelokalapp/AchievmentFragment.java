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
        int anzahlGetraenke = statistik.getInt("sonstige", 0);
        int anzahlSpenden = statistik.getInt("spendiert", 0);
        int anzahlGeld = statistik.getInt("geldausgegeben", 0);
        int anzahlSuess = statistik.getInt("suess", 0);
        boolean bNoAchievment = true;

        if(anzahlBier >= 24){
            Achievment bier24Achievment = new Achievment();
            bier24Achievment.setTitle("1 Kasten");
            bier24Achievment.setComment("Du hast 24 Biere im Probelokal getrunken.");
            bier24Achievment.setThumbnail(R.drawable.beericon1);
            achievmentList.add(bier24Achievment);
            bNoAchievment = false;
        }
        if(anzahlBier >= 120){
            Achievment bier24Achievment = new Achievment();
            bier24Achievment.setTitle("5 Kästen");
            bier24Achievment.setComment("Du hast 120 Biere im Probelokal getrunken, das ist schon einiges.");
            bier24Achievment.setThumbnail(R.drawable.beericon2);
            achievmentList.add(bier24Achievment);
            bNoAchievment = false;
        }
        if(anzahlGetraenke >= 25){
            Achievment getrAchievment = new Achievment();
            getrAchievment.setTitle("25 Getränke");
            getrAchievment.setComment("Du hast 25 Getränke gekauft.");
            getrAchievment.setThumbnail(R.drawable.sonstgetr);
            achievmentList.add(getrAchievment);
            bNoAchievment = false;
        }
        if(anzahlSpenden >= 20){
            Achievment spendAchievment = new Achievment();
            spendAchievment.setTitle("Spendierfreudig");
            spendAchievment.setComment("Du hast 20 mal einen ausgegeben!");
            spendAchievment.setThumbnail(R.drawable.giftachievment);
            achievmentList.add(spendAchievment);
            bNoAchievment = false;
        }
        if(anzahlGeld >= 50*100){
            Achievment achievment = new Achievment();
            achievment.setTitle("Unterstützer");
            achievment.setComment("Du hast 50€ in die Kasse eingezahlt.");
            achievment.setThumbnail(R.drawable.moneyachievment1);
            achievmentList.add(achievment);
            bNoAchievment = false;
        }
        if(anzahlSuess >= 30){
            Achievment achievment = new Achievment();
            achievment.setTitle("Du süßes Ding");
            achievment.setComment("Du hast 30 süße Sachen gekauft. Bist du eine Naschkatze?");
            achievment.setThumbnail(R.drawable.sweetachievment);
            achievmentList.add(achievment);
            bNoAchievment = false;
        }


        if(bNoAchievment){
            Achievment noAchievment = new Achievment();
            noAchievment.setTitle("Keine Erfolge");
            noAchievment.setComment("Du hast noch nichts besonderliches erreicht.");
            noAchievment.setThumbnail(R.drawable.noachievment);
            achievmentList.add(noAchievment);
        }

        achievmentView.setAdapter(new AchievmentListAdapter(achievmentList, getActivity()));
    }

}

