package com.openclassrooms.tajmahal.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.openclassrooms.tajmahal.data.service.RestaurantApi;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.domain.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * This is the repository class for managing restaurant data. Repositories are responsible
 * for coordinating data operations from data sources such as network APIs, databases, etc.
 *<p>
 * Typically in an Android app built with architecture components, the repository will handle
 * the logic for deciding whether to fetch data from a network source or use data from a local cache.
 *<p>
 * * Il s'agit de la classe de référentiel pour la gestion des données de restaurant. Les référentiels sont
 * responsables de la coordination des opérations de données à partir de sources de données telles que
 * les API réseau, les bases de données, etc.
 * <p>
 * Généralement, dans une application Android créée avec des composants d'architecture, le référentiel
 * gère la logique permettant de décider s'il faut récupérer les données à partir d'une source réseau ou
 * utiliser les données d'un cache local.
 *<p>
 * @see Restaurant
 * @see RestaurantApi
 */
@Singleton
public class RestaurantRepository {

    /** The API interface instance that will be used for network requests related to restaurant data.
     * L'instance d'interface API qui sera utilisée pour les requêtes réseau liées aux données du restaurant.
     */
    private final RestaurantApi restaurantApi;

    /**
     * Constructs a new instance of {@link RestaurantRepository} with the given {@link RestaurantApi}.
     *<p>
     * @param restaurantApi The network API interface for fetching restaurant data.
     * Construit une nouvelle instance de {@link RestaurantRepository} avec le {@link RestaurantApi} donné.
     * <p>
     * @param restaurantApi L'interface API réseau pour récupérer les données du restaurant.
     */
    @Inject
    public RestaurantRepository(RestaurantApi restaurantApi) {
        this.restaurantApi = restaurantApi;
    }

    /**
     * Fetches the restaurant details.
     *<p>
     * This method will make a network call using the provided {@link RestaurantApi} instance
     * to fetch restaurant data. Note that error handling and any transformations on the data
     * would need to be managed.
     *<p>
     * @return LiveData holding the restaurant details.
     * Récupère les détails du restaurant. Cette méthode effectuera un appel réseau en utilisant
     * l'instance {@link RestaurantApi} fournie pour récupérer les données du restaurant. Notez que
     * la gestion des erreurs et toutes les transformations sur les données doivent être gérées.
     * @return LiveData contenant les détails du restaurant.
     */
    public LiveData<Restaurant> getRestaurant() {
        return new MutableLiveData<>(restaurantApi.getRestaurant());
    }

    /** Retrieves a user by calling the getUser method of the restaurantApi API and returns that user
     *  as LiveData encapsulated in a MutableLiveData object (Android library class used to store
     *  and manage observable data).
     * Récupère un utilisateur en appelant la méthode getUser de l'API restaurantApi et retourne
     * cet utilisateur sous forme de LiveData encapsulé dans un objet MutableLiveData (classe de
     * bibliothèque Android utilisée pour stocker et gérer des données observables).
     */
    public LiveData<User> getUser(){
        return new MutableLiveData<>(restaurantApi.getUser());
    }
    /**
     * This code fetches reviews via {@link RestaurantApi} and exposes them as LiveData so that the
     * UI can display them and react to updates in a simple and efficient way.
     *<p>
     * @return LiveData holding the reviews details.
     * Ce code récupère les avis via {@link RestaurantApi} et les expose sous forme de LiveData afin
     * que l'interface utilisateur puisse les afficher et réagir aux mises à jour de manière simple
     * et efficace.
     * @return LiveData contenant les détails des avis.
     */
    public LiveData<List<Review>> getReviews(){
        return new MutableLiveData<>(restaurantApi.getReviews());
    }

    /** adds a review by calling the addReview method of the restaurantApi API with the comment,
     * rating, avatar, and userName parameters.
     * Ajoute un avis en appelant la méthode addReview de l'API restaurantApi avec les paramètres
     * comment, rating, avatar, et userName.
     */
    public void addReview(String comment, Integer rating, String avatar, String userName){
        restaurantApi.addReview (comment, rating, avatar, userName);
    }

}
