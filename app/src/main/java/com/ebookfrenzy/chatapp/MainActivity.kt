package com.ebookfrenzy.chatapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.newInstance
import java.net.URLClassLoader.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = Firebase.auth

        //Signing in users
        button_login.setOnClickListener {
            auth.signInWithEmailAndPassword(
                username_login.text.toString(),
                password_login.text.toString()
            ).addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    // Sign in success, go to chat activity
                    Log.d("signIn", "signInWithEmail:success")
                    auth.currentUser
                    val intent = Intent(this, ChatActivity::class.java)
                    startActivity(intent)
                } else {
                    Log.w("signinError", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }

        }

        button_register.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                username_login.text.toString(),
                password_login.text.toString()
            ).addOnCompleteListener(this){ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("register", "createUserWithEmail:success")
                    auth.currentUser
                    val intent = Intent(this, ChatActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("registerError", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //checking to see user is currently signed in
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            // Do something
        }
    }


}