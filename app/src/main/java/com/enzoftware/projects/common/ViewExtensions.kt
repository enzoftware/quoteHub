package com.enzoftware.projects.common

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.viewpager.widget.ViewPager

inline fun EditText.onTextChanged(crossinline onTextChangedHandler: (String?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) = Unit
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
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
        override fun onPageScrollStateChanged(state: Int) = Unit
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
        override fun onPageSelected(position: Int) = onPageChangeHandler(position)
    })
}

