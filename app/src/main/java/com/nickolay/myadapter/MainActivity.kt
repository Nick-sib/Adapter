package com.nickolay.myadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nickolay.myadapter.indiator.PageIndicatorView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initButtons()
    }

    private fun initViews() {
        if (pageList.isEmpty())
            pageList.apply {
                add(createPageView(R.color.google_red))
                add(createPageView(R.color.google_blue))
                add(createPageView(R.color.google_yellow))
                add(createPageView(R.color.google_green))
            }
        vpMain.adapter = MyAdapter(pageList)
    }

    private fun initButtons(){
        bAdd.setOnClickListener {
            (vpMain.adapter as MyAdapter)
                .addView(createPageView(R.color.google_red))
        }

        bInteractive.setOnClickListener {
            (piView as PageIndicatorView).apply {
                isInteraction = !isInteraction
            }
        }
    }


    private fun createPageView(color: Int): View =
        View(this).apply {
            setBackgroundColor(resources.getColor(color, null))
        }


    companion object {
        private val pageList = ArrayList<View>()
    }
}