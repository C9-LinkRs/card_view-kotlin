package com.example.myapplicationrw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationrw.data.User
import kotlinx.android.synthetic.main.row.view.*

class UserRecycledViewAdapter(private val mValue: List<User>, private val mListener : UserRecycledViewAdapter.onListInteractions) : RecyclerView.Adapter<UserRecycledViewAdapter.viewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserRecycledViewAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return mValue.size
    }

    override fun onBindViewHolder(holder: UserRecycledViewAdapter.viewHolder, position: Int) {
        val item = mValue[position]
        holder.textView.text = "Name: " + item.titulo + ' ' + item.nombre + ' ' + item.apellido
        holder.email_textView.text = "Email: " + item.email
        holder.phone_textView.text = "Phone: " + item.telefono

        holder.mView.setOnClickListener{
            mListener?.onListItemInteraction(item)
        }

        holder.card_view.setOnClickListener{
            mListener?.onListButtonInteraction(item)
        }
    }

    inner class viewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val card_view : CardView = mView.findViewById(R.id.card_view)
        val textView : TextView = card_view.card_view_tf
        val email_textView : TextView = card_view.card_view_email
        val phone_textView : TextView = card_view.card_view_phone
    }

    interface  onListInteractions {
        fun onListItemInteraction(item: User?)

        fun onListButtonInteraction(item: User?)
    }

    public fun updateData() {
        notifyDataSetChanged()
    }
}