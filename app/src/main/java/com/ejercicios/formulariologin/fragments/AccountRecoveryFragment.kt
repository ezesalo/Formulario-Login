package com.ejercicios.formulariologin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.AccountRecoveryViewModel

class AccountRecoveryFragment : Fragment() {

    companion object {
        fun newInstance() = AccountRecoveryFragment()
    }

    private lateinit var viewModel: AccountRecoveryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.account_recovery_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountRecoveryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}