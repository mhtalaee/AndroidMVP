package ir.goldenmind.androidmvp.features.showcontacts

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.base.BaseActivity
import ir.goldenmind.androidmvp.features.showcontacts.adapter.ContactListAdapter
import ir.goldenmind.androidmvp.pojo.Contact
import kotlinx.android.synthetic.main.activity_show_contacts.*
import com.google.android.material.snackbar.Snackbar

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
        var adapter = ContactListAdapter(list, onItemClickHandler)
        rvContactList.adapter = adapter

        //set layout manager
        rvContactList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //set swipe
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val position = viewHolder.adapterPosition
                val removedItem: Contact = adapter.contactList.get(position)

                if (direction == ItemTouchHelper.RIGHT) {

                    adapter.removeItem(position)

                    val snackbar = Snackbar.make(
                        activity_show_layout,
                        "${removedItem.firstName} was removed from the list.",
                        Snackbar.LENGTH_LONG
                    )

                    snackbar.addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        override fun onDismissed(transientBottomBar: Snackbar, event: Int) {

                            when (event) {
                                DISMISS_EVENT_TIMEOUT -> presenter.onRecyclerSwip(removedItem.id)
                                DISMISS_EVENT_CONSECUTIVE -> presenter.onRecyclerSwip(removedItem.id)
                            }
                        }
                    })

                    snackbar.setAction("Undo", View.OnClickListener {
                        adapter.restoreItem(removedItem, position)
                        rvContactList.scrollToPosition(position);
                    })

                    snackbar.setActionTextColor(Color.YELLOW)
                    snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                    snackbar.show()
                }
            }
        })

        itemTouchHelper.attachToRecyclerView(rvContactList)

    }

    override fun showToastMessage(message: String, duration: Int) {
        Toast.makeText(this, message, duration).show()
    }

    val onItemClickHandler: (String) -> Unit = { presenter.onRecyclerViewItemClick(it) }

    override fun refreshRecyclerView() {
//        adapter?.notifyItemRemoved(this.position!!)
//        rvContactList.adapter?.notifyItemRemoved(this.position!!)
    }
}
