package com.gabrielcamargo.digitalhousefoods.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.gabrielcamargo.digitalhousefoods.R

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
    }

    companion object {
        fun newInstance() = SignUpFragment()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnLogin_signUp -> backToSignIn()
        }
    }

    private fun backToSignIn() {
        activity?.onBackPressed()
    }
}