package com.test_esy.esyz2.Fragment.ListFragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test_esy.esyz2.Fragment.MarketInfo.MarketInfoActivity
import com.test_esy.esyz2.R
import com.test_esy.esyz2.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentsListModel>(       //상수로 정의하고 Contentslistmodel은 아래와 같이 진행 인자로 받은 elements를 요소로하는 ArrayList를 반환한다.


            ContentsListModel(R.drawable.list1, "Lang1", 1, "d"), //리스트뷰에 들어갈 내용
            ContentsListModel(R.drawable.list2, "Lang2", 1, "d"),
            ContentsListModel(R.drawable.list3, "Lang3", 1, "d"),
            ContentsListModel(R.drawable.list4, "Lang4", 1, "d"),
            ContentsListModel(R.drawable.list5, "Lang5", 1, "d"),
            ContentsListModel(R.drawable.list6, "Lang6", 1, "d"),
            ContentsListModel(R.drawable.list7, "Lang7", 1, "d"),
            ContentsListModel(R.drawable.list8, "Lang8", 1, "d"),
            ContentsListModel(R.drawable.list9, "Lang9", 1, "d")


        )


        val list_adapter =
            FirstFragAdapter(
                requireContext(),
                list_array
            ) //fragment_xml에 리스트뷰 구현후 FirstAdapter와 연결


        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->

                if (documentSnapshot.exists() == true)
                { //Data필드가 있을때


                }
                else {
                    //Data필드가 없을때
                    val lecture = hashMapOf(
                        "Lang1" to "",
                        "Lang2" to "",
                        "Lang3" to "",
                        "Lang4" to "",
                        "Lang5" to "",
                        "Lang6" to "",
                        "Lang7" to "",
                        "Lang8" to "",
                        "Lang9" to ""

                    )
                    FirebaseUtils.db
                        .collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .set(lecture)
                        .addOnSuccessListener {

                        }
                        .addOnFailureListener{

                        }
                }

            }
            .addOnFailureListener{

            }



        view.listview_first_fragment.adapter = list_adapter

        view.listview_first_fragment.setOnItemClickListener{ adapterView, view , i , l ->
        val intent = Intent(requireContext(), MarketInfoActivity::class.java) // 리스트뷰에서 퍼스트프래그먼트 클릭시 연동되게끔 셋팅 함 인텐트를 통해 이동하도록 만들어줌
            intent.putExtra("title", list_array.get(i).title) //lang1 의 메뉴가 실제로 firstFragment와 연결되도록
            startActivity(intent)
        }


        return view
    }


}
