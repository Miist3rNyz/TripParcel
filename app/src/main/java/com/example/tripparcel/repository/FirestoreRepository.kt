package com.example.tripparcel.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions


class GenericRepository<T : Any>(private val collectionRef: CollectionReference, private val kClass: Class<T>) {

    private val firestoreInstance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    fun addData(data: Map<String, Any>, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        collectionRef
            .add(data)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener(onFailure)
    }

    fun getData(onSuccess: (List<T>) -> Unit, onFailure: (Exception) -> Unit) {
        collectionRef
            .get()
            .addOnSuccessListener { result ->
                val dataList = result.documents.mapNotNull { it.toObject(kClass) }
                onSuccess(dataList)

            }
            .addOnFailureListener(onFailure)
    }

    fun getDataWithDetail(queryCriteria: (CollectionReference) -> Query, onSuccess: (List<T>) -> Unit, onFailure: (Exception) -> Unit) {
        queryCriteria(collectionRef).get()
            .addOnSuccessListener { result ->
                val dataList = result.toObjects(kClass)
                onSuccess(dataList)
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }

    fun updateData(id: String, data: Map<String, Any>, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        collectionRef
            .document(id)
            .set(data, SetOptions.merge())
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener(onFailure)
    }

    fun deleteData(id: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        collectionRef
            .document(id)
            .delete()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener(onFailure)
    }

    fun listenToDataUpdates(onDataUpdate: (List<T>) -> Unit, onFailure: (Exception) -> Unit) {
        collectionRef
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    onFailure(exception)
                    return@addSnapshotListener
                }

                val dataList = snapshot?.toObjects(kClass) ?: emptyList()
                onDataUpdate(dataList)
            }
    }
}
