package com.example.novelaactualizado

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NovelaRepository {

    private val database = FirebaseDatabase.getInstance()
    private val novelasRef = database.getReference("novela")

    fun agregarNovela(novela: Novela) {
        val novelaId = novelasRef.push().key // Generate a unique key
        if (novelaId != null) {
            novelasRef.child(novelaId).setValue(novela)
        }
    }

    fun buscarNovelaPorTitulo(titulo: String, callback: (Novela?) -> Unit) {
        Log.d("NovelaRepository", "Searching for novel with title: $titulo")

        novelasRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("NovelaRepository", "DataSnapshot: ${snapshot.toString()}")

                for (novelaSnapshot in snapshot.children) {
                    val novela = novelaSnapshot.getValue(Novela::class.java)
                    if (novela?.titulo == titulo) { // Check if title matches
                        Log.d("NovelaRepository", "Novel found: $novela")
                        callback(novela)
                        return
                    }
                }

                Log.d("NovelaRepository", "Novel not found")
                callback(null) // Novela not found
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("NovelaRepository", "Error searching for novel", error.toException())
                callback(null) // Error de búsqueda
            }
        })
    }
}