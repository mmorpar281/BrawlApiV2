package com.example.brawlapi

data class Brawler (

    val nombre: String,      // Nombre del Brawler
    val rareza: String,      // Rareza (Común, Especial, Épico, etc.)
    val descripcion: String, // Breve descripción del Brawler
    val imagen: String       // URL de la imagen del Brawler
)