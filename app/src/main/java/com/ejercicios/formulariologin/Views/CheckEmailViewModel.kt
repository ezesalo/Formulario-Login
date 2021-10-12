package com.ejercicios.formulariologin.Views

import android.app.AlertDialog
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.ejercicios.formulariologin.fragments.CheckEmailFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.fragments.CheckEmailFragmentDirections
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlin.concurrent.timerTask

class CheckEmailViewModel : ViewModel() {

    val auth: FirebaseAuth = Firebase.auth
    var user = auth.currentUser

    fun enviarEmailDeVerificacion (v: View){

        val profileUpates = userProfileChangeRequest {  }

        user!!.updateProfile(profileUpates).addOnCompleteListener{
            if(it.isSuccessful){
              if (emailconfirmado()){

              }
            }
        }

        user!!.sendEmailVerification().addOnCompleteListener(){
            if (it.isSuccessful){
                val action = CheckEmailFragmentDirections.actionCheckEmailFragmentToLoginV2Fragment()
                v.findNavController().navigate(action)
            }
        }
        }

    fun emailconfirmado(): Boolean{
        return auth.currentUser!!.isEmailVerified
    }

    }