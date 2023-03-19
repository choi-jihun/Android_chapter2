package com.example.chapter3_10

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chapter3_10.data.ArticleModel
import com.example.chapter3_10.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding : FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val db = Firebase.firestore

        db.collection("articles").document("rzjK6i9N8MuRlY9Few9W").get().addOnSuccessListener {result->
            val article = result.toObject<ArticleModel>()
            Log.e("homeFragment",article.toString())
        }.addOnFailureListener {
            it.printStackTrace()
        }
        
        setUpWriteButton(view)
    }

    private fun setUpWriteButton(view: View) {
        binding.writeButton.setOnClickListener {
            if(Firebase.auth.currentUser != null) {
                val action = HomeFragmentDirections.actionHomeFragmentToWriteArticleFragment()
                findNavController().navigate(action)
            } else {
                Snackbar.make(view, "로그인 후 사용해주세요",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}