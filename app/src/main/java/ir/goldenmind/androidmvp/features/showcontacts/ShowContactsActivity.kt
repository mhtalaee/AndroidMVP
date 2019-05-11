package ir.goldenmind.androidmvp.features.showcontacts

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.base.BaseActivity
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
            finish()
        }
    }

    override fun showContactList(list: ArrayList<Contact>) {
        initRecyclerView(list)
    }

    private fun initRecyclerView(list: ArrayList<Contact>) {

        //set adapter
        val adapter = ContactListAdapter(list, object : ClickHandler {
            override fun onClick(v: View) {
                presenter.onRecyclerViewItemClick(v)
            }
        })
        rvContactList.adapter = adapter

        //set layout manager
        rvContactList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //set swipe
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            override fun onMove(recyclerView: RecyclerView,viewHolder: RecyclerView.ViewHolder,target: RecyclerView.ViewHolder): Boolean {

                val position = viewHolder.adapterPosition
                adapter!!.removeItem(position)
                return true
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val position = viewHolder.adapterPosition

                if (direction == ItemTouchHelper.RIGHT) {
                    adapter!!.removeItem(position)
                    //notify presenter of swiping RecyclerView
                }
            }

        })

        itemTouchHelper.attachToRecyclerView(rvContactList)

    }

    override fun showToastMessage(message: String, duration: Int) {
        Toast.makeText(this, "item ${message} clicked", duration).show()
    }

}
