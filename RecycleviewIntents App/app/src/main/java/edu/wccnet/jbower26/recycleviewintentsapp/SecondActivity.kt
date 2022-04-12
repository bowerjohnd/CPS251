package edu.wccnet.jbower26.recycleviewintentsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import edu.wccnet.jbower26.recycleviewintentsapp.databinding.SecondActivityBinding
import edu.wccnet.jbower26.recycleviewintentsapp.ui.main.MainViewModel

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val titleString = extras.getString("title")
        val detailString = extras.getString("detail")
        val imageInt = extras.getInt("image")

        binding.textView.text = titleString
        binding.textView2.text = detailString
        binding.imageView.setImageResource(MainViewModel.images[imageInt])
    }
}