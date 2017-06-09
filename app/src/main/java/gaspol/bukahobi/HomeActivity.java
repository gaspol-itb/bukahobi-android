package gaspol.bukahobi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import gaspol.bukahobi.adapters.GridViewImageViewAdapter;
import gaspol.bukahobi.models.TagHolder;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridView gridViewCatagoryGroup;
    private GridViewImageViewAdapter gridViewImageViewAdapter;

    private LinearLayout linearLayoutInsideHorizontalScrollViewMyGroup;
    private LinearLayout linearLayoutInsideHorizontalScrollViewSuggestedGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        linearLayoutInsideHorizontalScrollViewMyGroup = (LinearLayout) findViewById(R.id.linearLayoutInsideHorizontalScrollViewMyGroup);
        initHorizontalScrollViewMyGroup();

        linearLayoutInsideHorizontalScrollViewSuggestedGroup = (LinearLayout) findViewById(R.id.linearLayoutInsideHorizontalScrollViewSuggestedGroup);
        initHorizontalScrollViewSuggestedGroup();

        gridViewImageViewAdapter = new GridViewImageViewAdapter(this);

        gridViewCatagoryGroup = (GridView) findViewById(R.id.gridViewCatagoryGroup);
        gridViewCatagoryGroup.setAdapter(gridViewImageViewAdapter);

        gridViewCatagoryGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view, "Clicked " + i, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initHorizontalScrollViewMyGroup () {
        //get data in here
        //iterate the data in here and init view
        linearLayoutInsideHorizontalScrollViewMyGroup.addView(setCircleImageView(R.drawable.mygroup_1, "1"));
        linearLayoutInsideHorizontalScrollViewMyGroup.addView(setCircleImageView(R.drawable.mygroup_2, "2"));
    }

    private void initHorizontalScrollViewSuggestedGroup () {
        //get data in here
        //iterate the data in here and init view
        linearLayoutInsideHorizontalScrollViewSuggestedGroup.addView(setCircleImageView(R.drawable.suggestedgroup_1, "1"));
        linearLayoutInsideHorizontalScrollViewSuggestedGroup.addView(setCircleImageView(R.drawable.suggestedgroup_2, "2"));
        linearLayoutInsideHorizontalScrollViewSuggestedGroup.addView(setCircleImageView(R.drawable.suggestedgroup_3, "3"));
    }

    private View setCircleImageView (int imageId, String id) {
        CircleImageView imageView = new CircleImageView(this);
        imageView.setImageResource(imageId);
        imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        TagHolder tagHolder = new TagHolder();
        tagHolder.id = id;
        imageView.setTag(tagHolder);

        final HomeActivity self = this;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TagHolder tagHolder = (TagHolder) view.getTag();
                Snackbar.make(view, "Clicked image view " + tagHolder.id, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();

                Intent intent = new Intent(self, GroupActivity.class);
                startActivity(intent);
            }
        });
        return imageView;
    }

    public void fabCreateGroupOnClickHandler (View view) {
        Intent intent = new Intent(this, CreateGroupActivity.class);
        startActivity(intent);
    }
}
