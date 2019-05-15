package ir.goldenmind.androidmvp.features.showcontacts

import ir.goldenmind.androidmvp.pojo.Contact

interface Contract {

    interface View {
        fun showContactList(list: ArrayList<Contact>)
        fun showToastMessage(message: String, duration: Int)
        fun refreshRecyclerView()
    }

    interface Presenter {
        fun contactListFetched(list: ArrayList<Contact>)
        fun onContactDeleted(successfulDelete: Boolean)
        fun onRecyclerSwip(position: Int?)
    }
}