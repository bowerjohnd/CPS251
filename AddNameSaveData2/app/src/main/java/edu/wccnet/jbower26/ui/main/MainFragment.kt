package edu.wccnet.jbower26.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import edu.wccnet.jbower26.R
import edu.wccnet.jbower26.BR.myViewModel
import edu.wccnet.jbower26.databinding.MainFragmentBinding


class MainFragment : Fragment() {

//    private var _binding: MainFragmentBinding? = null
//    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
 //       _binding = MainFragmentBinding.inflate(inflater, container, false)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false)

        binding.lifecycleOwner = this
        return binding.root
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.setVariable(myViewModel, viewModel)

        if (viewModel.nameList.isEmpty()) {
            viewModel.nameString.value = getString(R.string.noNamesToDisplay)
        }
/*
        binding.addNameButton.setOnClickListener {
            if (binding.editTextName.text.isNotEmpty()) {
                viewModel.addName(binding.editTextName.text.toString())
                binding.displayNames.text = viewModel.returnNames()
            } else {
                //Do nothing if edit field is empty
            }
        }

        binding.addNameButton.setOnLongClickListener {
            false
        }
*/
    }

}