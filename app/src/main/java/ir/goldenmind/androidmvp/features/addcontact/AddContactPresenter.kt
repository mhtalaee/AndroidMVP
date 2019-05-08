package ir.goldenmind.androidmvp.features.addcontact

import ir.goldenmind.androidmvp.pojo.Contact
import ir.goldenmind.androidmvp.utils.Consts

class AddContactPresenter(private val view: Contract.View) : Contract.Presenter {

    private val model = AddContactModel(this)

    override fun onSaveButtonClicked() {
        val contact: Contact = view.getFormValues()
        model.saveContact(contact)
    }

    override fun onSaveContactFinished(successInsert: Boolean) {
        if (successInsert) {
            view.showToast("Contact saved successfully", Consts.LONG_DURATION)
        } else {
            view.showToast("Contact saving failed", Consts.SHORT_DURATION)
        }
    }



}