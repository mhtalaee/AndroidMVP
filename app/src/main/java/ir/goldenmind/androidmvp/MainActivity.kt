package ir.goldenmind.androidmvp.base

import android.os.Bundle
import ir.goldenmind.androidmvp.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
