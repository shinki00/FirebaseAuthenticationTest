package com.example.s.firebaseauthenticationtest.seivice

interface AccountService {
    suspend fun authenticate(email: String, password: String)
    suspend fun createUserWithEmailAndPassword(email: String, password: String)
}