package com.example.mynotes

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class NotesAdapter(
    val context: Context,
    val noteClickPinInterface: NoteClickPinInterface,
    val noteClickShareInterface: NoteClickShareInterface,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickMakeCopyInterface: NoteClickMakeCopyInterface
) : RecyclerView.Adapter<NotesAdapter.viewHolder>() {

    private val allNotes = ArrayList<Note>()

    class viewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val layout_notes_title = itemView.findViewById<TextView>(R.id.layout_notes_title)
        val layout_notes_notes = itemView.findViewById<TextView>(R.id.layout_notes_notes)
        val layout_notes_backColor =
            itemView.findViewById<RelativeLayout>(R.id.layout_notes_backColor)
        val layout_notes_MainLayout = itemView.findViewById<CardView>(R.id.layout_notes_MainLayout)
        val layout_notes_PinLayout =
            itemView.findViewById<RelativeLayout>(R.id.layout_notes_PinLayout)
        val layout_notes_PinColor = itemView.findViewById<ImageView>(R.id.layout_notes_PinColor)
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
        val Pin = allNotes.get(position).pin

        //viewModal = ViewModelProvider(context, ViewModelProvider.AndroidViewModelFactory.getInstance(context as Application)).get(NoteViewModal::class.java)

        if (Pin.equals("0")) {
            holder.layout_notes_PinLayout.visibility = View.GONE
        } else {
            holder.layout_notes_PinLayout.visibility = View.VISIBLE
        }

        when (BackColor) {
            "Red" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.red
                )
            )
            "Blue" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.blue
                )
            )
            "Yellow" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.yellow
                )
            )
            "Green" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.green
                )
            )
            "Pink" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.pink
                )
            )
            "Purple" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.purple
                )
            )
            "Orange" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.Orange
                )
            )
            "Teal" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.teal
                )
            )
            "Black" -> holder.layout_notes_PinColor.setColorFilter(
                ContextCompat.getColor(
                    context,
                    R.color.white
                )
            )
        }


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
            "Pink" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.pink
                )
            )
            "Purple" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.purple
                )
            )
            "Orange" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.Orange
                )
            )
            "Teal" -> holder.layout_notes_backColor.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.teal
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
                .putExtra("Pin", Pin)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            context.startActivity(intent)
        }


        holder.layout_notes_MainLayout.setOnLongClickListener {
            val dialog = BottomSheetDialog(context)
            val view = LayoutInflater.from(context)
                .inflate(R.layout.bottom_sheet_dialog_ondoubleclick, null)

            val BottomSheetDialogOnDoubleClickPinBtnIcon =
                view.findViewById<ImageView>(R.id.BottomSheetDialogOnDoubleClickPinBtnIcon)
            val BottomSheetDialogOnDoubleClickPinBtnTxt =
                view.findViewById<TextView>(R.id.BottomSheetDialogOnDoubleClickPinBtnTxt)
            if (Pin.equals("0")) {
                BottomSheetDialogOnDoubleClickPinBtnTxt.text = "Pin"
                BottomSheetDialogOnDoubleClickPinBtnIcon.setBackgroundResource(R.drawable.icon_pin)
            } else if (Pin.equals("1")) {
                BottomSheetDialogOnDoubleClickPinBtnTxt.text = "Unpin"
                BottomSheetDialogOnDoubleClickPinBtnIcon.setBackgroundResource(R.drawable.icon_unpin)
            }

            val BottomSheetDialogOnDoubleClickOpenBtn =
                view.findViewById<LinearLayout>(R.id.BottomSheetDialogOnDoubleClickOpenBtn)
            BottomSheetDialogOnDoubleClickOpenBtn.setOnClickListener {
                val intent = Intent(context, UpdateNotesActivity::class.java)
                intent.putExtra("SrNo", srNO)
                    .putExtra("Title", Title)
                    .putExtra("Notes", NOtes)
                    .putExtra("Img", Img)
                    .putExtra("BackColor", BackColor)
                    .putExtra("CreatedDate", CreatedDate)
                    .putExtra("UpdatedDate", UpdatedDate)
                    .putExtra("Pin", Pin)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                context.startActivity(intent)
                dialog.dismiss()
            }

            val BottomSheetDialogOnDoubleClickPinBtn =
                view.findViewById<LinearLayout>(R.id.BottomSheetDialogOnDoubleClickPinBtn)
            BottomSheetDialogOnDoubleClickPinBtn.setOnClickListener {
                noteClickPinInterface.OnPinClick(
                    allNotes.get(position),
                    srNO,
                    Title,
                    NOtes,
                    Img,
                    BackColor,
                    CreatedDate,
                    UpdatedDate,
                    Pin
                )
                dialog.dismiss()
            }

            val BottomSheetDialogOnDoubleClickShareBtn =
                view.findViewById<LinearLayout>(R.id.BottomSheetDialogOnDoubleClickShareBtn)
            BottomSheetDialogOnDoubleClickShareBtn.setOnClickListener {
                noteClickShareInterface.OnShareClick(
                    allNotes.get(position),
                    srNO,
                    Title,
                    NOtes,
                    Img,
                    BackColor,
                    CreatedDate,
                    UpdatedDate,
                    Pin
                )
                dialog.dismiss()
            }

            val BottomSheetDialogOnDoubleClickMakeACopyBtn =
                view.findViewById<LinearLayout>(R.id.BottomSheetDialogOnDoubleClickMakeACopyBtn)
            BottomSheetDialogOnDoubleClickMakeACopyBtn.setOnClickListener {
                noteClickMakeCopyInterface.OnCopyClick(
                    allNotes.get(position),
                    srNO,
                    Title,
                    NOtes,
                    Img,
                    BackColor,
                    CreatedDate,
                    UpdatedDate,
                    Pin
                )
                dialog.dismiss()
            }

            val BottomSheetDialogOnDoubleClickDeleteBtn =
                view.findViewById<LinearLayout>(R.id.BottomSheetDialogOnDoubleClickDeleteBtn)
            BottomSheetDialogOnDoubleClickDeleteBtn.setOnClickListener {
                noteClickDeleteInterface.OnDeleteClick(allNotes.get(position))
                dialog.dismiss()
            }

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
            true
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

interface NoteClickShareInterface {
    fun OnShareClick(
        note: Note,
        SrNo: String,
        Title: String,
        Notes: String,
        Img: String,
        BackColor: String,
        CreatedDate: String,
        UpdatedDate: String,
        Pin: String
    )
}

interface NoteClickMakeCopyInterface {
    fun OnCopyClick(
        note: Note,
        SrNo: String,
        Title: String,
        Notes: String,
        Img: String,
        BackColor: String,
        CreatedDate: String,
        UpdatedDate: String,
        Pin: String
    )
}

interface NoteClickDeleteInterface {
    fun OnDeleteClick(note: Note)
}

interface NoteClickPinInterface {
    fun OnPinClick(
        note: Note,
        SrNo: String,
        Title: String,
        Notes: String,
        Img: String,
        BackColor: String,
        CreatedDate: String,
        UpdatedDate: String,
        Pin: String
    )
}

