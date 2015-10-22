package samdev.de.mvuprobelokalapp;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;



public class BargeschActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private MyPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargesch);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment =
                (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
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

    public static class EinkaufFragment extends Fragment{
        public static final java.lang.String ARG_PAGE = "arg_page";

        public EinkaufFragment(){

        }

        public static EinkaufFragment newInstance(int pageNumber){
            EinkaufFragment einkaufFragment = new EinkaufFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(ARG_PAGE, pageNumber);
            einkaufFragment.setArguments(arguments);
            return einkaufFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            Bundle arguments = getArguments();
            int pageNumber = arguments.getInt(ARG_PAGE);
            TextView myText = new TextView(getActivity());
            myText.setText("Kauf");
            myText.setGravity(Gravity.CENTER);
            return myText;
        }
    }

    public static class BezahlenFragment extends Fragment{
        public static final java.lang.String ARG_PAGE = "arg_page";

        public BezahlenFragment(){

        }

        public static BezahlenFragment newInstance(int pageNumber){
            BezahlenFragment bezahlenFragment = new BezahlenFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(ARG_PAGE, pageNumber);
            bezahlenFragment.setArguments(arguments);
            return bezahlenFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            Bundle arguments = getArguments();
            int pageNumber = arguments.getInt(ARG_PAGE);
            TextView myText = new TextView(getActivity());
            myText.setText("Bezahlen");
            myText.setGravity(Gravity.CENTER);
            return myText;
        }
    }

}


class MyPagerAdapter extends FragmentPagerAdapter{
    static private int anzahlTabs = 2;

    public MyPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        if(position == 0) {
            BargeschActivity.EinkaufFragment einkaufFragment = BargeschActivity.EinkaufFragment.newInstance(position);
            return einkaufFragment;
        } else if(position == 1){
            BargeschActivity.BezahlenFragment bezahlenFragment = BargeschActivity.BezahlenFragment.newInstance(position);
            return bezahlenFragment;
        }
        return null;
    }

    @Override
    public int getCount(){
        return anzahlTabs;
    }

    @Override
    public CharSequence getPageTitle(int position){
        if(position == 0) {
            return "Einkauf";
        } else if (position == 1){
            return "Einzahlung";
        } else {
            return null;
        }

    }
}

