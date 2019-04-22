package com.enzoftware.projects.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val pages = mutableListOf<Fragment>()

    fun setPages(data: List<Fragment>) {
        pages.clear()
        pages.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

}