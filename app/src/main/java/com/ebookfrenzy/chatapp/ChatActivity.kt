package com.ebookfrenzy.chatapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.api.Distribution
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*
import java.text.FieldPosition

class ChatActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapterFrom: RecyclerView.Adapter<MessageFromAdapter.ViewHolder>? = null
    private var adapterTo: RecyclerView.Adapter<MessageToAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Access Cloud Firestore instance from Activity
        db = Firebase.firestore

        button_send_message.setOnClickListener {
            addMessage()
        }

        //setting the adapter
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapterFrom = MessageFromAdapter()
        recyclerView.adapter = adapterFrom
        adapterTo = MessageToAdapter()
        recyclerView.adapter = adapterTo

    }

    //Function to add data  -- not working properly
    private fun addMessage() {
        val text = Message(
                text = enter_message.text.toString()
        )
        Log.d("chat", "not working?")
        db.collection("messages")
                .add(text)
                .addOnSuccessListener { documentReference ->
                    Log.d("Chat", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e -> Log.w("Error", "Error adding message", e) }
    }
}


