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
        navController!!.navigate(R.id.action_signInFragment_to_foodMenuActivity)
    }

    private fun goToSignUp() {
        navController!!.navigate(R.id.action_signInFragment_to_signUpFragment)
    }
}