package com.test_esy.esyz2.Utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseUtils{


    companion object {
        private var auth = FirebaseAuth.getInstance()
        var db = FirebaseFirestore.getInstance()

        fun getUid() :  String {
            return auth.currentUser?.uid.toString()  //firebase반복사용에 대한 클래스 생성     FirebaseUtils.getUid()  , FirebaseUtils.db 사용

        }

    }
}