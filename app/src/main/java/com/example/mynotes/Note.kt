package com.example.mynotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
class Note(
    @ColumnInfo(name = "Title") val noteTitle: String,
    @ColumnInfo(name = "nNotes") val nNotes: String,
    @ColumnInfo(name = "img") val img: String,
    @ColumnInfo(name = "BackColor") val backColor: String,
    @ColumnInfo(name = "CreatedDate") val createdDate: String,
    @ColumnInfo(name = "UpdatedDate") val updatedDate: String,
    @ColumnInfo(name = "Pin") val pin: String
) {
    @PrimaryKey(autoGenerate = true)
    var SrNo = 0
}
