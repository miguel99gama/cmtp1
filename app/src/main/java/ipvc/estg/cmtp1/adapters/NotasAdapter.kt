package ipvc.estg.cmtp1.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.cmtp1.R
import ipvc.estg.cmtp1.addNota
import ipvc.estg.cmtp1.entities.Notas
import ipvc.estg.cmtp1.notaEdit


class NotasAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<NotasAdapter.NotasViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notes = emptyList<Notas>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return NotasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        val current = notes[position]
        holder.titleItemView.text = current.title
        holder.descItemView.text = current.desc
        holder.idItemView.text = current.id.toString()
    }
    class NotasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleItemView: TextView = itemView.findViewById(R.id.title)
        val descItemView: TextView = itemView.findViewById(R.id.desc)
        val idItemView: TextView = itemView.findViewById(R.id.id)


        init{
            itemView.setOnClickListener{v: View ->

                val id= idItemView.text
                val titulo=titleItemView.text
                val desc=descItemView.text


                val intent = Intent(itemView.context, notaEdit::class.java)
                intent.putExtra("ID", id)
                intent.putExtra("TITULO", titulo)
                intent.putExtra("DESC", desc)

                itemView.context.startActivity(intent)
            }

        }


    }

    internal fun setNotas(notes: List<Notas>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun getItemCount() = notes.size
}
