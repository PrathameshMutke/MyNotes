package com.example.mynotes

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class UpdateNotesActivity : AppCompatActivity() {

    lateinit var UpdatedNotesActivityBackBtn: ImageView
    lateinit var UpdatedNotesActivityBackgroungColorTxt: TextView
    lateinit var UpdatedNotesActivityMenuBtn: ImageView
    lateinit var UpdatedNotesActivitySaveBtn: ImageView
    lateinit var UpdatedNotesActivityTitle: EditText
    lateinit var UpdatedNotesActivityNotes: EditText
    lateinit var UpdatedNotesActivityCreatedDate: TextView
    lateinit var UpdatedNotesActivityUpdatedDate: TextView
    lateinit var UpdatedNotesActivityBottomLayout: LinearLayout
    lateinit var UpdatedNotesActivityPinBtn: ImageView
    lateinit var UpdatedNotesActivityPinTxt: TextView
    lateinit var viewModal: NoteViewModal

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
        val Pin = intent.getStringExtra("Pin").toString()

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        UpdatedNotesActivityBottomLayout = findViewById(R.id.UpdatedNotesActivityBottomLayout)


        UpdatedNotesActivityPinTxt = findViewById(R.id.UpdatedNotesActivityPinTxt)
        UpdatedNotesActivityPinTxt.text = Pin
        UpdatedNotesActivityPinBtn = findViewById(R.id.UpdatedNotesActivityPinBtn)
        if (Pin.equals("0")) {
            UpdatedNotesActivityPinBtn.setBackgroundResource(R.drawable.icon_pin)
        } else {
            UpdatedNotesActivityPinBtn.setBackgroundResource(R.drawable.icon_unpin)
        }
        UpdatedNotesActivityPinBtn.setOnClickListener {
            val PinTxt = UpdatedNotesActivityPinTxt.text.toString()

            if (PinTxt.equals("0")) {
                val updatedNotes = Note(Title, Notes, Img, BackColor, CreatedDate, UpdatedDate, "1")
                updatedNotes.SrNo = Integer.parseInt(SrNo)
                viewModal.updateNote(updatedNotes)
                UpdatedNotesActivityPinBtn.setBackgroundResource(R.drawable.icon_unpin)
                UpdatedNotesActivityPinTxt.text = "1"
            } else {
                val updatedNotes = Note(Title, Notes, Img, BackColor, CreatedDate, UpdatedDate, "0")
                updatedNotes.SrNo = Integer.parseInt(SrNo)
                viewModal.updateNote(updatedNotes)
                UpdatedNotesActivityPinBtn.setBackgroundResource(R.drawable.icon_pin)
                UpdatedNotesActivityPinTxt.text = "0"
            }
        }

        when (BackColor) {
            "Red" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.red
                )
            )
            "Blue" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.blue
                )
            )
            "Yellow" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.yellow
                )
            )
            "Green" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.green
                )
            )

            "Pink" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.pink
                )
            )

            "Purple" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.purple
                )
            )

            "Orange" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.Orange
                )
            )

            "Teal" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.teal
                )
            )

            "Black" -> UpdatedNotesActivityBottomLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.Black_Secondary2
                )
            )
        }

        when (BackColor) {
            "Red" -> window.statusBarColor = ContextCompat.getColor(this, R.color.red)
            "Blue" -> window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
            "Yellow" -> window.statusBarColor = ContextCompat.getColor(this, R.color.yellow)
            "Green" -> window.statusBarColor = ContextCompat.getColor(this, R.color.green)
            "Pink" -> window.statusBarColor = ContextCompat.getColor(this, R.color.pink)
            "Purple" -> window.statusBarColor = ContextCompat.getColor(this, R.color.purple)
            "Orange" -> window.statusBarColor = ContextCompat.getColor(this, R.color.Orange)
            "Teal" -> window.statusBarColor = ContextCompat.getColor(this, R.color.teal)
            "Black" -> window.statusBarColor =
                ContextCompat.getColor(this, R.color.Black_Secondary2)
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
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
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
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
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
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
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
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.green
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                UpdatedNotesActivityBackgroungColorTxt.text = "Green"
            }

            val BottomSheetDialogUpdateNotesPink: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesPink)
            BottomSheetDialogUpdateNotesPink.setOnClickListener {
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.pink
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.pink)
                UpdatedNotesActivityBackgroungColorTxt.text = "Pink"
            }

            val BottomSheetDialogUpdateNotesPurple: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesPurple)
            BottomSheetDialogUpdateNotesPurple.setOnClickListener {
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.purple)
                UpdatedNotesActivityBackgroungColorTxt.text = "Purple"
            }

            val BottomSheetDialogUpdateNotesOrange: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesOrange)
            BottomSheetDialogUpdateNotesOrange.setOnClickListener {
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.Orange
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.Orange)
                UpdatedNotesActivityBackgroungColorTxt.text = "Orange"
            }

            val BottomSheetDialogUpdateNotesTeal: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesTeal)
            BottomSheetDialogUpdateNotesTeal.setOnClickListener {
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.teal
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.teal)
                UpdatedNotesActivityBackgroungColorTxt.text = "Teal"
            }


            val BottomSheetDialogUpdateNotesBlack: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateNotesBlack)
            BottomSheetDialogUpdateNotesBlack.setOnClickListener {
                UpdatedNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.Black_Secondary
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.Black_Secondary)
                UpdatedNotesActivityBackgroungColorTxt.text = "Black"
            }

            val BottomSheetDialogUpdateMakeACopyBtn: LinearLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateMakeACopyBtn)
            BottomSheetDialogUpdateMakeACopyBtn.setOnClickListener {
                val title = UpdatedNotesActivityTitle.text.toString()
                val notes = UpdatedNotesActivityNotes.text.toString()
                val img = "blank"
                val backColor = UpdatedNotesActivityBackgroungColorTxt.text.toString()
                val sdf = SimpleDateFormat("dd MMM yyyy hh:mm aaa")
                val createdDate: String = sdf.format(Date())
                var date: Date? = null
                try {
                    date = sdf.parse(createdDate)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
                val TimeMilli = date!!.time
                val timeStamp = TimeMilli.toString()

                val updatedDate = ""

                if (title.isEmpty() || notes.isEmpty()) {
                    Toast.makeText(this, "Please Enter title and notes", Toast.LENGTH_LONG).show()
                } else {
                    viewModal.addNote(
                        Note(
                            title,
                            notes,
                            img,
                            backColor,
                            timeStamp,
                            updatedDate,
                            "0"
                        )
                    )
                    Toast.makeText(this, "Notes Copy Created", Toast.LENGTH_LONG).show()
                    finish()
                }
            }

            val BottomSheetDialogUpdateDeleteBtn: LinearLayout =
                view.findViewById(R.id.BottomSheetDialogUpdateDeleteBtn)
            BottomSheetDialogUpdateDeleteBtn.setOnClickListener {
                val deleteNotes = Note("", "", "", "", "", "", "")
                deleteNotes.SrNo = Integer.parseInt(SrNo)
                viewModal.deleteNote(deleteNotes)
                Toast.makeText(this, "Notes Deleted", Toast.LENGTH_LONG).show()
                finish()
            }

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }


        UpdatedNotesActivitySaveBtn = findViewById(R.id.UpdatedNotesActivitySaveBtn)
        UpdatedNotesActivitySaveBtn.setOnClickListener {
            val PinTxt = UpdatedNotesActivityPinTxt.text.toString()
            val title = UpdatedNotesActivityTitle.text.toString()
            val notes = UpdatedNotesActivityNotes.text.toString()
            val img = "blank"
            val backColor = UpdatedNotesActivityBackgroungColorTxt.text.toString()
            val createdDate = CreatedDate

            val sdf = SimpleDateFormat("dd MMM yyyy hh:mm aaa")
            val uUpdatedDate: String = sdf.format(Date())
            var date: Date? = null
            try {
                date = sdf.parse(uUpdatedDate)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            val TimeMilli = date!!.time
            val updatedDate = TimeMilli.toString()

            if (title.isEmpty() || notes.isEmpty()) {
                Toast.makeText(this, "Please Enter title and notes", Toast.LENGTH_LONG).show()
            } else {
                val updatedNotes =
                    Note(title, notes, img, backColor, createdDate, updatedDate, PinTxt)
                updatedNotes.SrNo = Integer.parseInt(SrNo)
                viewModal.updateNote(updatedNotes)
                Toast.makeText(this, "Notes Updated", Toast.LENGTH_LONG).show()
            }

        }


    }
}