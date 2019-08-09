package project.shen.wowhub.view

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import project.shen.wowhub.R
import project.shen.wowhub.mvp.impl.BaseActivity
import project.shen.wowhub.mvp.util.BundleType
import project.shen.wowhub.mvp.util.goto
import project.shen.wowhub.presenter.MainPresenter

class MainActivity : BaseActivity<MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRun.setOnClickListener {
            goto<DbActivity, BundleType<Map<String, Int>>> {
                val map = mapOf("key" to 1)
                BundleType(map)
            }
        }
    }
}
