package project.shen.wowhub.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import project.shen.wowhub.R

class DbActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)
        val int = intent.getIntExtra("key", 0)
        Toast.makeText(this, "$int", Toast.LENGTH_SHORT).show()
    }
}
