package com.amineghabi.progresslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    RecylerListAdapter recylerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /**
         * Toolbar
         */
        setSupportActionBar(toolbar);
        setTitle("ProgressLayout Demo");

        /**
         * Recyclerview layout arrangement
         */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        /**
         * adapter initialization
         */
        recylerListAdapter = new RecylerListAdapter();
        recyclerView.setAdapter(recylerListAdapter);
        loadMockData();

    }

    /**
     * Load mock data to list
     */
    private void loadMockData(){
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track(1,"Voodoo Mon Amor", "Diablo Swing Orchestra", 81));
        tracks.add(new Track(2,"Guerilla Laments", "Diablo Swing Orchestra", 295));
        tracks.add(new Track(3,"Kewlar Sweethearts", "Diablo Swing Orchestra", 264));
        tracks.add(new Track(4,"How To Organize a Lynch Mob", "Diablo Swing Orchestra", 23));
        tracks.add(new Track(5,"Black Box Messiah", "Diablo Swing Orchestra", 297));
        tracks.add(new Track(6,"Exit Strategy of a Wrecking Ball", "Diablo Swing Orchestra", 361));
        tracks.add(new Track(7,"Aurora", "Diablo Swing Orchestra", 305));
        tracks.add(new Track(8,"Mass Rapture", "Diablo Swing Orchestra", 303));
        tracks.add(new Track(9,"Black Box Messiah", "Diablo Swing Orchestra", 297));
        tracks.add(new Track(10,"Exit Strategy of a Wrecking Ball", "Diablo Swing Orchestra", 361));
        tracks.add(new Track(11,"Aurora", "Diablo Swing Orchestra", 305));
        tracks.add(new Track(12,"Mass Rapture", "Diablo Swing Orchestra", 303));
        recylerListAdapter.setTrackList(tracks);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }
}
