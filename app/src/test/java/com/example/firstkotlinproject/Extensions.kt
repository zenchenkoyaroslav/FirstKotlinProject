package com.example.firstkotlinproject

import org.mockito.Mockito

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)