# Pokedex (Pokémon) Android App

## Introduction
The Pokedex Android app consumes the free PokeAPI, a RESTful API providing extensive Pokémon-related data. This includes Pokémon species, abilities, types, evolutions, and other details essential for applications centered around the Pokémon franchise.

This app demonstrates how to fetch, display, and navigate Pokémon data using modern Android development practices, emphasizing Jetpack Compose for UI, MVVM architecture, and clean, maintainable code.

## Minimum Requirements
- Android Studio with JDK 17
- Android Gradle Plugin 8.13.0
- Kotlin 2.2.10
- Minimum SDK 29
- Compile SDK 36
- Target SDK 36

## Setup Instructions

- Clone the repository
- Open the project in Android Studio.
- Ensure Gradle offline mode is disabled to sync all dependencies.
- Build and run the project on an emulator or device running Android 10 (API 29) or above.


## Tech Stack

Architecture

* MVVM (Model-View-ViewModel) – Ensures separation of concerns, testability, and maintainability.
  - This project has been implemented using a combination of tools and resources, some of which are;
* UI
  - Jetpack Compose – Modern declarative UI toolkit for building responsive, dynamic, and performant interfaces.
* Dependency Injection
  - Dagger Hilt – Standardized DI for Android, simplifying object graph management.
* Networking
  - Retrofit – Type-safe HTTP client for API consumption.
  - OkHttp & Logging Interceptor – Handles networking and logging of API requests/responses.
  - Moshi – Kotlin-friendly JSON serialization/deserialization.
* Image Loading
  - Glide Compose & Coil Compose – Efficient image loading and caching in Compose.
* State Management & Asynchronous Operations
  - Kotlin Coroutines & Flow – For asynchronous operations and reactive data streams.
* Lifecycle & Navigation
  - AndroidX Lifecycle – Lifecycle-aware components for Compose.
  - Navigation Compose & Material Navigation – Smooth in-app navigation with Compose.
    Animations
* Lottie Compose – Integrates Lottie animations for dynamic UI experiences.

* Logging
  - Timber – Simplified logging for debugging.
* Testing
  - JUnit & AndroidX Test – Unit and instrumentation testing.
  - MockK & Mockito – Mocking frameworks for reliable tests.
  - Turbine & Truth – Utilities for testing flows and assertions.
* CI/CD
  - GitHub Actions – Automated builds, tests, and deployment pipelines.

# Screenshots

<p align="center">
<img width="40%" alt="Screenshot_20250912_102323" src="https://github.com/user-attachments/assets/3c354234-121b-41fb-aa2e-7c33c8d171e7" style="centre">
<img width="40%" alt="Screenshot_20250912_102333" src="https://github.com/user-attachments/assets/76e53e6a-ce44-4e96-a31d-d48230c9dfb8" style="centre">
</p>
