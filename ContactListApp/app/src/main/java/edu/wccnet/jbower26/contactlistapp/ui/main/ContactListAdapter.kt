package edu.wccnet.jbower26.contactlistapp.ui.main

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.jbower26.contactlistapp.Contact
import edu.wccnet.jbower26.contactlistapp.R

class ContactListAdapter(private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    private var listener: onItemClickListener? = null

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        val itemID = contactList!![i].contactId.toString()
        viewHolder.itemName.text = contactList!![i].contactName
        viewHolder.itemPhone.text = contactList!![i].contactPhone

        viewHolder.itemImage.setOnClickListener(View.OnClickListener{
            MainFragment.toastMessage = "Delete Contact $itemID"
            listener?.onClick(itemID)
        })
    }

    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }

    interface onItemClickListener {
        fun onClick(str: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemPhone: TextView
        var itemImage: ImageView

        init {
            itemName = itemView.findViewById(R.id.contactName)
            itemPhone = itemView.findViewById(R.id.contactPhone)
            itemImage = itemView.findViewById(R.id.deleteImage)

        }

    }

}