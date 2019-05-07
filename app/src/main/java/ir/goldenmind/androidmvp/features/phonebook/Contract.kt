package ir.goldenmind.androidmvp.features.phonebook

import ir.goldenmind.androidmvp.pojo.Contact

interface Contract {

    interface View {

        fun getFormValues(): Contact
        fun showToast(s: String, shorT_DURATION: Int)
    }

    interface Presenter {

        fun onSaveButtonClicked()

    }
}