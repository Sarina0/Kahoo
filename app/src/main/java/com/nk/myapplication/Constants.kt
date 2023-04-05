package com.nk.myapplication


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
object Constants {

    val myRef = Firebase.database.reference
    val userId = "Firebase123"
    val userId2 = "Quiz"
    val myRef2 = Firebase.database.getReferenceFromUrl("https://kahoosqldatabase-default-rtdb.firebaseio.com/")
    //    private fun <E> ArrayList<E>.add(element: QuizData) {
//
//    }
    fun getQuestions(): ArrayList<QuizData> {
        val questionsList = ArrayList<QuizData>()
        //val questionList2 = ArrayList<QuizData>()

//
//        myRef2.child("Quiz").get().addOnSuccessListener {
//
//            if(it.exists()){
//
//                val id = it.child("id").value
//                val option1 = it.child("optionOne").value
//                val id2 = id.toString()
//                val question = it.child("question").value.toString()
//
//                val que2 = QuizData(44, question,
//                    R.drawable.ic_flag_of_australia,
//                    option1.toString(), "Austria",
//                    "Australia", "Armenia", 3
//                )
//
//                questionsList.add(que2)
//
//
//            }else{
//                //Toast.makeText(this,"data does not exist", Toast.LENGTH_SHORT).show();
//            }
//        }.addOnFailureListener{
//
//            // Toast.makeText(this, "Failed", Toast.LENGHT_SHORT.show()
//
//        }










//        myRef.child("Quiz").get().addOnSuccessListener {
//
//            if(it.exists()){
//                for (item in it.children) {
//                    val id = item.child("id").value
//                    val option1 = item.child("optionOne").value
//                    val id2 = id.toString()
//                    val question = item.child("question").value.toString()
//
//
//                    val que2 = QuizData(
//                        44, question,
//                        R.drawable.ic_flag_of_australia,
//                        option1.toString(), "Austria",
//                        "Australia", "Armenia", 3
//                    )
//
//                    questionsList.add(que2)
//
//                }
//            }else{
//                //Toast.makeText(this,"data does not exist", Toast.LENGTH_SHORT).show();
//            }
//        }.addOnFailureListener{
//
//            // Toast.makeText(this, "Failed", Toast.LENGHT_SHORT.show()
//
//        }






        val database = Firebase.database
        val reflatitude = database.getReference("Quiz")
        reflatitude.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot){
                //DataSnapshot child: snapshot.getChildren()
                if (snapshot.exists()) {
                    for (item in snapshot.children) {

//                        val getId = snapshot.child("id").getValue(String.javaClass).toString()
//                        val getQuestion =
//                            snapshot.child("question").getValue(String.javaClass).toString()
//                        val getOption1 =
//                            snapshot.child("optionOne").getValue(String.javaClass).toString()
//                        val getOption2 =
//                            snapshot.child("optionTwo").getValue(String.javaClass).toString()
//                        val getOption3 =
//                            snapshot.child("optionThree").getValue(String.javaClass).toString()
//                        val getOption4 =
//                            snapshot.child("optionFour").getValue(String.javaClass).toString()
//                        val getImage = snapshot.child("image").getValue(String.javaClass).toString()
//                        val getAnswer =
//                            snapshot.child("correctAnswer").getValue(String.javaClass).toString()


                        val getId = item.child("id").value
                        val getQuestion =
                            item.child("question").value.toString()
                        val getOption1 =
                            item.child("optionOne").value.toString()
                        val getOption2 =
                            item.child("optionTwo").value.toString()
                        val getOption3 =
                            item.child("optionThree").value.toString()
                        val getOption4 =
                            item.child("optionFour").value.toString()
                        val getImage = item.child("image").value.toString()
                        val getAnswer =
                            item.child("correctAnswer").value.toString()
                        val que = QuizData(
                            33,
                            getQuestion,
                            R.drawable.anonymous_pic,
                            getOption1,
                            getOption2,
                            getOption3,
                            getOption4,
                            getAnswer.toInt()
                        )
                        questionsList.add(que)

                    }
                }

            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })



        // 10
        val que10 = QuizData(
            10, "What is the greatest fear of programmers?",
            R.drawable.anonymous_pic,
            "NO Fear!", "Dark web",
            "Forget to save", "wrong commit", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}


