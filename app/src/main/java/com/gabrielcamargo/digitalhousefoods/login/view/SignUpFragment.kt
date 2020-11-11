package com.gabrielcamargo.digitalhousefoods.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.gabrielcamargo.digitalhousefoods.R
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignUpFragment : Fragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin_signUp)
        btnLogin.setOnClickListener(this)

        val btnRegister = view.findViewById<Button>(R.id.btnRegister_signUp)
        btnRegister.setOnClickListener(this)
    }

    companion object {
        fun newInstance() = SignUpFragment()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnLogin_signUp -> backToSignIn()
            R.id.btnRegister_signUp -> makeRegister()
        }
    }

    private fun makeRegister() {
        val nameInput = view?.findViewById<TextInputLayout>(R.id.edtName_signUp)
        val name = nameInput?.editText?.text.toString()

        if(name.trim() == "") {
            nameInput?.error = "Informe um nome!"
            return
        }
        nameInput?.error = null

        val emailInput = view?.findViewById<TextInputLayout>(R.id.edtEmail_signUp)
        val email = emailInput?.editText?.text.toString()

        if(email.trim() == "") {
            emailInput?.error = "Informe um email!"
            return
        }
        emailInput?.error = null

        val passwordInput = view?.findViewById<TextInputLayout>(R.id.edtPassword_signUp)
        val password = passwordInput?.editText?.text.toString()

        if(password.trim() == "") {
            passwordInput?.error = "Informe uma senha!"
            return
        }

        if(password.trim().length < 8) {
            passwordInput?.error = "A senha deve possuir pelo menos 8 caracteres!"
            return
        }
        passwordInput?.error = null

        val passwordConfirmInput = view?.findViewById<TextInputLayout>(R.id.edtConfirmPassword_signUp)
        val passwordConfirm = passwordConfirmInput?.editText?.text.toString()

        if(password != passwordConfirm) {
            passwordConfirmInput?.error = "Senhas diferentes informadas!"
            return
        }
        passwordConfirmInput?.error = null

        Toast.makeText(view?.context, "sucesso", Toast.LENGTH_SHORT).show()
    }

    private fun backToSignIn() {
        activity?.onBackPressed()
    }
}