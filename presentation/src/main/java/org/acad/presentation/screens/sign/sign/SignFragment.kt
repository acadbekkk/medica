package org.acad.presentation.screens.sign.sign

import android.os.Bundle
import android.view.View
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentSignBinding
import org.acad.presentation.screens.sign.sign.SignVM.Event.NavigateToSignIn
import org.acad.presentation.screens.sign.sign.SignVM.Event.NavigateToSignUp
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 1/13/2025
 */
class SignFragment : BaseFragment<FragmentSignBinding>(FragmentSignBinding::inflate) {

    private val vm: SignVM by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() = with(binding) {
        btn.setOnClickListener {
            vm.processEvent(NavigateToSignIn)
        }

        signUp.setOnClickListener {
            vm.processEvent(NavigateToSignUp)
        }

        back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}