package edu.wccnet.jbower26.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wccnet.jbower26.R
import edu.wccnet.jbower26.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.displayNames.text = viewModel.returnNames()

        binding.addNameButton.setOnClickListener {
            if (binding.editTextName.text.isNotEmpty()) {
                viewModel.addName(binding.editTextName.text.toString())
                binding.displayNames.text = viewModel.returnNames()
            } else {
                binding.displayNames.text = getString(R.string.noNamesToDisplay)
            }
        }

        binding.addNameButton.setOnLongClickListener {
            false
        }

    }

}