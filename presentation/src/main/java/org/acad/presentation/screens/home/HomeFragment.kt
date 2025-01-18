package org.acad.presentation.screens.home

import android.os.Bundle
import android.view.View
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentHomeBinding

/**
 * Created by Acad Bek on 1/13/2025
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() = with(binding) {

    }
}