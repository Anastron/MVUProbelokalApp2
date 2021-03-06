package samdev.de.mvuprobelokalapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class TerminActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termin);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment =
                (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.imageViewPlan);
        mImageView.setImageResource(R.drawable.plan);

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
}
