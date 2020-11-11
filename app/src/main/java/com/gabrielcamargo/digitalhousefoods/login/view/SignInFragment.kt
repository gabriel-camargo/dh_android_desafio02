package com.gabrielcamargo.digitalhousefoods.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.gabrielcamargo.digitalhousefoods.R
import com.google.android.material.textfield.TextInputLayout

class SignInFragment : Fragment(), View.OnClickListener {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        val btnRegister = view.findViewById<Button>(R.id.btnRegister_signInFragment)
        btnRegister.setOnClickListener(this)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin_signInFragment)
        btnLogin.setOnClickListener(this)
    }

    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnRegister_signInFragment -> goToSignUp()
            R.id.btnLogin_signInFragment -> goToFoodMenu()
        }
    }

    private fun goToFoodMenu() {
        if(validateSignIn()) {
            navController!!.navigate(R.id.action_signInFragment_to_foodMenuActivity)
        }
    }

    private fun validateSignIn(): Boolean {
        val emailInput = view?.findViewById<TextInputLayout>(R.id.edtEmail_signIn)
        emailInput?.error = null
        val email = emailInput?.editText?.text.toString()

        val passwordInput = view?.findViewById<TextInputLayout>(R.id.edtPassword_signIn)
        passwordInput?.error = null
        val password = passwordInput?.editText?.text.toString()

        if(email.trim() == "") {
            emailInput?.error = getString(R.string.informe_email)
            return false
        }

        if(password.trim() == "") {
            passwordInput?.error = getString(R.string.informe_senha)
            return false
        }

        return true
    }

    private fun goToSignUp() {
        navController!!.navigate(R.id.action_signInFragment_to_signUpFragment)
    }
}