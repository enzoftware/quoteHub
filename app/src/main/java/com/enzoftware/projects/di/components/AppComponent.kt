package com.enzoftware.projects.di.components

import com.enzoftware.projects.di.modules.PresentationModule
import com.enzoftware.projects.ui.addQuote.presenter.AddQuotePresenter
import com.enzoftware.projects.ui.login.presenter.LoginPresenter
import com.enzoftware.projects.ui.profile.presenter.ProfilePresenter
import com.enzoftware.projects.ui.quotes.all.presenter.AllQuotesPresenter
import com.enzoftware.projects.ui.quotes.favorites.presenter.FavoritesQuotesPresenter
import com.enzoftware.projects.ui.register.presenter.RegisterPresenter
import com.enzoftware.projects.ui.welcome.presenter.WelcomePresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {

    fun registerPresenter(): RegisterPresenter

    fun loginPresenter(): LoginPresenter

    fun allQuotesPresenter(): AllQuotesPresenter

    fun favoriteQuotesPresenter(): FavoritesQuotesPresenter

    fun profilePresenter(): ProfilePresenter

    fun addQuotePresenter(): AddQuotePresenter

    fun welcomePresenter(): WelcomePresenter

}