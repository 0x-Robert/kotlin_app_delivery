package com.test_esy.esyz2.Fragment.MarketInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.RatingBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.test_esy.esyz2.MainActivity
import com.test_esy.esyz2.R
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {


    private lateinit var rating_num :  String



    private lateinit var auth: FirebaseAuth
    private lateinit var nickname: String

    private val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)


        auth = FirebaseAuth.getInstance()

        //rating
        rating_area.setOnRatingBarChangeListener { ratingBar, fl, b ->
            rating_num = fl.toString()

        }


        //닉네임 받아오기

        val docRef =db.collection("users").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener { documentSnapshot ->
            //닉네임에 넣어줌
            nickname = documentSnapshot.get("nickname") as String

        }



        //writing 버튼을 눌렀을때 데이터베이스에 저장되는 부분 처리
        writing_button.setOnClickListener{


            val form = hashMapOf(
                "text" to text_input_area.text.toString(),
                "writer" to nickname,
                "rating" to rating_num
            //댓글 입력하는 부분


            )

            db.collection( "reviews")
                .add(form)
                .addOnSuccessListener { Toast.makeText( this, "성공", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    finish()

                }
                .addOnFailureListener{Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()}
        }

    }
}
