package edu.wccnet.jbower26.contactlistapp

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var contactId: Int = 0

    @ColumnInfo(name = "name")
    var contactName: String? = null

    @ColumnInfo(name = "phone")
    var contactPhone: String? = null

    constructor() {}

    constructor(id: Int, contactName: String, contactPhone: String) {
        this.contactId = id
        this.contactName = contactName
        this.contactPhone = contactPhone
    }

    constructor(contactName: String, contactPhone: String) {
        this.contactName = contactName
        this.contactPhone = contactPhone
    }
}