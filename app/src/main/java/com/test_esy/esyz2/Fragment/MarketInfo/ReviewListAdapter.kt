package com.test_esy.esyz2.Fragment.MarketInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.test_esy.esyz2.R
import kotlinx.android.synthetic.main.review_item.view.*

class ReviewListAdapter(val context: Context,
                        val list_nickname : ArrayList<String>,
                        val list_text: ArrayList<String>,
                        val list_rating : ArrayList<String>) : BaseAdapter(){

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.review_item,null)

        view.review_nickname.text = list_nickname.get(p0)
        view.review_content.text = list_text.get(p0)
        view.review_rating.text = list_rating.get(p0)

        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list_nickname.size
    }

//어댑터로 넘어온 값들을 뷰에 넣어주는 작업임

}

