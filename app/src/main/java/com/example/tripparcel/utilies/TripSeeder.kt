package com.example.tripparcel.utilities

import com.example.tripparcel.repository.GenericRepository
import java.util.*
import kotlin.random.Random

fun <T : Any> seedTripToFirestore(tripRepository: GenericRepository<T>) {
    val userIds = listOf("user1", "user2", "user3") // Exemple d'IDs d'utilisateurs

    // Générer et ajouter 5 voyages
    for (i in 1..5) {
        val calendar = Calendar.getInstance()

        val createdByUserId = userIds[Random.nextInt(userIds.size)]
        val createdDate = Date()

        calendar.add(Calendar.DAY_OF_YEAR, Random.nextInt(1, 30))
        val destinationDate = calendar.time

        val startDate = calendar.time
        calendar.add(Calendar.DAY_OF_YEAR, Random.nextInt(1, 10))
        val endDate = calendar.time

        calendar.add(Calendar.DAY_OF_YEAR, -Random.nextInt(10, 20))
        val baseLocationDate = calendar.time

        val participants = userIds.shuffled().take(2) // Prendre au hasard 2 participants

        // Créer un nouveau voyage sous forme de HashMap
        val newTrip = hashMapOf(
            "createdByUserId" to createdByUserId,
            "createdDate" to createdDate,
            "name" to "Name $i",
            "firstname" to "Firstname $i",
            "propic" to "Propic $i",
            "destination" to "Destination $i",
            "destinationDate" to destinationDate,
            "startDate" to startDate,
            "endDate" to endDate,
            "baseLocation" to "Base Location $i",
            "baseLocationDate" to baseLocationDate,
            "unitPrice" to Random.nextInt(100, 500),
            "kiloAvailable" to Random.nextInt(100, 500),
            "type" to "Type $i",
            "autorisations" to "Autorisations $i",
            "description" to "Description of event $i",
            "productAuthorized" to listOf("Product1", "Product2")
        )

        // Ajouter le voyage à Firestore
        tripRepository.addData(
            data = newTrip,
            onSuccess = { println("Voyage $i ajouté avec succès.") }
        ) { exception -> println("Erreur lors de l'ajout du voyage $i: ${exception.message}") }
    }
}
