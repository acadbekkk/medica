package org.acad.presentation.screens.signIn

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
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Acad Bek on 12/28/2024
 */
class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    private val vm: SignInVM by viewModel()

    private var isPassVisible = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        view.setOnTouchListener { _, _ ->
            hideKeyboard()
            view.clearFocus()
            true
        }
        return view
    }

    private fun hideKeyboard() {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocus = requireActivity().currentFocus
        if (currentFocus != null) {
            imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
            currentFocus.clearFocus()
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = view.findViewById<TextInputEditText>(R.id.email)
        val pass = view.findViewById<TextInputEditText>(R.id.pass)
        val eye = view.findViewById<ImageButton>(R.id.eye)
        val btn = view.findViewById<Button>(R.id.btn)
        val check = view.findViewById<CheckBox>(R.id.check)

        // Set initial drawable colors
        updateDrawableColors(email, R.color.hint)
        updateDrawableColors(pass, R.color.hint)

        // Set initial icon state
//        eye.setImageResource(R.drawable.invisible)

//        eye.setOnClickListener {
//            if (pass.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
//                pass.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
//                eye.setImageResource(R.drawable.visible)
//            } else if (pass.inputType != InputType.TYPE_TEXT_VARIATION_PASSWORD) {
//                pass.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
//                eye.setImageResource(R.drawable.invisible)
//            }
//        }

        // Change colors when focused or selected
        pass.setOnFocusChangeListener { _, hashFocus ->
            val color = if (hashFocus) R.color.primary else R.color.hint
            updateDrawableColors(pass, color)
        }

        email.setOnFocusChangeListener { _, hashFocus ->
            val color = if (hashFocus) R.color.primary else R.color.hint
            updateDrawableColors(email, color)
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