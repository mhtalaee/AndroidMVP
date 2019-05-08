package ir.goldenmind.androidmvp.features.showcontacts

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.base.BaseActivity
import ir.goldenmind.androidmvp.features.addcontact.AddContactActivity
import ir.goldenmind.androidmvp.features.showcontacts.adapter.ContactListAdapter
import ir.goldenmind.androidmvp.pojo.Contact
import kotlinx.android.synthetic.main.activity_show_contacts.*

class ShowContactsActivity : BaseActivity(), Contract.View {

    val presenter = ShowContactsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_contacts)

        init()
    }

    private fun init() {
        presenter.onShowContactsList()

        btnBack.setOnClickListener {
            val intentToAddContactActivity = Intent(this, AddContactActivity::class.java)
            startActivity(intentToAddContactActivity)
        }
    }

    override fun showContactList(list: ArrayList<Contact>) {

        val rvAdapter = ContactListAdapter(list)
        rvContactList.adapter = rvAdapter
        rvContactList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}
