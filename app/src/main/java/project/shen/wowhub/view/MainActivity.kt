package project.shen.wowhub.view

import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import project.shen.wowhub.mvp.impl.BaseActivity
import project.shen.wowhub.R
import project.shen.wowhub.presenter.MainPresenter

class MainActivity : BaseActivity<MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
