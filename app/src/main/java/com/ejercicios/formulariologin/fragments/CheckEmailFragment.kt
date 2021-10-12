package com.ejercicios.formulariologin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.BoringLayout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.CheckEmailViewModel
import com.google.firebase.auth.FirebaseAuth

class CheckEmailFragment : Fragment() {

    lateinit var v: View
    lateinit var btn: Button
    private val viewModelCheckEmail: CheckEmailViewModel by viewModels()

    companion object {
        fun newInstance() = CheckEmailFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.check_email_fragment, container, false)
        btn = v.findViewById(R.id.verificacionButton)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

        btn.setOnClickListener(){
            viewModelCheckEmail.enviarEmailDeVerificacion(v)
        }
    }



}