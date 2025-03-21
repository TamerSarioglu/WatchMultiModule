﻿# WatchMultiModule

A modern Android application built with a multi-module architecture, showcasing best practices in Android development.

## 🌟 Features

- **Home**: Browse through a curated list of movies
- **Details**: View detailed information about selected movies
- **Search**: Search functionality for finding specific movies
- **Favorites**: Save and manage your favorite movies

## 🏗 Architecture

This project follows a multi-module clean architecture approach:

### App Modules
- `app`: Main application module
- `feature`: Contains feature modules
- `home`: Home screen implementation
- `details`: Movie details screen
- `search`: Search functionality
- `favorites`: Favorites management

### Core Modules
- `core`
- `ui`: Common UI components and resources
- `common`: Shared utilities and extensions
- `data`: Data layer implementation
- `domain`: Business logic and use cases
- `navigation`: Navigation components

## 🛠 Tech Stack

- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern UI toolkit
- **Hilt**: Dependency injection
- **Multi-module Architecture**: Scalable and maintainable project structure
- **Clean Architecture**: Separation of concerns
- **Gradle KTS**: Build configuration with Kotlin DSL
- **TMDB API**: Movie data source

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11 or later
- Android SDK
- TMDB API Key (Get it from [TMDB Website](https://www.themoviedb.org/settings/api))

### Setup
1. Clone the repository:
```bash
git clone https://github.com/TamerSarioglu/WatchMultiModule
```

2. Add your TMDB API key to `local.properties`:
```properties
TMDB_API_KEY=your_api_key_here
```

3. Open the project in Android Studio

4. Sync the project with Gradle files

5. Run the app on an emulator or physical device

## 🤝 Contributing

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License

## 👤 Author

Your Name - [@YourTwitter](https://twitter.com/tamerthedark)

Project Link: [https://github.com/TamerSarioglu/WatchMultiModule](https://github.com/TamerSarioglu/WatchMultiModule)
