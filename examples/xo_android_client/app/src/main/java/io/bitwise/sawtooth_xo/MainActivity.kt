package io.bitwise.sawtooth_xo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View

class MainActivity : AppCompatActivity(), CreateNewGameDialog.CreateNewGameDialogListener {

    fun showDialog() {
        // Create an instance of the dialog fragment and show it
        val dialog = CreateNewGameDialog()
        dialog.show(supportFragmentManager, "CreateNewGameDialogFragment")
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    override fun onDialogPositiveClick(dialog: DialogFragment) {
        // User touched the dialog's positive button
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        // User touched the dialog's negative button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Create New Game button callback */
    fun createNewGame(view: View) {
        showDialog()
        // Do something in response to button
    }

    /** List Games button callback */
    fun listGames(view: View) {
        val intent = Intent(this, ListGamesActivity::class.java)
        startActivity(intent)
    }


}


