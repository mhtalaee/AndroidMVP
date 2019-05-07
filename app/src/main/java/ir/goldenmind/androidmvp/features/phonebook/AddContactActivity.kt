package ir.goldenmind.androidmvp.features.phonebook

import android.os.Bundle
import ir.goldenmind.androidmvp.R
import ir.goldenmind.androidmvp.base.BaseActivity

class AddContactActivity : BaseActivity(), Contract.View {

    private val presenter = AddContactPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)


    }
}
