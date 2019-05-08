package ir.goldenmind.androidmvp.features.showcontacts

import ir.goldenmind.androidmvp.pojo.Contact

interface Contract {

    interface View{
        fun showContactList(list: ArrayList<Contact>)
    }

    interface Presenter{
        fun contactListFetched(list : ArrayList<Contact>)
    }
}