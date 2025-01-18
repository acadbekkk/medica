package org.acad.presentation.screens.sign.signIn

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import org.acad.presentation.R
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentSignInBinding
import org.acad.presentation.screens.sign.signIn.SignInVM.Event.NavigateToHome
import org.acad.presentation.screens.sign.signIn.SignInVM.Event.NavigateToSignUp
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 12/28/2024
 */
class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    private val vm: SignInVM by viewModel()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding.root.setOnTouchListener{_, _ ->
         hideKeyboard()
         binding.root.clearFocus()
            true
        }
        return binding.root
    }

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

        signUp.setOnClickListener {
            vm.processEvent(NavigateToSignUp)

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

    private fun hideKeyboard() {
        val imm = requireContext()
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        view?.let {
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

}