package com.example.mynotes

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), NoteClickPinInterface, NoteClickDeleteInterface,
    NoteClickMakeCopyInterface {

    lateinit var MainActivitySearchBarClearIcon: ImageView
    lateinit var MainActivitySearchBar: EditText
    lateinit var MainActivityAddNotesBtn: CardView
    lateinit var MainActivityRecyclerView: RecyclerView
    lateinit var MainActivityPinRecyclerView: RecyclerView
    lateinit var MainActivityNotesAlignment: ImageView
    lateinit var MainActivityPinTxt: TextView
    lateinit var MainActivityOtherTxt: TextView
    lateinit var viewModal: NoteViewModal
    lateinit var notesAdapter: NotesAdapter
    lateinit var notesAdapter2: NotesAdapter
    lateinit var MainActivitySwipeRefreshLayout: SwipeRefreshLayout
    val icons = IntArray(3)
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivitySwipeRefreshLayout = findViewById(R.id.MainActivitySwipeRefreshLayout)
        MainActivitySwipeRefreshLayout.setOnRefreshListener {
            finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        icons[0] = R.drawable.icon_grid3
        icons[1] = R.drawable.icon_grid1
        icons[2] = R.drawable.icon_grid2

        MainActivitySearchBar = findViewById(R.id.MainActivitySearchBar)
        MainActivityAddNotesBtn = findViewById(R.id.MainActivityAddNotesBtn)

        MainActivityPinTxt = findViewById(R.id.MainActivityPinTxt)
        MainActivityPinTxt.visibility = View.GONE

        MainActivityOtherTxt = findViewById(R.id.MainActivityOtherTxt)
        MainActivityOtherTxt.visibility = View.GONE

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        MainActivityAddNotesBtn.setOnClickListener {
            val intent = Intent(this, AddNotesActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        MainActivitySearchBarClearIcon = findViewById(R.id.MainActivitySearchBarClearIcon)
        MainActivitySearchBarClearIcon.setVisibility(View.GONE)
        MainActivitySearchBarClearIcon.setOnClickListener {
            MainActivitySearchBar.setText("")
        }

        MainActivitySearchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                val SS = s.toString()
                filter(SS)
                if (SS.isEmpty()) {
                    MainActivitySearchBarClearIcon.setVisibility(View.GONE)
                } else {
                    filter(s.toString())
                    MainActivitySearchBarClearIcon.setVisibility(View.VISIBLE)
                }
            }
        })

        MainActivityRecyclerView = findViewById(R.id.MainActivityRecyclerView)
        MainActivityPinRecyclerView = findViewById(R.id.MainActivityPinRecyclerView)

        notesAdapter = NotesAdapter(this, this, this, this)
        notesAdapter2 = NotesAdapter(this, this, this, this)


        MainActivityNotesAlignment = findViewById(R.id.MainActivityNotesAlignment)
        MainActivityNotesAlignment.setImageResource(icons[2])
        MainActivityNotesAlignment.setOnClickListener {
            MainActivityNotesAlignment.setImageResource(icons[i])
            i++
            if (i == 3)
                i = 0

            //
            if (i == 0) {
                MainActivityRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

                MainActivityRecyclerView.adapter = notesAdapter
                viewModal = ViewModelProvider(
                    this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application)
                ).get(NoteViewModal::class.java)
                viewModal.allNotes.observe(this, androidx.lifecycle.Observer { list ->
                    list?.let {
                        notesAdapter.updateList(it)
                    }
                })

                //Pin
                MainActivityPinRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

                MainActivityPinRecyclerView.adapter = notesAdapter2
                viewModal = ViewModelProvider(
                    this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application)
                ).get(NoteViewModal::class.java)
                viewModal.allPinNotes.observe(this, androidx.lifecycle.Observer { list ->
                    list?.let {
                        notesAdapter2.updateList(it)
                    }
                })


            } else if (i == 1) {
                MainActivityRecyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

                MainActivityRecyclerView.adapter = notesAdapter
                viewModal = ViewModelProvider(
                    this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application)
                ).get(NoteViewModal::class.java)
                viewModal.allNotes.observe(this, androidx.lifecycle.Observer { list ->
                    list?.let {
                        notesAdapter.updateList(it)
                    }
                })


                //Pin
                MainActivityPinRecyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

                MainActivityPinRecyclerView.adapter = notesAdapter2
                viewModal = ViewModelProvider(
                    this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application)
                ).get(NoteViewModal::class.java)
                viewModal.allPinNotes.observe(this, androidx.lifecycle.Observer { list ->
                    list?.let {
                        notesAdapter2.updateList(it)
                    }
                })

            } else if (i == 2) {
                MainActivityRecyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

                MainActivityRecyclerView.adapter = notesAdapter
                viewModal = ViewModelProvider(
                    this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application)
                ).get(NoteViewModal::class.java)
                viewModal.allNotes.observe(this, androidx.lifecycle.Observer { list ->
                    list?.let {
                        notesAdapter.updateList(it)
                    }
                })

                //Pin
                MainActivityPinRecyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

                MainActivityPinRecyclerView.adapter = notesAdapter2
                viewModal = ViewModelProvider(
                    this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(application)
                ).get(NoteViewModal::class.java)
                viewModal.allPinNotes.observe(this, androidx.lifecycle.Observer { list ->
                    list?.let {
                        notesAdapter2.updateList(it)
                    }
                })

            }
            //


        }


        //MainActivityRecyclerView.layoutManager = GridLayoutManager(this, 2)
        MainActivityRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        MainActivityRecyclerView.adapter = notesAdapter
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)
        viewModal.allNotes.observe(this, androidx.lifecycle.Observer { list ->
            list?.let {
                notesAdapter.updateList(it)
            }
        })

        //MainActivityPinRecyclerView.layoutManager = GridLayoutManager(this, 2)
        MainActivityPinRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        MainActivityPinRecyclerView.adapter = notesAdapter2
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)
        viewModal.allPinNotes.observe(this, androidx.lifecycle.Observer { list ->
            list?.let {
                notesAdapter2.updateList(it)
            }
            if (list.isEmpty()){
                MainActivityPinTxt.visibility = View.GONE
                MainActivityOtherTxt.visibility = View.GONE
            }else{
                MainActivityPinTxt.visibility = View.VISIBLE
                MainActivityOtherTxt.visibility = View.VISIBLE
            }
        })

    }

    private fun filter(query: String) {
        val searchQuery = "%$query%"
        viewModal.searchData(searchQuery).observe(this, androidx.lifecycle.Observer { list ->
            list?.let {
                notesAdapter.updateList(it)
            }
        })
    }

    override fun OnPinClick(
        note: Note,
        SrNo: String,
        Title: String,
        Notes: String,
        Img: String,
        BackColor: String,
        CreatedDate: String,
        UpdatedDate: String,
        Pin: String
    ) {
        if (Pin.equals("0")) {
            val updatedNotes = Note(Title, Notes, Img, BackColor, CreatedDate, UpdatedDate, "1")
            updatedNotes.SrNo = Integer.parseInt(SrNo)
            viewModal.updateNote(updatedNotes)
        } else {
            val updatedNotes = Note(Title, Notes, Img, BackColor, CreatedDate, UpdatedDate, "0")
            updatedNotes.SrNo = Integer.parseInt(SrNo)
            viewModal.updateNote(updatedNotes)
        }
    }

    override fun OnDeleteClick(note: Note) {
        viewModal.deleteNote(note)
        Toast.makeText(this, "Note Deleted", Toast.LENGTH_SHORT).show()
    }

    override fun OnCopyClick(
        note: Note,
        SrNo: String,
        Title: String,
        Notes: String,
        Img: String,
        BackColor: String,
        CreatedDate: String,
        UpdatedDate: String,
        Pin: String
    ) {

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

        viewModal.addNote(
            Note(
                Title,
                Notes,
                Img,
                BackColor,
                timeStamp,
                "",
                "0"
            )
        )
        Toast.makeText(this, "Notes Copy Created", Toast.LENGTH_LONG).show()
    }

}