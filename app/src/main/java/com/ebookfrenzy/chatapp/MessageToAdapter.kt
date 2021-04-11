package com.ebookfrenzy.chatapp

import android.view.LayoutInflater
import android.widget.ImageView
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MessageToAdapter : RecyclerView.Adapter<MessageToAdapter.ViewHolder>() {

    private val messages = arrayOf("Hello", "Hello again", "Hello again again")

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val toMessage: TextView = view.findViewById(R.id.toMessage)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.to_chat, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.toMessage.text = messages[position]
    }

    override fun getItemCount() = messages.size
}