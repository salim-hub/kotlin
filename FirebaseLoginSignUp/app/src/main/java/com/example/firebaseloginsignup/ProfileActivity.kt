package com.example.firebaseloginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.firebaseloginsignup.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    // viewBinding
    private lateinit var binding : ActivityProfileBinding

    //Action Bar
    private lateinit var actionBar: ActionBar

    // FirebaseAuth
    // private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // configure action bar
        actionBar = supportActionBar!!
        actionBar.title = "Profile"

        // init firebase auth
        // firebaseAuth = FirebaseAuth.getInstance()
        auth = Firebase.auth

        checkUser()

        //handle click logout
        binding.logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            checkUser()
        }
    }

    private fun checkUser() {
        //check user is logged in or not
        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            // user not null, user is logged in, get user info
            val email = firebaseUser.email
            // set to text view
            binding.emailTV.text = email
        }
        else{
            //user is null, user is not logged in, go to loginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}