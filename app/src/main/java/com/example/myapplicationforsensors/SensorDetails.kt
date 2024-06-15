package com.example.myapplicationforsensors

data class SensorDetails(
    val name: String,
    val vendor: String,
    val version: Int,
    val type: Int
) {
    override fun toString(): String {
        return "Nombre: $name\nFabricante: $vendor\nVersión: $version\nTipo: $type\n"
    }
}
