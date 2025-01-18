package org.acad.presentation.screens.onboarding

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import org.acad.presentation.R
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentOnboardingBinding
import org.acad.presentation.screens.onboarding.OnboardingVM.Event.NavigateToSign
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 12/30/2024
 */
class FragmentOnboarding :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    private val vm: OnboardingVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() = with(binding) {

        if (!vm.isFirstLaunch()) {
            vm.processEvent(NavigateToSign)
            return
        }

        val onboardingItems = listOf(
            Pair(R.drawable.onboardin0, getString(R.string.walkthrough0)),
            Pair(R.drawable.onboardin1, getString(R.string.walkthrough1)),
            Pair(R.drawable.onboardin2, getString(R.string.walkthrough2)),
        )

        val adapter = Adapter(onboardingItems)
        pager.adapter = adapter

        val indicator = indicator
        indicator.attachTo(pager)

        // Change button text based on the current page
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == onboardingItems.size - 1) {
                    btn.text = getString(R.string.btn_get_start)
                } else {
                    btn.text = getString(R.string.btn_next)
                }
            }
        })

        btn.setOnClickListener {
            if (pager.currentItem == onboardingItems.size - 1) {
                vm.processEvent(NavigateToSign)
            } else
                ++pager.currentItem
        }
    }
}