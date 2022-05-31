package com.example.mynotes

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var MainActivitySearchBarClearIcon: ImageView
    lateinit var MainActivitySearchBar: EditText
    lateinit var MainActivityAddNotesBtn: CardView
    lateinit var MainActivityRecyclerView: RecyclerView
    lateinit var MainActivityPinRecyclerView: RecyclerView
    lateinit var MainActivityNotesAlignment: ImageView
    lateinit var viewModal: NoteViewModal
    lateinit var notesAdapter: NotesAdapter
    lateinit var notesAdapter2: NotesAdapter
    val icons = IntArray(3)
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        icons[0] = R.drawable.icon_grid3
        icons[1] = R.drawable.icon_grid1
        icons[2] = R.drawable.icon_grid2

        MainActivitySearchBar = findViewById(R.id.MainActivitySearchBar)
        MainActivityAddNotesBtn = findViewById(R.id.MainActivityAddNotesBtn)

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


        MainActivityNotesAlignment = findViewById(R.id.MainActivityNotesAlignment)
        MainActivityNotesAlignment.setImageResource(icons[2])
        MainActivityNotesAlignment.setOnClickListener {
            MainActivityNotesAlignment.setImageResource(icons[i])
            i++;
            if (i == 3)
                i = 0;

            if (i == 0) {
                MainActivityRecyclerView = findViewById(R.id.MainActivityRecyclerView)
                MainActivityRecyclerView.layoutManager = GridLayoutManager(this, 2)
                val notesAdapter = NotesAdapter(this)
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
                MainActivityPinRecyclerView = findViewById(R.id.MainActivityPinRecyclerView)
                MainActivityPinRecyclerView.layoutManager = GridLayoutManager(this, 2)
                notesAdapter2 = NotesAdapter(this)
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
                MainActivityRecyclerView = findViewById(R.id.MainActivityRecyclerView)
                MainActivityRecyclerView.layoutManager = GridLayoutManager(this, 3)
                val notesAdapter = NotesAdapter(this)
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
                MainActivityPinRecyclerView = findViewById(R.id.MainActivityPinRecyclerView)
                MainActivityPinRecyclerView.layoutManager = GridLayoutManager(this, 3)
                notesAdapter2 = NotesAdapter(this)
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
                MainActivityRecyclerView = findViewById(R.id.MainActivityRecyclerView)
                MainActivityRecyclerView.layoutManager = GridLayoutManager(this, 1)
                val notesAdapter = NotesAdapter(this)
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
                MainActivityPinRecyclerView = findViewById(R.id.MainActivityPinRecyclerView)
                MainActivityPinRecyclerView.layoutManager = GridLayoutManager(this, 1)
                notesAdapter2 = NotesAdapter(this)
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


        }

        MainActivityRecyclerView = findViewById(R.id.MainActivityRecyclerView)
        MainActivityRecyclerView.layoutManager = GridLayoutManager(this, 2)
        notesAdapter = NotesAdapter(this)
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

        MainActivityPinRecyclerView = findViewById(R.id.MainActivityPinRecyclerView)
        MainActivityPinRecyclerView.layoutManager = GridLayoutManager(this, 2)
        notesAdapter2 = NotesAdapter(this)
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

    private fun filter(query: String) {
        val searchQuery = "%$query%"
        viewModal.searchData(searchQuery).observe(this, androidx.lifecycle.Observer { list ->
            list?.let {
                notesAdapter.updateList(it)
            }
        })
    }

}