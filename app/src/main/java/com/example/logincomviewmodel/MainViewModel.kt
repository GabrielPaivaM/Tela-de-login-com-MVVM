package com.example.logincomviewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var personRepository = PersonRepository()
    private var login = MutableLiveData<String>()


    fun login(): LiveData<String> {
        return login
    }

    fun doLogin(email: String, password: String){
        if (personRepository.login(email, password)){
            login.value = "Login ok!"
        } else if (email.isEmpty() || password.isEmpty()) {
            login.value = "Preencha os campos!"
        } else {
            login.value = "Login error!"
        }
    }
}