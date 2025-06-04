package com.lucas.petcareapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lucas.petcareapp.data.model.Pet

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirPet(pet: Pet)

    @Update
    suspend fun atualizarPet(pet: Pet)

    @Delete
    suspend fun deletarPet(pet: Pet)

    @Query("SELECT * FROM pets ORDER BY nome ASC")
    fun listarTodos(): LiveData<List<Pet>>

    @Query("SELECT * FROM pets WHERE id = :id")
    suspend fun buscarPorId(id: Int): Pet?
}
