package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.lifecycledemo.R
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.lifecycledemo.BR.myViewModel

import com.ebookfrenzy.lifecycledemo.DemoObserver
import com.ebookfrenzy.lifecycledemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)

        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)

        lifecycle.addObserver(DemoObserver())

        viewModel.displayString.value = ""
        viewModel.addToDisplayString("onCreate")
        viewModel.addToDisplayString("onStart")
        viewModel.addToDisplayString("onResume")
    }

}