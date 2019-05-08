package ir.goldenmind.androidmvp.features.showcontacts

import ir.goldenmind.androidmvp.base.BaseApplication
import ir.goldenmind.androidmvp.pojo.Contact
import ir.goldenmind.androidmvp.repository.db.OpenDBHelper

class ShowContactsModel(private val presenter : Contract.Presenter){

    fun fetchContactList() {
        val db = OpenDBHelper(BaseApplication.context, "MyDB", null, 1)
        val list = db.fetchContacts()
        presenter.contactListFetched(list)
    }

}