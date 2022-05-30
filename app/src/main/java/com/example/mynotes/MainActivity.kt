package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var MainActivitySearchBarClearIcon: ImageView
    lateinit var MainActivitySearchBar: EditText
    lateinit var MainActivityAddNotesBtn: CardView
    lateinit var MainActivityRecyclerView: RecyclerView
    lateinit var MainActivityNotesAlignment: ImageView
    lateinit var viewModal: NoteViewModal
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
            }


        }

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


    }


}