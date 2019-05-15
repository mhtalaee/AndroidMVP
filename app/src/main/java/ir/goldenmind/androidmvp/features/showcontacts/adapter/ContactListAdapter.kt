package ir.goldenmind.androidmvp.features.showcontacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.pojo.Contact
import kotlinx.android.synthetic.main.contact_recyclerview_item.view.*

class ContactListAdapter(contactList: ArrayList<Contact>, val clickHandler: (strName: String) -> Unit) :
    RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {

    val contactList = contactList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_recyclerview_item, parent, false)
        val viewHoler = ContactViewHolder(v)
        return viewHoler
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindItems(contactList[position], clickHandler)
    }

    override fun getItemCount() = contactList.size

    class ContactViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        fun bindItems(contact: Contact, onItemClickHandler: (strName: String) -> Unit) {

            v.tvFullName.text = contact.firstName + " " + contact.lastName
            v.tvPhone.text = contact.cellPhone

            v.setOnClickListener {
                onItemClickHandler(contact.firstName.toString())
            }
        }
    }

    fun removeItem(position: Int) {
        contactList.removeAt(position)
        notifyItemRemoved(position);
    }

    fun restoreItem(item: Contact, position: Int) {
        contactList.add(position, item);
        notifyItemInserted(position);
    }

}