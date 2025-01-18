package org.acad.presentation.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import org.acad.presentation.R
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 12/28/2024
 */
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val vm: SplashVM by viewModel()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!vm.isFirstLaunch()) {
            vm.navToOnboarding()
            return
        }

        //Set up ViewPager2 for two splash screens
        val splashAdapter = SplashAdapter(listOf(R.layout.splash_item0, R.layout.splash_item1))
        binding.pager.adapter = splashAdapter

        //Show each splash screens
        lifecycleScope.launchWhenResumed {
            delay(3500)
            binding.pager.setCurrentItem(1, true)
            delay(3500)
            vm.navToOnboarding()
        }

    }
}