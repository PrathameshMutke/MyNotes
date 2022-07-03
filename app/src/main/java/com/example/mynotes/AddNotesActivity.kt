package com.example.mynotes

import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AddNotesActivity : AppCompatActivity() {

    /*
    SrNo Primary Key Auto Incr+++
    Title
    notes
    img
    BackColor
    CreatedDate
    UpdatedDate
    */

    lateinit var AddNotesActivityBackBtn: ImageView
    lateinit var AddNotesActivityImage: ImageView
    lateinit var AddNotesActivityAddImgBtn: ImageView
    lateinit var AddNotesActivityTitle: EditText
    lateinit var AddNotesActivityNotes: EditText
    lateinit var AddNotesActivityMenuBtn: ImageView
    lateinit var AddNotesActivityMainLayout: RelativeLayout
    lateinit var AddNotesActivityBackgroungColorTxt: TextView
    lateinit var AddNotesActivitySaveBtn: ImageView
    lateinit var AddNotesActivityBottomLayout: LinearLayout
    lateinit var AddNotesActivityImgUriTxt: TextView

    val APP_TAG = "My Notes"

    private val pickImage = 100
    private var imageUri: Uri? = null
    lateinit var viewModal: NoteViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        AddNotesActivityImgUriTxt = findViewById(R.id.AddNotesActivityImgUriTxt)
        AddNotesActivityBackBtn = findViewById(R.id.AddNotesActivityBackBtn)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        window.statusBarColor = ContextCompat.getColor(this, R.color.Black_Secondary2)

        AddNotesActivityBottomLayout = findViewById(R.id.AddNotesActivityBottomLayout)
        AddNotesActivityBackgroungColorTxt = findViewById(R.id.AddNotesActivityBackgroungColorTxt)
        AddNotesActivityBackgroungColorTxt.text = "Black"
        AddNotesActivityMainLayout = findViewById(R.id.AddNotesActivityMainLayout)
        AddNotesActivityMenuBtn = findViewById(R.id.AddNotesActivityMenuBtn)
        AddNotesActivityMenuBtn.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog_addnotes, null)

            val BottomSheetDialogAddNotesRed: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesRed)
            BottomSheetDialogAddNotesRed.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.red
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.red)
                AddNotesActivityBackgroungColorTxt.text = "Red"
            }

            val BottomSheetDialogAddNotesBlue: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesBlue)
            BottomSheetDialogAddNotesBlue.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.blue
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
                AddNotesActivityBackgroungColorTxt.text = "Blue"
            }

            val BottomSheetDialogAddNotesYellow: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesYellow)
            BottomSheetDialogAddNotesYellow.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.yellow
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.yellow)
                AddNotesActivityBackgroungColorTxt.text = "Yellow"
            }

            val BottomSheetDialogAddNotesGreen: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesGreen)
            BottomSheetDialogAddNotesGreen.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.green
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.green)
                AddNotesActivityBackgroungColorTxt.text = "Green"
            }

            val BottomSheetDialogAddNotesPink: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesPink)
            BottomSheetDialogAddNotesPink.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.pink
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.pink)
                AddNotesActivityBackgroungColorTxt.text = "Pink"
            }

            val BottomSheetDialogAddNotesPurple: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesPurple)
            BottomSheetDialogAddNotesPurple.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.purple)
                AddNotesActivityBackgroungColorTxt.text = "Purple"
            }

            val BottomSheetDialogAddNotesOrange: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesOrange)
            BottomSheetDialogAddNotesOrange.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.Orange
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.Orange)
                AddNotesActivityBackgroungColorTxt.text = "Orange"
            }

            val BottomSheetDialogAddNotesTeal: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesTeal)
            BottomSheetDialogAddNotesTeal.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.teal
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.teal)
                AddNotesActivityBackgroungColorTxt.text = "Teal"
            }

            val BottomSheetDialogAddNotesBlack: RelativeLayout =
                view.findViewById(R.id.BottomSheetDialogAddNotesBlack)
            BottomSheetDialogAddNotesBlack.setOnClickListener {
                AddNotesActivityBottomLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.Black_Secondary2
                    )
                )
                window.statusBarColor = ContextCompat.getColor(this, R.color.Black_Secondary2)
                AddNotesActivityBackgroungColorTxt.text = "Black"
            }

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }

        AddNotesActivityImage = findViewById(R.id.AddNotesActivityImage)
        AddNotesActivityAddImgBtn = findViewById(R.id.AddNotesActivityAddImgBtn)
        AddNotesActivityAddImgBtn.setOnClickListener {
            //val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            //startActivityForResult(gallery, pickImage)
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), pickImage)
        }


        AddNotesActivityTitle = findViewById(R.id.AddNotesActivityTitle)
        AddNotesActivityNotes = findViewById(R.id.AddNotesActivityNotes)

        AddNotesActivityBackBtn.setOnClickListener {
            val titleT = AddNotesActivityTitle.text.toString()
            val notesN = AddNotesActivityNotes.text.toString()

            if (titleT.isEmpty() && notesN.isEmpty()){
                finish()
            }else{
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(true)
                dialog.setContentView(R.layout.confirm_save_dialog)
                dialog.window!!.setBackgroundDrawable(
                    this.getResources().getDrawable(R.drawable.popup_background)
                )

                val confirm_save_dialog_Save = dialog.findViewById<TextView>(R.id.confirm_save_dialog_Save)
                confirm_save_dialog_Save.setOnClickListener {
                    val title = AddNotesActivityTitle.text.toString()
                    val notes = AddNotesActivityNotes.text.toString()
                    val img = AddNotesActivityImgUriTxt.text.toString()
                    val backColor = AddNotesActivityBackgroungColorTxt.text.toString()
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
                        viewModal.addNote(Note(title, notes, img, backColor, timeStamp, updatedDate, "0"))
                        Toast.makeText(this, "Notes Added", Toast.LENGTH_LONG).show()
                        finish()
                    }
                }

                val confirm_save_dialog_DontSave = dialog.findViewById<TextView>(R.id.confirm_save_dialog_DontSave)
                confirm_save_dialog_DontSave.setOnClickListener {
                    dialog.dismiss()
                    finish()
                }

                val confirm_save_dialog_Cancel = dialog.findViewById<TextView>(R.id.confirm_save_dialog_Cancel)
                confirm_save_dialog_Cancel.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.show()
            }
        }

        AddNotesActivitySaveBtn = findViewById(R.id.AddNotesActivitySaveBtn)
        AddNotesActivitySaveBtn.setOnClickListener {
            val title = AddNotesActivityTitle.text.toString()
            val notes = AddNotesActivityNotes.text.toString()
            val img = AddNotesActivityImgUriTxt.text.toString()
            val backColor = AddNotesActivityBackgroungColorTxt.text.toString()
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
                viewModal.addNote(Note(title, notes, img, backColor, timeStamp, updatedDate, "0"))
                Toast.makeText(this, "Notes Added", Toast.LENGTH_LONG).show()
                finish()
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            AddNotesActivityImage.setImageURI(imageUri)
            AddNotesActivityImgUriTxt.setText(imageUri.toString())


            //val imageBitmap = imageUri?.let { uriToBitmap(it) }

            /*val baos = ByteArrayOutputStream()
            if (imageBitmap != null) {
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 10, baos)
            }
            val b = baos.toByteArray()
            val String64 =  Base64.encodeToString(b, Base64.DEFAULT)
            AddNotesActivityImgUriTxt.setText(String64)*/

            //AddNotesActivityImage.setImageBitmap(imageBitmap)

            /*
            val baos = ByteArrayOutputStream()
            if (imageBitmap != null) {
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
            }

            val b: ByteArray = baos.toByteArray()
            //val encodedImage = Base64.decode(b)
            val eI = Base64.encodeToString(b, Base64.DEFAULT)
            AddNotesActivityImgUriTxt.text = eI*/

        }
    }

    private fun uriToBitmap(uri: Uri): Bitmap {
        return MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
    }

    override fun onBackPressed() {
        val titleT = AddNotesActivityTitle.text.toString()
        val notesN = AddNotesActivityNotes.text.toString()

        if (titleT.isEmpty() && notesN.isEmpty()){
            finish()
        }else{
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.confirm_save_dialog)
            dialog.window!!.setBackgroundDrawable(
                this.getResources().getDrawable(R.drawable.popup_background)
            )

            val confirm_save_dialog_Save = dialog.findViewById<TextView>(R.id.confirm_save_dialog_Save)
            confirm_save_dialog_Save.setOnClickListener {
                val title = AddNotesActivityTitle.text.toString()
                val notes = AddNotesActivityNotes.text.toString()
                val img = AddNotesActivityImgUriTxt.text.toString()
                val backColor = AddNotesActivityBackgroungColorTxt.text.toString()
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
                    viewModal.addNote(Note(title, notes, img, backColor, timeStamp, updatedDate, "0"))
                    Toast.makeText(this, "Notes Added", Toast.LENGTH_LONG).show()
                    finish()
                }
            }

            val confirm_save_dialog_DontSave = dialog.findViewById<TextView>(R.id.confirm_save_dialog_DontSave)
            confirm_save_dialog_DontSave.setOnClickListener {
                dialog.dismiss()
                finish()
            }

            val confirm_save_dialog_Cancel = dialog.findViewById<TextView>(R.id.confirm_save_dialog_Cancel)
            confirm_save_dialog_Cancel.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }
    }


}

