package com.lucas.petcareapp.ui.viewmodels

import androidx.lifecycle.*
import com.lucas.petcareapp.data.model.Pet
import com.lucas.petcareapp.data.repository.PetRepository
import kotlinx.coroutines.launch

class PetViewModel(private val repository: PetRepository) : ViewModel() {

    val listaDePets: LiveData<List<Pet>> = repository.todosOsPets

    fun inserirPet(pet: Pet) {
        viewModelScope.launch {
            repository.inserir(pet)
        }
    }

    fun atualizarPet(pet: Pet) {
        viewModelScope.launch {
            repository.atualizar(pet)
        }
    }

    fun deletarPet(pet: Pet) {
        viewModelScope.launch {
            repository.deletar(pet)
        }
    }

    fun buscarPetPorId(id: Int): LiveData<Pet?> {
        val resultado = MutableLiveData<Pet?>()
        viewModelScope.launch {
            resultado.postValue(repository.buscarPorId(id))
        }
        return resultado
    }
}
