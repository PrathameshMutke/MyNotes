package com.example.mynotes

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class NoteRepository(private val notesDao: NotesDao) {

    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()
    val allPinNotes: LiveData<List<Note>> = notesDao.getAllPinNotes()

    fun insert(note: Note) {
        notesDao.insert(note)
    }

    fun delete(note: Note) {
        notesDao.delete(note)
    }

    fun update(note: Note) {
        notesDao.update(note)
    }

    fun searchData(searchQuery: String): kotlinx.coroutines.flow.Flow<List<Note>> {
        return notesDao.searchData(searchQuery)
    }

}
