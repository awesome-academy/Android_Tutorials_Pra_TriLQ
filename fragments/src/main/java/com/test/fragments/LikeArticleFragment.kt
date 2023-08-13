package com.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.fragments.databinding.FragmentLikeArticleBinding

class LikeArticleFragment : Fragment() {
    private val binding: FragmentLikeArticleBinding by lazy {
        FragmentLikeArticleBinding.inflate(layoutInflater)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding.btnYes.setOnClickListener{
            binding.fragmentText.text = getString(R.string.article_like)
        }

        binding.btnNo.setOnClickListener{
            binding.fragmentText.text = getString(R.string.article_thanks)
        }

        return binding.root
    }
}
