package com.ebookfrenzy.chatapp

import android.view.LayoutInflater
import android.widget.ImageView
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MessageFromAdapter : RecyclerView.Adapter<MessageFromAdapter.ViewHolder>() {

    private val messages = arrayOf("Hello", "Hello again", "Hello again again")

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fromMessage: TextView = view.findViewById(R.id.fromMessage)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.from_chat, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.fromMessage.text = messages[position]
    }

    override fun getItemCount() = messages.size
}