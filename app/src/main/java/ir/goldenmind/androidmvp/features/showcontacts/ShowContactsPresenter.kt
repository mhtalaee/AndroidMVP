package ir.goldenmind.androidmvp.features.showcontacts

import ir.goldenmind.androidmvp.pojo.Contact
import ir.goldenmind.androidmvp.utils.Consts

class ShowContactsPresenter(private val view: Contract.View) : Contract.Presenter {

    private val model = ShowContactsModel(this)

    fun onShowContactsList() {
        model.fetchContactList()
    }

    override fun contactListFetched(list: ArrayList<Contact>) {
        view.showContactList(list)
    }

    fun onRecyclerViewItemClick(strName: String) {
        view.showToastMessage("Item ${strName} clicked", Consts.SHORT_DURATION)
    }

    override fun onRecyclerSwip(id: Int?) {
        model.deleteContact(id)
    }

    override fun onContactDeleted(successfulDelete: Boolean) {

        if (successfulDelete) {
            view.showToastMessage("Item removed", Consts.SHORT_DURATION)
        } else {
            view.showToastMessage("Failed to remove item", Consts.SHORT_DURATION)
        }
    }
}