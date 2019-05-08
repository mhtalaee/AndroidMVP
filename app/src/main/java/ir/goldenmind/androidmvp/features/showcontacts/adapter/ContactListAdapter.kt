package ir.goldenmind.androidmvp.features.showcontacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.pojo.Contact
import kotlinx.android.synthetic.main.contact_recyclerview_item.view.*

class ContactListAdapter(contactList: List<Contact>) :
    RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>() {

    val contactList = contactList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.contact_recyclerview_item, parent, false)
        val viewHoler = ContactViewHolder(v)
        return viewHoler
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindItems(contactList[position])
    }

    override fun getItemCount() = contactList.size

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(contact: Contact) {
            val tvFullName = itemView.tvFullName
            val tvCellPhone = itemView.tvPhone

            tvFullName.text = contact.firstName
            tvCellPhone.text = contact.cellPhone
        }

    }


}