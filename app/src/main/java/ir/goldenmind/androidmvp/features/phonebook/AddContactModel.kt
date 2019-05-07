package ir.goldenmind.androidmvp.features.phonebook

import ir.goldenmind.androidmvp.base.BaseApplication
import ir.goldenmind.androidmvp.pojo.Contact
import ir.goldenmind.androidmvp.repository.db.OpenDBHelper

class AddContactModel(val presenter: Contract.Presenter) {

    fun saveContact(contact: Contact): Boolean {
        val db = OpenDBHelper(BaseApplication.context, "MyDB", null, 1)
        val successInsert = db.insertContact(contact)
        return successInsert
    }

}