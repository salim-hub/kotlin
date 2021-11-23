package com.example.firebaseloginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.firebaseloginsignup.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth


class SignUpActivity : AppCompatActivity() {
    // View Binding
    private lateinit var binding: ActivitySignUpBinding

    // Action Bar
    private lateinit var actionBar: ActionBar

    // FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // configure actionbar, enable back button
        actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        // init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        // handle click, begin register
        binding.signUpBtn.setOnClickListener {
            // validate data
            validateData()
        }
    }

    // When a new user signs up using your app's sign-up form, complete any new account validation
    // steps that your app requires, such as verifying that the new account's password was correctly
    // typed and meets your complexity requirements.
    private fun validateData() {
        // get data
        email = binding.emailEtS.text.toString().trim()
        password = binding.passwordEtS.toString().trim()
        // validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // invalid email format
            binding.emailEtS.error = "Invalid Format"
        }
        else if (TextUtils.isEmpty(password)) {
            binding.passwordEtS.error = "Please enter password"
        }
        else if (password.length < 6) {
            //password length is less than 6
            binding.passwordEtS.error = "Password must at least 6 character"
        }
        else{
            //data is valid, continue signup
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        // create account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                // signup success
                // get current user
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Account Created with email $email", Toast.LENGTH_SHORT).show()
                // open profile
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener { e->
                Toast.makeText(this, "SignUp Failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // go back to previous activity, when back button of actionbar clicked
        return super.onSupportNavigateUp()
    }
}