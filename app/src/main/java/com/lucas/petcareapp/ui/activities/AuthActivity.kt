package com.lucas.petcareapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lucas.petcareapp.MainActivity
import com.lucas.petcareapp.R
import com.lucas.petcareapp.ui.viewmodels.AuthViewModel

class AuthActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModels()

    private lateinit var campoNome: EditText
    private lateinit var campoEmail: EditText
    private lateinit var campoSenha: EditText
    private lateinit var botaoEntrar: Button
    private lateinit var botaoCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        campoNome = findViewById(R.id.editNome)
        campoEmail = findViewById(R.id.editEmail)
        campoSenha = findViewById(R.id.editSenha)
        botaoEntrar = findViewById(R.id.btnEntrar)
        botaoCadastrar = findViewById(R.id.btnCadastrar)

        authViewModel.status.observe(this, Observer { sucesso ->
            if (sucesso == true) {
                abrirMain()
                authViewModel.limparStatus()
            }
        })

        authViewModel.mensagemErro.observe(this, Observer { erro ->
            erro?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                authViewModel.limparStatus()
            }
        })

        botaoEntrar.setOnClickListener {
            val email = campoEmail.text.toString()
            val senha = campoSenha.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                authViewModel.login(email, senha)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        botaoCadastrar.setOnClickListener {
            val nome = campoNome.text.toString()
            val email = campoEmail.text.toString()
            val senha = campoSenha.text.toString()

            if (nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty()) {
                authViewModel.cadastrar(nome, email, senha)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (authViewModel.usuarioLogado()) {
            abrirMain()
        }
    }

    private fun abrirMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
