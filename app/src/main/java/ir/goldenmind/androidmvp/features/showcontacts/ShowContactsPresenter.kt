package ir.goldenmind.androidmvp.features.showcontacts

import android.view.View
import ir.goldenmind.androidmvp.pojo.Contact
import ir.goldenmind.androidmvp.utils.Consts
import kotlinx.android.synthetic.main.contact_recyclerview_item.view.*

class ShowContactsPresenter(private val view: Contract.View) : Contract.Presenter {

    private val model = ShowContactsModel(this)

    fun onShowContactsList() {
        model.fetchContactList()
    }

    override fun contactListFetched(list: ArrayList<Contact>) {
        view.showContactList(list)
    }

    fun onRecyclerViewItemClick(v: View) {
        view.showToastMessage(v.tvFullName.text.toString(), Consts.SHORT_DURATION)
    }
}