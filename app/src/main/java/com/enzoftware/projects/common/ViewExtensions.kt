package com.enzoftware.projects.common

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.viewpager.widget.ViewPager

inline fun EditText.onTextChanged(crossinline onTextChangedHandler: (String?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(input: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChangedHandler(input?.toString() ?: "")
        }

    })
}

inline fun View.onClick(crossinline onClickHandler: () -> Unit) {
    setOnClickListener { onClickHandler() }
}


inline fun ViewPager.onPageChange(crossinline onPageChangeHandler: (Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onPageSelected(position: Int) {
            return onPageChangeHandler(position)
        }

    })
}

