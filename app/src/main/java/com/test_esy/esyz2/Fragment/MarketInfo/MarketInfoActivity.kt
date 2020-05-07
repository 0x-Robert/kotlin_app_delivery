package com.test_esy.esyz2.Fragment.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.test_esy.esyz2.R
import com.test_esy.esyz2.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.activity_market_info.*

class MarketInfoActivity : AppCompatActivity() {

    private var auth  = FirebaseAuth.getInstance()
    private val db =  FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)
            //fragmentLayout 만들고 수정한 파일 MarketInfoActivity,activity_market_info.xml, styles.xml,FirstFragment.kt

        lecture_text.text = intent.getStringExtra("title")



//        val lecture = hashMapOf(           //set(lecture) > update(lecture)로 바뀌면서 필요없어짐
//            "lecture_title" to intent.getStringExtra("title")
//
//        )

        //찜 여부 확인
        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.get(intent.getStringExtra("title")) == true)
                    header_zzim.text = "하트뿅뿅 찜 되었습니다."
                    header_zzim.setTextColor(Color.BLUE)
            }
            .addOnFailureListener{}

        zzim.setOnClickListener{
            //이미 찜 되어있을 때

            if(header_zzim.text.equals("하트뿅뿅 찜 되었습니다.")){

                header_zzim.text = "하트뿅뿅 찜"
                header_zzim.setTextColor(Color.RED)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title"), "")
                    .addOnSuccessListener {
                        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                    }


            }
            else{

                // 이미 찜 되어 있지 않을 떄

                header_zzim.text = "하트뿅뿅 찜 되었습니다."
                header_zzim.setTextColor(Color.BLUE)


                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title"), true)
                    .addOnSuccessListener {
                        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                    }
            }



        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_area, ContentFragment())          //맨처음에 아무것도 안나온것처럼 보이니 대타로 갖다놓음
            .commit()


        figure_1.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, ContentFragment())          //figure_1을 누르면 콘텐츠프레그먼트에 있는것이 실행됨
                .commit()
        }

        figure_2.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)


            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, InfoFragment())          //figure_2을 누르면  인포프레그먼트에 있는것이 실행됨
                .commit()
        }


        figure_3.setOnClickListener{
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25F)


            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, ReviewFragment())          //figure_3을 누르면 리뷰프레그먼트에 있는것이 실행됨
                .commit()
        }

    }
}
