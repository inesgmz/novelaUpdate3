# Novela Actualizado

Novela Actualizado is an Android application for managing a personal library of novels. The app allows users to store their preferences, manage novels, and synchronize data with Firebase.

## Features

- User authentication with Firebase
- Store user preferences using `SharedPreferences`
- Manage novels with SQLite database
- Backup and restore data
- Synchronize data with Firebase
- User-specific favorites

## Classes and Important Methods

### MainActivity

- **onCreate**: Initializes Firebase, sets up the RecyclerView, and handles user authentication.

### LoginActivity

- **onCreate**: Handles user login and redirects to `MainActivity` upon successful login.

### RegistroActivity

- **onCreate**: Handles user registration and redirects to `LoginActivity` upon successful registration.

### AjustesActivity

- **onCreate**: Manages user preferences for theme settings and initiates data synchronization.
- **saveThemePreference**: Saves the user's theme preference.
- **loadThemePreference**: Loads the user's theme preference.

### AgregarResenaActivity

- **onCreate**: Sets up the UI for adding a review to a novel.
- **btnGuardarResena.setOnClickListener**: Saves the review to the selected novel.

### FavoritosActivity

- **onCreate**: Displays the user's favorite novels.
- **eliminarNovela**: Removes a novel from the favorites list.
- **mostrarNotificacionFavorito**: Handles favorite/unfavorite actions.

### NovelaAdaptador

- **onCreateViewHolder**: Inflates the appropriate layout based on the view type.
- **onBindViewHolder**: Binds data to the view holder.
- **getItemCount**: Returns the total number of items.
- **getItemViewType**: Returns the view type for the given position.
- **agregarNovela**: Adds a new novel to the list.

### NovelaRepository

- **agregarNovela**: Adds a novel to Firebase.
- **buscarNovelaPorTitulo**: Searches for a novel by title in Firebase.

### FirebaseService

- **obtenerNovelas**: Retrieves the list of novels from Firebase.

### DataSyncJobService

- **onStartJob**: Starts the data synchronization task.
- **onStopJob**: Handles job stop events.

### DataSyncReceiver

- **onReceive**: Initiates data synchronization when network connectivity is detected.

### NetworkChangeReceiver

- **onReceive**: Starts the data synchronization service when network connectivity is detected.

### SyncTask

- **doInBackground**: Performs data synchronization with Firebase in the background.
- **onPostExecute**: Displays a toast message upon completion of the synchronization.

### Novela

- **Parcelable implementation**: Allows `Novela` objects to be passed between activities.
- **resenas**: List of reviews for the novel.

### DatabaseHelper

- **onCreate**: Creates the SQLite database tables.
- **onUpgrade**: Handles database upgrades.

### PreferencesManager

- **saveThemePreference**: Saves the user's theme preference.
- **loadThemePreference**: Loads the user's theme preference.

### StorageManager

- **saveToInternalStorage**: Saves data to internal storage.
- **readFromInternalStorage**: Reads data from internal storage.
- **saveToExternalStorage**: Saves data to external storage.
- **readFromExternalStorage**: Reads data from external storage.
