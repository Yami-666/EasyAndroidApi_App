package com.example.timekillapp.core.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map

@ExperimentalCoroutinesApi
object FirebaseHelper {
    private val dataBase = FirebaseDatabase.getInstance()

    val reference = dataBase.reference
    fun reference(path: String) = dataBase.getReference(path)

    fun collection(path: String): CollectionReference =
        Firebase.firestore.collection(path)

    fun Query.asFlow(): Flow<QuerySnapshot> {
        return callbackFlow {
            val callback = addSnapshotListener { querySnapshot, executor ->
                executor?.let {
                    close(executor)
                } ?: trySend(querySnapshot!!)
            }
            awaitClose {
                callback.remove()
            }
        }
    }

    fun <R> Query.mapFlowSnapshotTo(mapFunc: QueryDocumentSnapshot.() -> R): Flow<List<R>> {
        return this.asFlow().map {
            it.map { document ->
                document.mapFunc()
            }
        }
    }

    suspend fun DatabaseReference.valueEventFlow(): Flow<EventResponse> = callbackFlow {
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                trySend(EventResponse.Changed(snapshot))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(EventResponse.Cancelled(error))
            }
        }
        addValueEventListener(valueEventListener)

        awaitClose {
            removeEventListener(valueEventListener)
        }
    }
//    private suspend fun call() = withContext(Dispatchers.IO){
//        reference.valueEventFlow().collect { result ->
//            return@collect when (result) {
//                is EventResponse.Changed -> {
//                    result.snapshot
//                }
//                is EventResponse.Cancelled -> {
//                    val exception = result.error.toException()
//                }
//            }
//        }
//    }
}

sealed class EventResponse {
    data class Changed(val snapshot: DataSnapshot) : EventResponse()
    data class Cancelled(val error: DatabaseError) : EventResponse()
}