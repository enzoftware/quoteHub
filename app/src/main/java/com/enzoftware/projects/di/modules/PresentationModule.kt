package com.enzoftware.projects.di.modules

import com.enzoftware.projects.ui.addQuote.presenter.AddQuotePresenter
import com.enzoftware.projects.ui.addQuote.presenter.AddQuotePresenterImpl
import com.enzoftware.projects.ui.login.presenter.LoginPresenter
import com.enzoftware.projects.ui.login.presenter.LoginPresenterImpl
import com.enzoftware.projects.ui.profile.presenter.ProfilePresenter
import com.enzoftware.projects.ui.profile.presenter.ProfilePresenterImpl
import com.enzoftware.projects.ui.quotes.all.presenter.AllQuotesPresenter
import com.enzoftware.projects.ui.quotes.all.presenter.AllQuotesPresenterImpl
import com.enzoftware.projects.ui.quotes.favorites.presenter.FavoritesQuotesPresenter
import com.enzoftware.projects.ui.quotes.favorites.presenter.FavoritesQuotesPresenterImpl
import com.enzoftware.projects.ui.register.presenter.RegisterPresenter
import com.enzoftware.projects.ui.register.presenter.RegisterPresenterImpl
import com.enzoftware.projects.ui.welcome.presenter.WelcomePresenter
import com.enzoftware.projects.ui.welcome.presenter.WelcomePresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {

    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter

    @Binds
    abstract fun registerPresenter(registerPresenter: RegisterPresenterImpl): RegisterPresenter

    @Binds
    abstract fun allQuotesPresenter(allJokesPresenterImpl: AllQuotesPresenterImpl): AllQuotesPresenter

    @Binds
    abstract fun favoriteQuotesPresenter(favoriteJokesPresenterImpl: FavoritesQuotesPresenterImpl): FavoritesQuotesPresenter

    @Binds
    abstract fun profilePresenter(profilePresenterImpl: ProfilePresenterImpl): ProfilePresenter

    @Binds
    abstract fun addQuotePresenter(addJokePresenterImpl: AddQuotePresenterImpl): AddQuotePresenter

    @Binds
    abstract fun welcomePresenter(welcomePresenterImpl: WelcomePresenterImpl): WelcomePresenter
}