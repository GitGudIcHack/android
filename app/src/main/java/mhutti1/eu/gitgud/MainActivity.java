package mhutti1.eu.gitgud;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

  private Toolbar toolbar;
  private SearchView searchView;
  private CardArrayAdapter questionArrayAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    setContentView(R.layout.activity_main);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    ListView questions = (ListView) findViewById(R.id.question_list);
    questionArrayAdapter = new CardArrayAdapter(this, R.id.card_view);
    questions.setAdapter(questionArrayAdapter);
   // questionArrayAdapter.add(new Question("test", "test", "test", 1, true));
    //questionArrayAdapter.add(new Question("test2", "test2", "test2", 1, false));

    questionArrayAdapter.notifyDataSetChanged();


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
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    MenuItem searchViewMenuItem = menu.findItem(R.id.action_search);
    searchView = (SearchView) searchViewMenuItem.getActionView();
    toolbar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        searchView.setIconified(false);
      }
    });
    int searchImgId =  android.support.v7.appcompat.R.id.search_button;
    ImageView v = (ImageView) searchView.findViewById(searchImgId);
    v.setImageResource(R.drawable.ic_question_answer_white_24px);
    final int hintId = android.support.v7.appcompat.R.id.search_src_text;
    SearchView.SearchAutoComplete text = (SearchView.SearchAutoComplete) searchView.findViewById(hintId);
    text.setHint("Ask...");
    text.setImeOptions(EditorInfo.IME_ACTION_SEND);
    searchView.setOnQueryTextListener(this);
    return super.onPrepareOptionsMenu(menu);
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

  @Override
  public boolean onQueryTextSubmit(String query) {
    searchView.setIconified(true);
    if (!query.isEmpty()) {
      questionArrayAdapter.add(new Question(query, "", "", 1, false));
    }
    return true;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
    return false;
  }
}
