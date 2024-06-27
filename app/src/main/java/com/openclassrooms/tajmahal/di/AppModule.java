package com.openclassrooms.tajmahal.di;

import com.openclassrooms.tajmahal.data.service.RestaurantApi;
import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/**
 * AppModule is responsible for providing application-level dependencies
 * for the entire app. This module is installed in the SingletonComponent
 * ensuring that the provided instances are retained throughout the app's lifecycle.
 *<p>
 * * AppModule est responsable de la fourniture des dépendances au niveau de l'application pour
 * l'ensemble de l'application. Ce module est installé dans le composant Singleton, garantissant
 * que les instances fournies sont conservées tout au long du cycle de vie de l'application.
 */

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    /**
     * Provides a singleton instance of the RestaurantApi. In this example,
     * a fake implementation of the API is being used, which can be helpful
     * during testing or mock scenarios.
     *
     * @return A singleton instance of the RestaurantFakeApi.
     */
    @Provides
    @Singleton
    public RestaurantApi provideRestaurantApi() {
        return new RestaurantFakeApi();
    }
}
