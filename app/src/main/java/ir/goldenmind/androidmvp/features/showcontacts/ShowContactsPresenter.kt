package ir.goldenmind.androidmvp.features.showcontacts

import ir.goldenmind.androidmvp.pojo.Contact

class ShowContactsPresenter(private val view: Contract.View) : Contract.Presenter {

    private val model = ShowContactsModel(this)

    fun onShowContactsList() {
        model.fetchContactList()
    }

    override fun contactListFetched(list: ArrayList<Contact>) {
        view.showContactList(list)
    }
}