package org.acad.presentation.screens.sign.signUp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import org.acad.presentation.R
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentSignUpBinding
import org.acad.presentation.screens.sign.signUp.SignUpVM.Event.NavigateToHome
import org.acad.presentation.screens.sign.signUp.SignUpVM.Event.NavigateToSignIn
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 12/28/2024
 */
class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    private val vm: SignUpVM by viewModel()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.root.setOnTouchListener { _, _ ->
            hideKeyboard()
            binding.root.clearFocus()
            true
        }
        return binding.root
    }

    private fun hideKeyboard() {
        val imm = requireContext()
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        view?.let {
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() = with(binding) {

        // Set initial drawable colors
        updateDrawableColors(email, R.color.hint)
        updateDrawableColors(pass, R.color.hint)

        // Change colors when focused or selected
        pass.setOnFocusChangeListener { _, hashFocus ->
            val color = if (hashFocus) R.color.primary else R.color.hint
            updateDrawableColors(pass, color)
        }

        toSignIn.setOnClickListener {
            vm.processEvent(NavigateToSignIn)
        }

        email.setOnFocusChangeListener { _, hashFocus ->
            val color = if (hashFocus) R.color.primary else R.color.hint
            updateDrawableColors(email, color)
        }

        btn.setOnClickListener {
            vm.processEvent(NavigateToHome)
        }

        back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun updateDrawableColors(editText: TextInputEditText, coloRes: Int) {
        val color = ContextCompat.getColor(requireContext(), coloRes)
        val startDrawable = editText.compoundDrawablesRelative[0]

        startDrawable?.setTint(color)

        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
            startDrawable, null, null, null
        )
    }
}