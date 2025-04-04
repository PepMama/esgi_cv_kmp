package com.example.quiz

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform