package com.enzoftware.projects.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.common.onClick
import com.enzoftware.projects.common.onPageChange
import com.enzoftware.projects.ui.addQuote.AddQuoteActivity
import com.enzoftware.projects.ui.base.BaseActivity
import com.enzoftware.projects.ui.profile.ProfileFragment
import com.enzoftware.projects.ui.quotes.all.QuotesFragment
import com.enzoftware.projects.ui.quotes.favorites.FavoritesQuotesFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initUi()
    }

    private fun initUi() {
        val adapter = HomePagerAdapter(supportFragmentManager)
        adapter.setPages(listOf(QuotesFragment(), FavoritesQuotesFragment(), ProfileFragment()))
        mainPager.adapter = adapter
        mainPager.offscreenPageLimit = 3
        bottomNavigation.setOnNavigationItemSelectedListener {
            switchNavigationTab(it.order)
            true
        }
        mainPager.onPageChange { position ->
            val item = bottomNavigation.menu.getItem(position)
            bottomNavigation.selectedItemId = item.itemId
        }
        addQuote.onClick {
            startActivity(Intent(this, AddQuoteActivity::class.java))
        }
    }

    private fun switchNavigationTab(position: Int) = mainPager.setCurrentItem(position, true)

}
