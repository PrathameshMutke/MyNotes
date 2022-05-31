package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Query("Select * from NotesTable order by Pin DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note :Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    /*@Query("SELECT * FROM NotesTable WHERE Pin LIKE :minAge")
    fun getPin(pin: String): Array<Note>*/

}