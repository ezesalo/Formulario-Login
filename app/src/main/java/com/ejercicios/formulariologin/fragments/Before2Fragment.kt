package com.ejercicios.formulariologin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.Before2ViewModel

class Before2Fragment : Fragment() {

    lateinit var v: View
    lateinit var registroBtn: Button
    lateinit var loginBtn: Button


    companion object {
        fun newInstance() = Before2Fragment()
    }

    private lateinit var viewModel: Before2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.before2_fragment, container, false)
        registroBtn = v.findViewById(R.id.beforeRegistro)
        loginBtn = v.findViewById(R.id.beforeLogin)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Before2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        registroBtn.setOnClickListener(){
            val act1= Before2FragmentDirections.actionBefore2FragmentToRegistroFragment()
            v.findNavController().navigate(act1)
        }

        loginBtn.setOnClickListener(){
            val act2 = Before2FragmentDirections.actionBefore2FragmentToLoginFragment()
            v.findNavController().navigate(act2)
        }
    }
}