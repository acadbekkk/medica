package org.acad.presentation.navigations

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.acad.presentation.screens.home.HomeFragment
import org.acad.presentation.screens.onboarding.FragmentOnboarding
import org.acad.presentation.screens.sign.sign.SignFragment
import org.acad.presentation.screens.sign.signIn.SignInFragment
import org.acad.presentation.screens.sign.signUp.SignUpFragment
import org.acad.presentation.screens.splash.SplashFragment

/**
 * Created by Acad Bek on 12/28/2024
 */
object Screens {
    fun splash() = FragmentScreen { SplashFragment() }
    fun onboarding() = FragmentScreen { FragmentOnboarding() }
    fun signIn() = FragmentScreen { SignInFragment() }
    fun signUp() = FragmentScreen { SignUpFragment() }
    fun sign() = FragmentScreen { SignFragment() }
    fun home() = FragmentScreen { HomeFragment() }
}