package com.test_esy.esyz2.Fragment.MarketInfo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.test_esy.esyz2.R
import kotlinx.android.synthetic.main.fragment_content.view.*

/**
 * A simple [Fragment] subclass.
 */
class ContentFragment : Fragment() {

    val list1 = ArrayList<String>()
    val list2 = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_content, container, false)



        list1.add("a") //임시로 만들어줌
        list1.add("a")
        list1.add("a")

        list2.add("b")
        list2.add("b")
        list2.add("b")

        val list_adapter = ListAdapter(requireContext(), list1,list2)  //리스트 어댑터 만듬
        view.content_listview.adapter = list_adapter

        return view


    }


}
