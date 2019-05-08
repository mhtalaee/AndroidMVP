package ir.goldenmind.androidmvp.features.addcontact

import ir.goldenmind.androidmvp.pojo.Contact

interface Contract {

    interface View {
        fun getFormValues(): Contact
        fun showToast(message: String, duration: Int)
        fun changeActivity(destivationActivity: Class<*>)
    }

    interface Presenter {
        fun onSaveButtonClicked()
        fun onSaveContactFinished(successInsert: Boolean)
    }
}