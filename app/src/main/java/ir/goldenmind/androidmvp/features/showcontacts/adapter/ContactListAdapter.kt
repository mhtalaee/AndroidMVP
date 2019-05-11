package ir.goldenmind.androidmvp.features.showcontacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.features.showcontacts.ClickHandler
import ir.goldenmind.androidmvp.pojo.Contact
import kotlinx.android.synthetic.main.contact_recyclerview_item.view.*

class ContactListAdapter(contactList: List<Contact>, clickHandler: ClickHandler) :
    RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {

    val contactList = contactList
    val clickHandler = clickHandler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_recyclerview_item, parent, false)
        val viewHoler = ContactViewHolder(v, clickHandler)
        return viewHoler
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindItems(contactList[position])
    }

    override fun getItemCount() = contactList.size

    class ContactViewHolder(val v: View, val clickHandler: ClickHandler) : RecyclerView.ViewHolder(v) {

        fun bindItems(contact: Contact) {

            v.tvFullName.text = contact.firstName
            v.tvPhone.text = contact.cellPhone

            v.setOnClickListener {
                clickHandler.onClick(it)
            }

        }

    }


    fun removeItem(position: Int) {
        notifyItemRemoved(position)
    }


}