package com.test_esy.esyz2

import Auth.LoginActivity
import Auth.MyCominActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.FirebaseAuth
import com.test_esy.esyz2.Zzim.ZzimActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewpager: ViewPager


    private lateinit var auth: FirebaseAuth// ...
    // Initialize Firebase Auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()


        val img = arrayOf(
            R.drawable.ai,
            R.drawable.css,
            R.drawable.html,
            R.drawable.id,
            R.drawable.jpg,
            R.drawable.js,
            R.drawable.mp4,
            R.drawable.pdf,
            R.drawable.php,
            R.drawable.png,
            R.drawable.psd,
            R.drawable.tiff
            )

        val text =arrayOf(
            "ai",
            "css",
            "html",
            "id",
            "jpg",
            "js",
            "mp4",
            "pdf",
            "php",
            "png",
            "psd",
            "tiff"
            )
        val gridviewAdapter = GridviewAdapter (  this, img, text) //gridviewAdapter 로 넘겨줌


        gridview.adapter = gridviewAdapter

        
        gridview.setOnItemClickListener { adapterView, view, i, l->

            val intent = Intent(this, LectureActivity::class.java)    //메인 액티비티에서 LectureActivity 클래스로 넘겨주는 인텐트 생성 전체화면에서 각각의 프래그먼트를 뿌려서 이동시켜줌
            startActivity(intent)
        }

        viewpager = findViewById(R.id.viewpager) as ViewPager

        val adapter = ViewPagerAdapter(  this)
        viewpager.adapter = adapter


        //bottom.xml zzim_icon 아이디값 넣고 mainActivity에서 작동하도록 넣어줌

        zzim_icon.setOnClickListener{
            val intent = Intent(this, ZzimActivity::class.java)
            startActivity(intent)
        }

        my_page.setOnClickListener {


            if (auth.currentUser ==null){
                val  intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this,MyCominActivity::class.java)
                startActivity(intent)
            }

        }
       

    }
}