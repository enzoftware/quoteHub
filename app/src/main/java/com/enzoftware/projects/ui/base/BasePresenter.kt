package com.enzoftware.projects.ui.base

interface BasePresenter<in T> {

    fun setView(view: T)

}