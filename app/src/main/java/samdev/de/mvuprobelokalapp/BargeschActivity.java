package samdev.de.mvuprobelokalapp;


import android.content.Intent;
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
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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


        com.getbase.floatingactionbutton.FloatingActionButton actionD = new com.getbase.floatingactionbutton.FloatingActionButton(getBaseContext());
        //actionC.setTextAlignment();
        //actionC.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Snackbar.make(mRoot, "FAB C Clicked", Snackbar.LENGTH_LONG)
        //                .show();
        //    }
        //});

        final com.getbase.floatingactionbutton.FloatingActionButton actionC = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_c);
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mRoot, "5€ zum Guthaben hinzugefügt", Snackbar.LENGTH_LONG)
                        .show();
                ;
            }
        });

        final com.getbase.floatingactionbutton.FloatingActionButton actionB = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mRoot, "10€ zum Guthaben hinzugefügt", Snackbar.LENGTH_LONG)
                        .show();
                ;
            }
        });

        final com.getbase.floatingactionbutton.FloatingActionButton actionA = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mRoot, "20€ zum Guthaben hinzugefügt", Snackbar.LENGTH_LONG)
                        .show();;
            }
        });
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

    private View.OnClickListener mFabClickListener = new View.OnClickListener(){
        public void onClick(View v){
            Snackbar.make(mRoot, "FAB Clicked", Snackbar.LENGTH_LONG)
                    .show();
        }
    };
}

