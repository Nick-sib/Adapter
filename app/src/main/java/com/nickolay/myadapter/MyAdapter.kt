package com.nickolay.myadapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class MyAdapter(private val viewList: ArrayList<View>): PagerAdapter(){

    fun addView(view: View){
        viewList.add(view)
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = viewList[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int = viewList.size

    override fun isViewFromObject(view: View, obj: Any) = view == obj

}