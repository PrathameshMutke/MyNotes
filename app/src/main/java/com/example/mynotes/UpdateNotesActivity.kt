package com.example.mynotes

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*

class UpdateNotesActivity : AppCompatActivity() {

    lateinit var UpdatedNotesActivityBackBtn: ImageView
    lateinit var UpdatedNotesActivityBackgroungColorTxt: TextView
    lateinit var UpdatedNotesActivityMainLayout: RelativeLayout
    lateinit var UpdatedNotesActivityMenuBtn: ImageView
    lateinit var UpdatedNotesActivitySaveBtn: ImageView
    lateinit var UpdatedNotesActivityTitle: EditText
    lateinit var UpdatedNotesActivityNotes: EditText
    lateinit var UpdatedNotesActivityCreatedDate: TextView
    lateinit var UpdatedNotesActivityUpdatedDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_notes)

        val SrNo = intent.getStringExtra("SrNo").toString()
        val Title = intent.getStringExtra("Title").toString()
        val Notes = intent.getStringExtra("Notes").toString()
        val Img = intent.getStringExtra("Img").toString()
        val BackColor = intent.getStringExtra("BackColor").toString()
        val CreatedDate = intent.getStringExtra("CreatedDate").toString()
        val UpdatedDate = intent.getStringExtra("UpdatedDate").toString()

        UpdatedNotesActivityMainLayout = findViewById(R.id.UpdatedNotesActivityMainLayout)
        when (BackColor) {
            "Red" -> UpdatedNotesActivityMainLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.red
                )
            )
            "Blue" -> UpdatedNotesActivityMainLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.blue
                )
            )
            "Yellow" -> UpdatedNotesActivityMainLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.yellow
                )
            )
            "Green" -> UpdatedNotesActivityMainLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.green
                )
            )
            "Black" -> UpdatedNotesActivityMainLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.Black_Secondary
                )
            )
        }


        when (BackColor) {
            "Red" -> window.statusBarColor = ContextCompat.getColor(this, R.color.red)
            "Blue" -> window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
            "Yellow" -> window.statusBarColor = ContextCompat.getColor(this, R.color.yellow)
            "Green" -> window.statusBarColor = ContextCompat.getColor(this, R.color.green)
            "Black" -> window.statusBarColor = ContextCompat.getColor(this, R.color.Black_Secondary)
        }



        UpdatedNotesActivityTitle = findViewById(R.id.UpdatedNotesActivityTitle)
        UpdatedNotesActivityTitle.setText(Title)

        UpdatedNotesActivityNotes = findViewById(R.id.UpdatedNotesActivityNotes)
        UpdatedNotesActivityNotes.setText(Notes)

        UpdatedNotesActivityCreatedDate = findViewById(R.id.UpdatedNotesActivityCreatedDate)
        UpdatedNotesActivityUpdatedDate = findViewById(R.id.UpdatedNotesActivityUpdatedDate)

        UpdatedNotesActivityCreatedDate.visibility = View.GONE
        UpdatedNotesActivityUpdatedDate.visibility = View.GONE

        if (UpdatedDate.equals("")) {
            UpdatedNotesActivityCreatedDate.visibility = View.VISIBLE
            UpdatedNotesActivityUpdatedDate.visibility = View.GONE

            val date = java.lang.Long.valueOf(CreatedDate)
            val simpleDateFormat = SimpleDateFormat("dd MMM yyyy hh:mm aaa", Locale.getDefault())
            val createdDate: String = simpleDateFormat.format(date)
            UpdatedNotesActivityCreatedDate.text = "Created On " + createdDate
        } else if (!UpdatedDate.equals("")) {
            UpdatedNotesActivityCreatedDate.visibility = View.VISIBLE
            UpdatedNotesActivityUpdatedDate.visibility = View.VISIBLE

            val date = java.lang.Long.valueOf(CreatedDate)
            val simpleDateFormat = SimpleDateFormat("dd MMM yyyy hh:mm aaa", Locale.getDefault())
            val createdDate: String = simpleDateFormat.format(date)
            UpdatedNotesActivityCreatedDate.text = "Created On " + createdDate

            val date2 = java.lang.Long.valueOf(UpdatedDate)
            val updatedDate: String = simpleDateFormat.format(date2)
            UpdatedNotesActivityUpdatedDate.text = "Last Updated On " + updatedDate

        }



        UpdatedNotesActivityBackBtn = findViewById(R.id.UpdatedNotesActivityBackBtn)
        UpdatedNotesActivityBackBtn.setOnClickListener {
            finish()
        }

        UpdatedNotesActivityBackgroungColorTxt =
            findViewById(R.id.UpdatedNotesActivityBackgroungColorTxt)
        UpdatedNotesActivityBackgroungColorTxt.text = BackColor
        UpdatedNotesActivityMenuBtn = findViewById(R.id.UpdatedNotesActivityMenuBtn)
        UpdatedNotesActivityMenuBtn.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog_updatenotes, null)

            val BottomSheetDialogUpdateNotesRed: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesRed)
            BottomSheetDialogUpdateNotesRed.setOnClickListener {
                UpdatedNotesActivityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.red
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.red)
                UpdatedNotesActivityBackgroungColorTxt.text = "Red"
            }

            val BottomSheetDialogUpdateNotesBlue: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesBlue)
            BottomSheetDialogUpdateNotesBlue.setOnClickListener {
                UpdatedNotesActivityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.blue
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
                UpdatedNotesActivityBackgroungColorTxt.text = "Blue"
            }

            val BottomSheetDialogUpdateNotesYellow: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesYellow)
            BottomSheetDialogUpdateNotesYellow.setOnClickListener {
                UpdatedNotesActivityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.yellow
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.yellow)
                UpdatedNotesActivityBackgroungColorTxt.text = "Yellow"
            }

            val BottomSheetDialogUpdateNotesGreen: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesGreen)
            BottomSheetDialogUpdateNotesGreen.setOnClickListener {
                UpdatedNotesActivityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.green
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                UpdatedNotesActivityBackgroungColorTxt.text = "Green"
            }

            val BottomSheetDialogUpdateNotesBlack: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesBlack)
            BottomSheetDialogUpdateNotesBlack.setOnClickListener {
                UpdatedNotesActivityMainLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.Black_Secondary
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.Black_Secondary)
                UpdatedNotesActivityBackgroungColorTxt.text = "Black"
            }

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }


        UpdatedNotesActivitySaveBtn = findViewById(R.id.UpdatedNotesActivitySaveBtn)
        UpdatedNotesActivitySaveBtn.setOnClickListener {

        }


    }
}