package samdev.de.mvuprobelokalapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private boolean userAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(userAvailable) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment =
                (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout), toolbar);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean bReset = SP.getBoolean("reset", false);

        if(bReset)
        {
            resetData();
            SharedPreferences.Editor editor = SP.edit();
            editor.putBoolean("reset", false);
            editor.commit();
        }

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
        if(id == R.id.refresh){

        }


        return super.onOptionsItemSelected(item);
    }

    private void resetData()
    {
        SharedPreferences guthaben = getSharedPreferences("guthaben", 0);
        SharedPreferences.Editor editor = guthaben.edit();
        editor.putInt("guthaben", 0);
        editor.commit();


        SharedPreferences statistik = getSharedPreferences("statistik", 0);
        editor = statistik.edit();
        editor.putInt("geldausgegeben",0);
        editor.putInt("Bier", 0);
        editor.putInt("spendiert", 0);
        editor.putInt("suess", 0);
        editor.putInt("sonstige", 0);
        editor.commit();

        SharedPreferences user = getSharedPreferences("user", 0);
        editor = user.edit();
        editor.putString("name", "");
        editor.putString("password", "");
        editor.putString("rechte", "");
        editor.commit();

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Zurückgesetzt");
        alertDialog.setMessage("Alle Werte wurden zurückgesetzt!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
