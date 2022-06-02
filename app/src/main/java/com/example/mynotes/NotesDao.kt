package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    //@Query("Select * from NotesTable order by Pin DESC")
    @Query("Select * from NotesTable WHERE Pin LIKE 0 ORDER BY CreatedDate")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("Select * from NotesTable WHERE Pin LIKE 1 ORDER BY CreatedDate")
    fun getAllPinNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)

    @Query("SELECT * FROM NotesTable WHERE Title LIKE :SearchQuery OR nNotes LIKE :SearchQuery")
    fun searchData(SearchQuery: String): Flow<List<Note>>

    /*@Query("SELECT * FROM NotesTable WHERE Pin LIKE :minAge")
    fun getPin(pin: String): Array<Note>*/

}