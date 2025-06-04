package com.lucas.petcareapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pets")
data class Pet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val raca: String,
    val sexo: String,
    val dataNascimento: String,
    val pesoAtual: Float,
    val fotoUri: String
)
