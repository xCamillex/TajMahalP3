package com.openclassrooms.tajmahal;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * The main application class for the TajMahal project.
 * <p>
 * This class is annotated with {@code @HiltAndroidApp}, marking it as the entry point
 * for Dagger-Hilt dependency injection. By extending the {@code Application} class
 * and annotating it with {@code @HiltAndroidApp}, Hilt will automatically generate
 * and initialize the necessary DI components and modules required for the application.
 * </p>
 * <p>
 * Developers should be cautious when adding logic to this class, as it affects the
 * entire lifecycle of the application. Generally, this class should only be used for
 * app-wide configurations and initializations.
 * </p>
 *
 * <strong>Note for beginners:</strong> Hilt is a dependency injection library for Android
 * that reduces the boilerplate code to do manual dependency injection in your project.
 * Dependency injection allows objects to receive other objects (dependencies)
 * that they need from an external source rather than creating them internally.
 *<p>
 * @see <a href="https://developer.android.com/training/dependency-injection/hilt-android">Hilt's official documentation</a>
 *<p>
 * * La classe d'application principale du projet TajMahal.
 *<p>
 * Cette classe est annotée avec {@code @HiltAndroidApp}, ce qui la marque comme point d'entrée pour
 * l'injection de dépendances Dagger-Hilt. En étendant la classe {@code Application} et en l'annotant
 * avec {@code @HiltAndroidApp}, Hilt générera et initialisera automatiquement les composants et
 * modules DI nécessaires à l'application.
 *<p>
 * Les développeurs doivent être prudents lorsqu'ils ajoutent de la logique à cette classe, car cela
 * affecte l'ensemble du cycle de vie de l'application. En général, cette classe ne doit être utilisée
 * que pour les configurations et les initialisations à l'échelle de l'application.
 *<p>
 * <strong>Remarque pour les débutants :</strong> Hilt est une bibliothèque d'injection de
 * dépendances pour Android qui réduit le code standard pour effectuer une injection de dépendances
 * manuelle dans votre projet.
 * L'injection de dépendances permet aux objets de recevoir d'autres objets (dépendances) dont ils
 * ont besoin à partir d'une source externe plutôt que de les créer en interne.
 *<p>
 * voir <a href="https://developer.android.com/training/dependency-injection/hilt-android">la documentation officielle de Hilt</a>
 */
@HiltAndroidApp
public class TajMahalApplication extends Application{}