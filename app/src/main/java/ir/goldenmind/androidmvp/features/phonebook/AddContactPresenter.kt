package ir.goldenmind.androidmvp.features.phonebook

import ir.goldenmind.androidmvp.pojo.Contact
import ir.goldenmind.androidmvp.utils.Consts

class AddContactPresenter(private val view: Contract.View) : Contract.Presenter {

    private val model = AddContactModel(this)

    override fun onSaveButtonClicked() {

        val contact: Contact = view.getFormValues()
        val successInsert = model.saveContact(contact)

        if (successInsert) {
            view.showToast("Contact saved successfully", Consts.LONG_DURATION)
        } else {
            view.showToast("Contact saving failed", Consts.SHORT_DURATION)
        }

    }


}