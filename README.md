# Echo - A Minimalist Journaling App

**Echo** is a modern, minimalist journaling application built with Kotlin and Jetpack Compose. It allows users to record their daily thoughts, track their moods, and maintain a personal digital diary with ease and style.

## 🚀 Features

-   **Daily Journaling:** Create, read, and edit journal entries.
-   **Mood Tracking:** Associate your entries with how you're feeling using a selection of emojis.
-   **Swipe-to-Delete:** Intuitive gesture-based management of your journal entries.
-   **Dynamic Greetings:** The app greets you based on the time of day (Morning, Afternoon, Evening).
-   **Elegant UI:** Built with Material 3, featuring smooth transitions and a clean, focused aesthetic.
-   **Offline First:** All your data is stored locally on your device using a Room database.

## 🛠 Tech Stack

-   **Language:** [Kotlin](https://kotlinlang.org/)
-   **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
-   **Architecture:** MVVM (Model-View-ViewModel)
-   **Database:** [Room Persistence Library](https://developer.android.com/training/data-storage/room)
-   **Navigation:** [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
-   **Dependency Management:** Gradle Version Catalogs (libs.versions.toml)

## 📁 Project Structure

The project follows a clean architecture approach organized by layers:

-   `data/`: Contains the Room database configuration, DAOs, entities (`JournalEntry`), and the repository.
-   `viewmodel/`: Contains the `JournalViewModel` which manages UI state and interacts with the repository.
-   `ui/`:
    -   `screens/`: Individual Compose screens (`HomeScreen`, `AddEditScreen`, `DetailScreen`, `AboutScreen`).
    -   `theme/`: Material 3 theme definitions (Color, Type, etc.).
-   `navigation/`: Defines the app's navigation graph and screen routes.

## 📸 Screenshots

| Home Screen | Add Entry |
| :---: | :---: |
| ![Home](https://via.placeholder.com/200x400?text=Home+Screen) | ![Add Entry](https://via.placeholder.com/200x400?text=Add+Entry) |

## 🏗 Setup & Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/journal-app.git
    ```
2.  **Open in Android Studio:**
    Open the project in Android Studio (Ladybug or newer recommended).
3.  **Sync Gradle:**
    Allow the IDE to sync the project dependencies.
4.  **Run:**
    Connect an Android device or start an emulator and click the "Run" button.

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.
