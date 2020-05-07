package com.test_esy.esyz2.Fragment.ListFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.test_esy.esyz2.R

class FirstFragAdapter(val context : Context, val list : ArrayList<ContentsListModel> ): BaseAdapter(){
    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {

        val view : View
        val holder : ViewHolder
        if ( converView == null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

            holder =
                ViewHolder()

            holder.view_image1 = view.findViewById(R.id.lv_image_area)     //이미지뷰 담는부분
            holder.view_text1 = view.findViewById(R.id.lv_textview_1)     //텍스트뷰 담는 부분
            holder.view_text2 = view.findViewById(R.id.lv_textview_2)     //텍스트뷰 담는 부분
            holder.view_text3 = view.findViewById(R.id.lv_textview_3)     //텍스트뷰 담는 부분

            view.tag =holder
        }
        else {
            holder = converView.tag as ViewHolder
            view = converView

        }

        var item = list[position]
        holder.view_image1?.setImageResource(item.image) //holder ui에서뿌려주는 역활 수행
        holder.view_text1?.text = item.title



        holder.view_text1?.text   = item.title   //코틀린은 null을 허용하지 않기때문에 변수뒤에 ?을 두면 허용을 해준다
        return view


    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }


    private class ViewHolder{
        //뷰를 담는 홀더만듬
        var view_image1 : ImageView? = null
        var view_text1 : TextView? = null
        var view_text2 : TextView? = null
        var view_text3 : TextView? = null
    }
}