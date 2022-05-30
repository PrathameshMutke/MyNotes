package com.example.mynotes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val context: Context) : RecyclerView.Adapter<NotesAdapter.viewHolder>() {

    private val allNotes = ArrayList<Note>()

    class viewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val layout_notes_title = itemView.findViewById<TextView>(R.id.layout_notes_title)
        val layout_notes_notes = itemView.findViewById<TextView>(R.id.layout_notes_notes)
        val layout_notes_backColor =
            itemView.findViewById<RelativeLayout>(R.id.layout_notes_backColor)
        val layout_notes_MainLayout = itemView.findViewById<CardView>(R.id.layout_notes_MainLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_notes, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val SrNo = allNotes.get(position).SrNo
        val Title = allNotes.get(position).noteTitle
        val NOtes = allNotes.get(position).nNotes
        val Img = allNotes.get(position).img
        val BackColor = allNotes.get(position).backColor
        val CreatedDate = allNotes.get(position).createdDate
        val UpdatedDate = allNotes.get(position).updatedDate

        when (BackColor) {
            "Red" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.red
                )
            )
            "Blue" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.blue
                )
            )
            "Yellow" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.yellow
                )
            )
            "Green" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.green
                )
            )
            "Black" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.Black_Secondary2
                )
            )
        }

        holder.layout_notes_title.setText(Title)
        holder.layout_notes_notes.setText(NOtes)

        val srNO = SrNo.toString()

        holder.layout_notes_MainLayout.setOnClickListener {
            val intent = Intent(context, UpdateNotesActivity::class.java)
            intent.putExtra("SrNo", srNO)
                .putExtra("Title", Title)
                .putExtra("Notes", NOtes)
                .putExtra("Img", Img)
                .putExtra("BackColor", BackColor)
                .putExtra("CreatedDate", CreatedDate)
                .putExtra("UpdatedDate", UpdatedDate)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            context.startActivity(intent)
        }

    }

    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

}