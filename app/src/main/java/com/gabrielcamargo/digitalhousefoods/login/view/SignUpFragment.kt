package com.gabrielcamargo.digitalhousefoods.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.gabrielcamargo.digitalhousefoods.R
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignUpFragment : Fragment(), View.OnClickListener {
    private var navController: NavController? = null

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
        navController = findNavController()

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
        if(validadeSignUp()) {
            navController!!.navigate(R.id.action_signUpFragment_to_foodMenuActivity)
        }
    }

    private fun validadeSignUp(): Boolean {
        val nameInput = view?.findViewById<TextInputLayout>(R.id.edtName_signUp)
        nameInput?.error = null
        val name = nameInput?.editText?.text.toString()

        val emailInput = view?.findViewById<TextInputLayout>(R.id.edtEmail_signUp)
        emailInput?.error = null
        val email = emailInput?.editText?.text.toString()

        val passwordInput = view?.findViewById<TextInputLayout>(R.id.edtPassword_signUp)
        passwordInput?.error = null
        val password = passwordInput?.editText?.text.toString()

        val passwordConfirmInput = view?.findViewById<TextInputLayout>(R.id.edtConfirmPassword_signUp)
        passwordConfirmInput?.error = null
        val passwordConfirm = passwordConfirmInput?.editText?.text.toString()

        if(name.trim() == "") {
            nameInput?.error = getString(R.string.informe_nome)
             return false
        }

        if(email.trim() == "") {
            emailInput?.error = getString(R.string.informe_email)
            return false
        }

        if(password.trim() == "") {
            passwordInput?.error = getString(R.string.informe_senha)
            return false
        }

        if(password.trim().length < 8) {
            passwordInput?.error = getString(R.string.senha_min_caracteres)
            return false
        }

        if(password != passwordConfirm) {
            passwordConfirmInput?.error = getString(R.string.senhas_diferentes)
            return false
        }

        return true
    }

    private fun backToSignIn() {
        activity?.onBackPressed()
    }
}