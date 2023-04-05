package com.nk.myapplication
import com.google.firebase.database.Exclude
data class QuizData(val id: Int = 0, val question: String? = "", val image: Int  =0,
                    val optionOne: String? = "", val optionTwo: String? ="", val optionThree: String? ="",

                    val optionFour: String? ="", val correctAnswer: Int = 0



){
    @Exclude
    fun getMap(): Map<String, Any?>{
        return mapOf(
            "id" to id

        )
    }



}



