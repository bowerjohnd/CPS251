package edu.wccnet.jbower26.contactlistapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import edu.wccnet.jbower26.contactlistapp.Contact
import edu.wccnet.jbower26.contactlistapp.R
import edu.wccnet.jbower26.contactlistapp.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
        var toastMessage = ""
    }

    val viewModel: MainViewModel by viewModels()
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

        listenerSetup()
        obvserverSetup()
        recyclerSetup()

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener {
            override fun onClick(id: String) {
                var contactId: Int = parseInt(id)
                viewModel.deleteContact(contactId)
                Toast.makeText(context, toastMessage,Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val phone = binding.contactPhone.text.toString()

            if (name != "") {
                if (phone != "") {
                    val contact = Contact(name, phone)
                    viewModel.insertContact(contact)
                    toastMessage = "Contact Added"
                    clearFields()
                } else {
                    toastMessage = "***** Phone Number is Required *****"
                }
            } else {
                toastMessage = "***** Name is Required *****"
            }

            Toast.makeText(context, toastMessage,Toast.LENGTH_LONG).show()
        }

        binding.findButton.setOnClickListener {
            if (binding.contactName.text.toString() != "") {
                viewModel.findContact(binding.contactName.text.toString())
                clearFields()
            } else {
                toastMessage = "You must enter a search criteria in the name field."
                Toast.makeText(context, toastMessage,Toast.LENGTH_LONG).show()
                clearFields()
            }
        }

        binding.ascButton.setOnClickListener {
            viewModel.getAllContactsAsc()
            viewModel.getAllContacts()?.observe( viewLifecycleOwner) { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            }
            clearFields()
        }

        binding.descButton.setOnClickListener {
            viewModel.getAllContactsDesc()
            viewModel.getAllContacts()?.observe( viewLifecycleOwner) { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            }
            clearFields()
        }
    }

    private fun obvserverSetup() {

        viewModel.getAllContacts()?.observe( viewLifecycleOwner) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.getSearchResults().observe(viewLifecycleOwner) { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                    toastMessage = "Showing Results."
                    Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()

                } else {
                    toastMessage = "No Matches Found."
                    Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }
}