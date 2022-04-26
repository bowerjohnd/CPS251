package edu.wccnet.jbower26.contactlistapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE name LIKE '%' || :name || '%'")
    fun searchContacts(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE id = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAllContactsAsc(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY name DESC")
    fun getAllContactsDesc(): LiveData<List<Contact>>

}