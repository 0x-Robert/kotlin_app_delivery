package com.test_esy.esyz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.test_esy.esyz2.Fragment.ListFragment.FragmentAdapter
import kotlinx.android.synthetic.main.activity_lecture.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class LectureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)


        val fragmentAdapter =
            FragmentAdapter(
                supportFragmentManager
            )
        list_viewpager.adapter = fragmentAdapter
        //렉처액티비티에 뷰페이저를 만들엇고 뷰페이저안에 프래그먼트어댑터를 연결해놓음 넘기면 넘어가는게 fragmentadapter부분임

        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("AI")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("CSS")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("HTML")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("ID")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JPG")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JS")))

        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if(p0 != null){
                    list_viewpager.currentItem = p0.position
                }

            }

        })

    }
    private fun createTabView(tabName : String) : View {

        //이함수의 역활은 탭레이아웃안에 커스텀탭들을 하나씩 넣어주는역활
        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custom_tab ,null )

        tabView.txt_name.text = tabName

        return tabView

    }



}
