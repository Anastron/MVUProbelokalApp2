package samdev.de.mvuprobelokalapp;


import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllgStatistik extends Fragment {
    public static final java.lang.String ARG_PAGE = "arg_page";


    String bier_Getrunken, susses, bier_Spendiert, sonst_Get, geld_Augegeben;

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

        View myInflatedView = inflater.inflate(R.layout.fragment_allg_statistik, container, false);

        aktualisiereStatistik();

        // Setzen der Anzeigen
        TextView txt_Bier_Getrunken = (TextView) myInflatedView.findViewById(R.id.textView_Biere_Getrunken);
        txt_Bier_Getrunken.setText(bier_Getrunken);
        TextView txt_Susses = (TextView) myInflatedView.findViewById(R.id.textView_susses);
        txt_Susses.setText(susses);
        TextView txt_BiereSpendiert = (TextView) myInflatedView.findViewById(R.id.textView_Biere_spendiert);
        txt_BiereSpendiert.setText(bier_Spendiert);
        TextView txt_SonstigGet = (TextView) myInflatedView.findViewById(R.id.textView_Sonst_Get);
        txt_SonstigGet.setText(sonst_Get);
        TextView txt_GeldAus = (TextView) myInflatedView.findViewById(R.id.textView_Geld_aus);
        txt_GeldAus.setText(geld_Augegeben);


        return myInflatedView;
    }

 private void aktualisiereStatistik(){
        SharedPreferences statistik = this.getActivity().getSharedPreferences("statistik", 0);
        bier_Getrunken = ("Bier getrunken: " + statistik.getInt("Bier", 0));

        susses = ("Süßes gegessen: " + statistik.getInt("suess", 0));

        bier_Spendiert = ("Bier spendiert: " + statistik.getInt("spendiert", 0));

        sonst_Get = ("sonstige Getränke: " + statistik.getInt("sonstige", 0));

        int i = statistik.getInt("geldausgegeben", 0);
        double a = (double)i / 100;
        geld_Augegeben = ("Geld ausgegeben " + a + " €");

    }
}
