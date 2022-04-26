package edu.wccnet.jbower26.contactlistapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.wccnet.jbower26.contactlistapp.Contact
import edu.wccnet.jbower26.contactlistapp.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val allContactsAsc: LiveData<List<Contact>>?
    private val allContactsDesc: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    private var display: LiveData<List<Contact>>?

    init {
        allContacts = repository.allContacts
        allContactsAsc = repository.allContactsAsc
        allContactsDesc = repository.allContactsDesc
        searchResults = repository.searchResults

        display = allContacts
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
        display = allContacts
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return display
    }

    fun getAllContactsAsc() {
        display = allContactsAsc
    }

    fun getAllContactsDesc() {
        display = allContactsDesc
    }

}