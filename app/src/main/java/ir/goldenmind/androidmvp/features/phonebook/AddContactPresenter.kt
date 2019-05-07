package ir.goldenmind.androidmvp.features.phonebook

class AddContactPresenter(private val view: Contract.View) : Contract.Presenter {

    private val model = AddContactModel(this)

}