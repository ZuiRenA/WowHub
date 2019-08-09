package project.shen.wowhub.presenter

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import project.shen.wowhub.MyApplication
import project.shen.wowhub.mvp.impl.BasePresenter
import project.shen.wowhub.retrofit_paly.GithubInterface
import project.shen.wowhub.retrofit_paly.RetrofitHelper
import project.shen.wowhub.view.MainActivity
import java.util.*

class MainPresenter: BasePresenter<MainActivity>() {

    fun createShowSnackBar(view: View) {
        Snackbar.make(view, "提示消息", Snackbar.LENGTH_SHORT)
            .setAction("wow") {
                Toast.makeText(view.context, "点击了snackbar", Toast.LENGTH_SHORT).show()
            }.show()
    }

}