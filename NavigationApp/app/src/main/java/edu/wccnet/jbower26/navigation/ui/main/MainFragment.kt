package edu.wccnet.jbower26.navigation.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import edu.wccnet.jbower26.navigation.R
import edu.wccnet.jbower26.navigation.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.image1button.setOnClickListener {

            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            //action.title = "test pass arg"
            action.title = binding.imageView1.contentDescription.toString()
            action.image = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)
        }
        binding.image2button.setOnClickListener {

            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.title = binding.imageView2.contentDescription.toString()
            action.image = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)
        }
        binding.image3button.setOnClickListener {

            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.title = binding.imageView3.contentDescription.toString()
            action.image = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}