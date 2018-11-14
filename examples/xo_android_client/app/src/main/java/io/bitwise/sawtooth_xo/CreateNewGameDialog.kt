package io.bitwise.sawtooth_xo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CreateNewGameDialog.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CreateNewGameDialog.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CreateNewGameDialog : DialogFragment() {

    // Use this instance of the interface to deliver action events
    internal lateinit var mListener: CreateNewGameDialogListener

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    interface CreateNewGameDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = context as CreateNewGameDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Build the dialog and set up the button click handlers
            val builder = AlertDialog.Builder(it)

            builder.setMessage(R.string.newNameDialogMessage)
                .setTitle(R.string.newGameDialogTitle)
                .setPositiveButton(R.string.submitCreateGameTransaction,
                    DialogInterface.OnClickListener { dialog, id ->
                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(this)
                    })
                .setNegativeButton(R.string.dismissDialog,
                    DialogInterface.OnClickListener { dialog, id ->
                        // Send the negative button event back to the host activity
                        mListener.onDialogNegativeClick(this)
                    })

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

}
