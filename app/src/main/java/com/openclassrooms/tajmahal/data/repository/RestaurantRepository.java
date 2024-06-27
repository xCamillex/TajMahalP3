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

    // The API interface instance that will be used for network requests related to restaurant data.
    private final RestaurantApi restaurantApi;

    /**
     * Constructs a new instance of {@link RestaurantRepository} with the given {@link RestaurantApi}.
     *<p>
     * @param restaurantApi The network API interface for fetching restaurant data.
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
     */
    public LiveData<Restaurant> getRestaurant() {
        return new MutableLiveData<>(restaurantApi.getRestaurant());
    }

    public LiveData<User> getUser(){
        return new MutableLiveData<>(restaurantApi.getUser());
    }
    /**
     * This code fetches reviews via {@link RestaurantApi} and exposes them as LiveData so that the
     * UI can display them and react to updates in a simple and efficient way.
     *<p>
     * @return LiveData holding the reviews details.
     */
    public LiveData<List<Review>> getReviews(){
        return new MutableLiveData<>(restaurantApi.getReviews());
    }

    public void addReview(String comment, Integer rating, String avatar, String userName){
        restaurantApi.addReview (comment, rating, avatar, userName);
    }

}
