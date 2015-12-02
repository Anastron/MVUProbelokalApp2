package samdev.de.mvuprobelokalapp;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;


public class BargeschActivity extends ActionBarActivity {

    private Toolbar toolbar;
//    private TabLayout mTabLayout;
//    private ViewPager mPager;
//    private MyPagerAdapter mAdapter;
    private FloatingActionButton mFAB;
    private LinearLayout mRoot;

    TextView txt_Guthaben;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargesch);
        mRoot = (LinearLayout) findViewById(R.id.root_activity_bargesch);
//        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment =
                (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        final Button btn_BuyBier = (Button) findViewById(R.id.buyBier);
        final Button btn_BuyGetraenk = (Button) findViewById(R.id.buyGetraenk);
        final Button btn_BuyMars = (Button) findViewById(R.id.buyMars);
        final Button btn_BuyDuplo = (Button) findViewById(R.id.buyDuplo);
        final Button btn_BuyNasch = (Button) findViewById(R.id.buyNaschzeugs);
        final Button btn_BuySpende = (Button) findViewById(R.id.buyGetraenkSpende);

        txt_Guthaben = (TextView) findViewById(R.id.GuthabenAnzeige);

        aktualisiereGuthaben();

       btn_BuyGetraenk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                moneyThings(100);
                addGet();
                Snackbar.make(mRoot, "Getränk gekauft", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btn_BuyMars.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moneyThings(50);
                addSuess();
                Snackbar.make(mRoot, "Riegel gekauft", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btn_BuyDuplo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moneyThings(30);
                addSuess();
                Snackbar.make(mRoot, "Riegel gekauft", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btn_BuyNasch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moneyThings(100);
                addSuess();
                Snackbar.make(mRoot, "Naschzeug gekauft", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btn_BuySpende.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moneyThings(100);
                addSpendiert();
                Snackbar.make(mRoot, "Du hast etwas spendiert! Sehr gut!", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        btn_BuyBier.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moneyThings(100);
                addBier();
                Snackbar.make(mRoot, "Bier gekauft", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        com.getbase.floatingactionbutton.FloatingActionButton actionD = new com.getbase.floatingactionbutton.FloatingActionButton(getBaseContext());


        final com.getbase.floatingactionbutton.FloatingActionButton actionC = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_c);
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mRoot, "5€ zum Guthaben hinzugefügt", Snackbar.LENGTH_LONG)
                        .show();

                moreGuthaben(500);
            }
        });

        final com.getbase.floatingactionbutton.FloatingActionButton actionB = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mRoot, "10€ zum Guthaben hinzugefügt", Snackbar.LENGTH_LONG)
                        .show();

                moreGuthaben(1000);
            }
        });

        final com.getbase.floatingactionbutton.FloatingActionButton actionA = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mRoot, "20€ zum Guthaben hinzugefügt", Snackbar.LENGTH_LONG)
                        .show();

                moreGuthaben(2000);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bargesch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, PreferenceActivity.class);
            startActivity(i);
        }
        if(id == R.id.action_info){
            startActivity(new Intent(this, AppInfo.class));
        }

        if(id == R.id.navigate_hp){
            Intent myFollowMeWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myFollowMeWebLink.setData(Uri.parse("http://www.musikverein-unterharmersbach.de/"));
            startActivity(myFollowMeWebLink);
        }
        if(id == R.id.sorrymail){
            startActivity(new Intent(this, SorryMail.class));
        }


        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener mFabClickListener = new View.OnClickListener(){
        public void onClick(View v){
            Snackbar.make(mRoot, "FAB Clicked", Snackbar.LENGTH_LONG)
                    .show();
        }
    };


    private void aktualisiereGuthaben(){
        SharedPreferences guthaben = getSharedPreferences("guthaben", 0);
        int f_guthaben = guthaben.getInt("guthaben", 0);
        double dGuthaben = (double) f_guthaben / 100;
        String txt1 = "Guthaben: " + (dGuthaben) + " €";
        txt_Guthaben.setText(txt1);
    }


    private void moreGuthaben(int newGuthaben) {

        SharedPreferences guthaben = getSharedPreferences("guthaben", 0);
        int f_guthaben = guthaben.getInt("guthaben", 0);
        f_guthaben += newGuthaben;
        Editor editor = guthaben.edit();
        editor.putInt("guthaben", f_guthaben);
        editor.commit();
        aktualisiereGuthaben();
    }

    private void moneyThings(int money)
    {

        SharedPreferences guthaben = getSharedPreferences("guthaben", 0);
        int f_guthaben = guthaben.getInt("guthaben", 0);
        f_guthaben -= money;
        Editor editor = guthaben.edit();
        editor.putInt("guthaben", f_guthaben);
        editor.commit();

        addGeldAus(money);
        aktualisiereGuthaben();
    }

    private void addGeldAus(int ausgabe){
        SharedPreferences statistik = getSharedPreferences("statistik", 0);
        int menge = statistik.getInt("geldausgegeben", 0);
        menge += ausgabe;
        Editor editor = statistik.edit();
        editor.putInt("geldausgegeben", menge);
        editor.commit();

        if(menge >= 50 * 100 && (menge-ausgabe) < 50 * 100 ){ // 50
            AlertDialog alertDialog = new AlertDialog.Builder(BargeschActivity.this).create();
            alertDialog.setTitle("Unterstützer");
            alertDialog.setMessage("50 Euro sind durch dich schon in der Kasse gelandet. \nGönne dir etwas Süßes als Belohnung.");
            alertDialog.setIcon(R.drawable.moneyachievment1);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void addBier(){
        SharedPreferences statistik = getSharedPreferences("statistik", 0);
        int bier_menge = statistik.getInt("Bier", 0);
        bier_menge++;
        Editor editor = statistik.edit();
        editor.putInt("Bier", bier_menge);
        editor.commit();

        if(bier_menge == 24){ //24
            AlertDialog alertDialog = new AlertDialog.Builder(BargeschActivity.this).create();
            alertDialog.setTitle("Kasten Bier");
            alertDialog.setMessage("Du hast deinen ersten Kasten Bier getrunken! \nSchnapp dir dafür ein Bier.");
            alertDialog.setIcon(R.drawable.beericon1);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        if(bier_menge == 120){ // 120
            AlertDialog alertDialog = new AlertDialog.Builder(BargeschActivity.this).create();
            alertDialog.setTitle("120 Biere!");
            alertDialog.setMessage("Du hast tatsächlich 120 Biere getrunken. 5 Kästen sind das! WOW! \nSchnapp dir dafür ein Bier.");
            alertDialog.setIcon(R.drawable.beericon2);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void addSpendiert(){
        SharedPreferences statistik = getSharedPreferences("statistik", 0);
        int menge = statistik.getInt("spendiert", 0);
        menge++;
        Editor editor = statistik.edit();
        editor.putInt("spendiert", menge);
        editor.commit();

        if(menge == 20){ // 20
            AlertDialog alertDialog = new AlertDialog.Builder(BargeschActivity.this).create();
            alertDialog.setTitle("Spendierfreudig");
            alertDialog.setMessage("Du hast schon 20 Getränke ausgegeben. \nGönne dir dafür selbt mal ein Getränk.");
            alertDialog.setIcon(R.drawable.giftachievment);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void addSuess(){
        SharedPreferences statistik = getSharedPreferences("statistik", 0);
        int menge = statistik.getInt("suess", 0);
        menge++;
        Editor editor = statistik.edit();
        editor.putInt("suess", menge);
        editor.commit();

        if(menge == 30){ // 30
            AlertDialog alertDialog = new AlertDialog.Builder(BargeschActivity.this).create();
            alertDialog.setTitle("Du süßes Ding");
            alertDialog.setMessage("Du hast 30 süße Sachen gekauft. \nDu darfst dir nun nochmal etwas Süßes gönnen!");
            alertDialog.setIcon(R.drawable.sweetachievment);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }


    private void addGet(){
        SharedPreferences statistik = getSharedPreferences("statistik", 0);
        int menge = statistik.getInt("sonstige", 0);
        menge++;
        Editor editor = statistik.edit();
        editor.putInt("sonstige", menge);
        editor.commit();

        if(menge == 25){ // 25
            AlertDialog alertDialog = new AlertDialog.Builder(BargeschActivity.this).create();
            alertDialog.setTitle("25 Getränke");
            alertDialog.setMessage("Das war dein 25 Getränk. \nGönne dir dafür ein Getränk.");
            alertDialog.setIcon(R.drawable.sonstgetr);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
}

