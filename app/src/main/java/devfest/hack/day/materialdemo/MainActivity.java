package devfest.hack.day.materialdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import devfest.hack.day.materialdemo.fragments.AddFragment;
import devfest.hack.day.materialdemo.fragments.RecycleViewFragment;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private ImageButton fab;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new RecycleViewFragment()).commit();

        fab = (ImageButton)findViewById(R.id.fab);
        fab.setClipToOutline(true);
        fab.setOnClickListener(this);
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
        if (id == R.id.action_favorite) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new AddFragment()).addToBackStack("add").commit();
            //startActivity(new Intent(this, AddActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(fab)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, new AddFragment()).addToBackStack("add").commit();
        }
    }
}
