package ir.goldenmind.androidmvp.features.addcontact

import ir.goldenmind.androidmvp.pojo.Contact

interface Contract {

    interface View {

        fun getFormValues(): Contact
        fun showToast(s: String, shorT_DURATION: Int)
    }

    interface Presenter {

        fun onSaveButtonClicked()
        fun onSaveContactFinished(successInsert: Boolean)

    }
}