package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Query("Select * from NotesTable order by SrNo ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note :Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

}