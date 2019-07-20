package project.shen.wowhub.view

import android.os.Bundle
import project.shen.mvp.impl.BaseActivity
import project.shen.wowhub.R
import project.shen.wowhub.presenter.MainPresenter

class MainActivity : BaseActivity<MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
