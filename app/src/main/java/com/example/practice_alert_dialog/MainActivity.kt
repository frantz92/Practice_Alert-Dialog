package com.example.practice_alert_dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickListeners(setDialogs())
    }

    private fun setDialogs(): List<AlertDialog> {
        //Yes-No Dialog
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Mr. Poop to your contacts list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added Mr. Poop to your contacts list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add Mr. Poop to your contacts list", Toast.LENGTH_SHORT).show()
            }
            .create()

        //Single-choice Dialog
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the options")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the single choice dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the single choice dialog", Toast.LENGTH_SHORT).show()
            }
            .create()

        // Multi-choice Dialog
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose several of the options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if(isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the multi-choice dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the multi-choice dialog", Toast.LENGTH_SHORT).show()
            }
            .create()

        return listOf(addContactDialog, singleChoiceDialog, multiChoiceDialog)
    }

    private fun onClickListeners(dialogsAlerts : List<AlertDialog>) {
        btn_1.setOnClickListener {
            dialogsAlerts[0].show()
        }

        btn_2.setOnClickListener {
            dialogsAlerts[1].show()
        }

        btn_3.setOnClickListener {
            dialogsAlerts[2].show()
        }
    }

}