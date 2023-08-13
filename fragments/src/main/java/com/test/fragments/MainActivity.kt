package com.test.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var pressed: Boolean = false
    private var radioData: BooleanArray = BooleanArray(2){false}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.title_main_activity)

        binding.btnOpenCloseFragment.setOnClickListener{
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            if (pressed){
                pressed = false
                binding.btnOpenCloseFragment.text = getText(R.string.btn_text_open)
                val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as? LikeArticleFragment
                if (fragment != null) {
                    radioData = fragment.getRadioData()
                    fragmentTransaction.remove(fragment)
                }
            } else {
                pressed = true
                binding.btnOpenCloseFragment.text = getText(R.string.btn_text_close)
                fragmentTransaction.add(R.id.fragment_container_view, LikeArticleFragment.newInstance(radioData))
            }

            fragmentTransaction.commit()
        }
    }
}
