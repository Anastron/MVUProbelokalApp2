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



public class StatistikActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private StatisticPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);
        mAdapter = new StatisticPagerAdapter(getSupportFragmentManager());
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment =
                (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_statistik);
        mPager = (ViewPager) findViewById(R.id.pagerStatistik);
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


    public static class WeitereTabsFragment extends Fragment{
        public static final java.lang.String ARG_PAGE = "arg_page";

        public WeitereTabsFragment(){

        }

        public static WeitereTabsFragment newInstance(int pageNumber){
            WeitereTabsFragment weitereTabsFragmentt = new WeitereTabsFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(ARG_PAGE, pageNumber);
            weitereTabsFragmentt.setArguments(arguments);
            return weitereTabsFragmentt;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            Bundle arguments = getArguments();
            int pageNumber = arguments.getInt(ARG_PAGE);
            TextView myText = new TextView(getActivity());
            myText.setText("Es werden noch weitere Statistiken hinzukommen. Zunächst wird aber die allgemeine Statistik implementiert");
            myText.setGravity(Gravity.CENTER);
            return myText;
        }
    }

}

class StatisticPagerAdapter extends FragmentPagerAdapter {
    static private int anzahlTabs = 3;

    public StatisticPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            AllgStatistik allgemeinStatistik = AllgStatistik.newInstance(position);
            return allgemeinStatistik;
        } else if (position == 1){
            AchievmentFragment achievmentFragment = AchievmentFragment.newInstance(position);
            return achievmentFragment;
        } else if (position == 2) {
            StatistikActivity.WeitereTabsFragment weitereTabsFragment = StatistikActivity.WeitereTabsFragment.newInstance(position);
            return weitereTabsFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return anzahlTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Allg. Statistiken";
        } else if(position == 1){
          return "Achievments";
        } else if (position == 2) {
            return "Mehr";
        } else {
            return null;
        }
    }
}