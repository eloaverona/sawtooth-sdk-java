package io.bitwise.sawtooth_xo

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.Menu
import android.view.MenuItem
import io.bitwise.sawtooth_xo.models.Game
import io.bitwise.sawtooth_xo.viewmodels.GameViewModel


class MainActivity : AppCompatActivity(),  GameListFragment.OnListFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.list_view_toolbar))


        val fab: FloatingActionButton = findViewById(R.id.newGameFloatingButton)
        fab.setOnClickListener { _ ->
            val intent = Intent(this, GameBoardActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.list_view_menu, menu)
        return true
    }

    override fun onListFragmentInteraction(item: Game?) {
        //To be implemented
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.refresh_list -> {
            val model = ViewModelProviders.of(this).get(GameViewModel::class.java)
            model.loadGames(true)
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
