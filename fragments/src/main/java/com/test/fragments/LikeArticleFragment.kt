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
    private var yesIsChecked: Boolean = false
    private var noIsChecked: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (yesIsChecked){
            binding.radioBtnYes.isChecked = yesIsChecked
            binding.fragmentText.text = getString(R.string.article_like)
        }
        if (noIsChecked){
            binding.radioBtnNo.isChecked = noIsChecked
            binding.fragmentText.text = getString(R.string.article_thanks)
        }

        binding.radioBtnYes.setOnClickListener{
            binding.fragmentText.text = getString(R.string.article_like)
            yesIsChecked = true
            noIsChecked = false
        }
        binding.radioBtnNo.setOnClickListener{
            binding.fragmentText.text = getString(R.string.article_thanks)
            yesIsChecked = false
            noIsChecked = true
        }

        return binding.root
    }
    fun getRadioData(): BooleanArray{
        return booleanArrayOf(yesIsChecked, noIsChecked)
    }
    companion object{
        fun newInstance(radioData: BooleanArray): LikeArticleFragment{
            val fragment = LikeArticleFragment()
            fragment.yesIsChecked = radioData[0]
            fragment.noIsChecked = radioData[1]
            return fragment
        }
    }
}
