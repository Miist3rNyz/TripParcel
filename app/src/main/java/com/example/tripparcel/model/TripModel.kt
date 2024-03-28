package com.example.tripparcel.model

import java.util.Date

data class TripModel(
    val id: String = "",
    val createdByUserId: String,
    val name: String,
    val firstname: String,
    val propic: String,
    val createdDate: Date,
    val destination: String,
    val destinationDate: Date,
    val startDate: Date,
    val endDate: Date,
    val baseLocation: String,
    val baseLocationDate: Date,
    val unitPrice: Int,
    val kiloAvailable: Int,
    val type: String,
    val autorisations: String,
    val description: String,
    val productAuthorized: List<String>
) {

    constructor() : this(
        id = "",
        createdByUserId = "",
        name = "",
        firstname = "",
        propic = "",
        createdDate = Date(),
        destination = "",
        destinationDate = Date(),
        startDate = Date(),
        endDate = Date(),
        baseLocation = "",
        baseLocationDate = Date(),
        unitPrice = 0,
        kiloAvailable = 0,
        type = "",
        autorisations = "",
        description = "",
        productAuthorized = listOf()
    )

    companion object Factory {
        fun create(
            id: String = "",
            createdByUserId: String,
            name: String,
            firstname: String,
            propic: String,
            createdDate: Date,
            destination: String,
            destinationDate: Date,
            startDate: Date,
            endDate: Date,
            baseLocation: String,
            baseLocationDate: Date,
            unitPrice: Int,
            kiloAvailable: Int,
            type: String,
            autorisations: String,
            description: String,
            productAuthorized: List<String>
        ): TripModel {
            return TripModel(
                id,
                createdByUserId,
                name,
                firstname,
                propic,
                createdDate,
                destination,
                destinationDate,
                startDate,
                endDate,
                baseLocation,
                baseLocationDate,
                unitPrice,
                kiloAvailable,
                type,
                autorisations,
                description,
                productAuthorized
            )
        }
    }

    fun TripModel.toHashMap(): HashMap<String, Any> {
        val map = HashMap<String, Any>()
        map["id"] = id
        map["createdByUserId"] = createdByUserId
        map["name"] = name
        map["firstname"] = firstname
        map["propic"] = propic
        map["createdDate"] = createdDate
        map["destination"] = destination
        map["destinationDate"] = destinationDate
        map["startDate"] = startDate
        map["endDate"] = endDate
        map["baseLocation"] = baseLocation
        map["baseLocationDate"] = baseLocationDate
        map["unitPrice"] = unitPrice
        map["kiloAvailable"] = kiloAvailable
        map["type"] = type
        map["autorisations"] = autorisations
        map["description"] = description
        map["productAuthorized"] = productAuthorized
        return map
    }

    fun HashMap<String, Any>.toTripModel(): TripModel {
        return TripModel(
            id = this["id"] as String,
            createdByUserId = this["createdByUserId"] as String,
            name = this["name"] as String,
            firstname = this["firstname"] as String,
            propic = this["propic"] as String,
            createdDate = this["createdDate"] as Date,
            destination = this["destination"] as String,
            destinationDate = this["destinationDate"] as Date,
            startDate = this["startDate"] as Date,
            endDate = this["endDate"] as Date,
            baseLocation = this["baseLocation"] as String,
            baseLocationDate = this["baseLocationDate"] as Date,
            unitPrice = this["unitPrice"] as Int,
            kiloAvailable = this["kiloAvailable"] as Int,
            type = this["type"] as String,
            autorisations = this["autorisations"] as String,
            description = this["description"] as String,
            productAuthorized = this["productAuthorized"] as List<String>
        )
    }
}
