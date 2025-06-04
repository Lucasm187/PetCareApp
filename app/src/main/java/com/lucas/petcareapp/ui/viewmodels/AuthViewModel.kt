package com.lucas.petcareapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _status = MutableLiveData<Boolean?>()
    val status: LiveData<Boolean?> = _status

    private val _mensagemErro = MutableLiveData<String?>()
    val mensagemErro: LiveData<String?> = _mensagemErro

    fun login(email: String, senha: String) {
        firebaseAuth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _status.value = true
                } else {
                    _mensagemErro.value = "Erro ao fazer login"
                    _status.value = false
                }
            }
    }

    fun cadastrar(nome: String, email: String, senha: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _status.value = true
                } else {
                    _mensagemErro.value = "Erro ao cadastrar"
                    _status.value = false
                }
            }
    }

    fun limparStatus() {
        _status.value = null
        _mensagemErro.value = null
    }

    fun usuarioLogado(): Boolean {
        return firebaseAuth.currentUser != null
    }
}
