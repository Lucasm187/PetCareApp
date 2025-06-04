package com.lucas.petcareapp.data.repository

import androidx.lifecycle.LiveData
import com.lucas.petcareapp.data.database.PetDao
import com.lucas.petcareapp.data.model.Pet

class PetRepository(private val petDao: PetDao) {

    val todosOsPets: LiveData<List<Pet>> = petDao.listarTodos()

    suspend fun inserir(pet: Pet) {
        petDao.inserirPet(pet)
    }

    suspend fun atualizar(pet: Pet) {
        petDao.atualizarPet(pet)
    }

    suspend fun deletar(pet: Pet) {
        petDao.deletarPet(pet)
    }

    suspend fun buscarPorId(id: Int): Pet? {
        return petDao.buscarPorId(id)
    }
}
