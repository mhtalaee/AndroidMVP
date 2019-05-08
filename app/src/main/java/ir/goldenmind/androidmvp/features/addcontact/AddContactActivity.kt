package ir.goldenmind.androidmvp.features.addcontact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.base.BaseActivity
import ir.goldenmind.androidmvp.pojo.Contact
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : BaseActivity(), Contract.View {

    private val presenter = AddContactPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)
        init()
    }

    override fun onResume() {
        super.onResume()
        etFirstName.text.clear()
        etLastName.text.clear()
        etCellPhone.text.clear()
    }

    private fun init() {

        btnSave.setOnClickListener {
            presenter.onSaveButtonClicked()
        }

        btnShowList.setOnClickListener {
            presenter.onShowListButtonClicked()
        }
    }

    override fun getFormValues(): Contact {
        val contact = Contact()
        contact.firstName = etFirstName.text.toString()
        contact.lastName = etLastName.text.toString()
        contact.cellPhone = etCellPhone.text.toString()
        return contact
    }

    override fun showToast(message: String, duration: Int) {
        Toast.makeText(this, message, duration).show()
    }

    override fun changeActivity(destivationActivity: Class<*>) {
        val intentToShowContactsActivity = Intent(this, destivationActivity)
        startActivity(intentToShowContactsActivity)
    }

}
