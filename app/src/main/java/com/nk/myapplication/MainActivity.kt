package com.nk.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

   // lateinit var firebaseAuth : FirebaseAuth

//     fun anonymouseAuth(intent2: Intent) {
//        firebaseAuth.signInAnonymously()
//            .addOnSuccessListener {
//                startActivity(Intent(this,AddQuiz::class.java))
//            }
//            .addOnFailureListener {
//                Log.d("TAG", "AnnonymousAuth: $it")
//            }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRef = Firebase.database.reference
        val userId = "Quiz"
        //firebaseAuth = FirebaseAuth.getInstance()


        val startButton = findViewById<Button>(R.id.btn_start)
        val etname = findViewById<TextView>(R.id.et_name)
        startButton.setOnClickListener {

            if (etname.text.toString().isEmpty()) {

                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_SHORT)
                    .show()
            } else if ( etname.text.toString() == "Student") {

                val intent = Intent(this@MainActivity, QuizQuestionsActivity::class.java)
                startActivity(intent)

                finish()
            }
            else if   ( etname.text.toString() == "Admin") {
                //anonymouseAuth()
                val intent2 = Intent(this@MainActivity, AddQuiz::class.java)
                startActivity(intent2)

                finish()
            }
        }
    }

}

