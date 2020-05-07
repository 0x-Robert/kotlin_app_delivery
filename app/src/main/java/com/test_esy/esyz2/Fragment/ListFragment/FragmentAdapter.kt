package com.test_esy.esyz2.Fragment.ListFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test_esy.esyz2.Fragment.ListFragment.FirstFragment
import com.test_esy.esyz2.Fragment.ListFragment.SecondFragment
import com.test_esy.esyz2.Fragment.ListFragment.ThirdFragment

class FragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {

            return when(position){
                0 -> {
                    FirstFragment()  //0번째일떄 FirstFragment 실행
                }
                1 -> {
                    SecondFragment() //1번째일때 SecondFragment 실행
                }
                else -> {
                     return ThirdFragment()
                }

            }
        }
    override fun getCount(): Int {
       return 3
    }


}