package com.openclassrooms.tajmahal.data.service;

import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.domain.model.User;

import java.util.List;

/**
 * Interface for fetching restaurant data.
 * <p>
 * Represents the API for accessing restaurant information. In a real-world application,
 * this interface might be implemented using a library like Retrofit, and would include annotations
 * specifying the HTTP methods (like GET, POST), the endpoint URL, and other API-specific details.
 * </p>
 *<p>
 * For beginners: An interface in Java is a blueprint of a class or you can say it is a collection of
 * abstract methods and static constants. In an interface, each method is public and abstract but it does
 * not contain any constructor. An interface is not a class. Writing an interface is similar to writing a class,
 * but they are two different concepts. A class describes the attributes and behaviors of an object.
 * An interface contains behaviors that a class implements.
 *
 * <p>
 * Here, {@link RestaurantApi} provides a method to get details of a restaurant.
 * </p>
 *
 *  * Interface pour récupérer les données du restaurant.
 * <p>
 * Représente l'API permettant d'accéder aux informations sur le restaurant. Dans une application réelle, cette
 * interface peut être implémentée à l'aide d'une bibliothèque comme Retrofit et inclurait des annotations
 * spécifiant les méthodes HTTP (comme GET, POST), l'URL du point de terminaison et d'autres détails spécifiques à l'API.
 * <p>
 * Pour les débutants: une interface en Java est un plan directeur d'une classe ou vous pouvez dire qu'il s'agit
 * d'une collection de méthodes abstraites et de constantes statiques. Dans une interface, chaque méthode est
 * publique et abstraite mais elle ne contient aucun constructeur. Une interface n'est pas une classe. L'écriture
 * d'une interface est similaire à l'écriture d'une classe, mais ce sont deux concepts différents. Une classe
 * décrit les attributs et les comportements d'un objet.
 * <p>
 * Une interface contient des comportements qu'une classe implémente.
 * <p>
 * Ici, {@link RestaurantApi} fournit une méthode pour obtenir les détails d'un restaurant.
 *
 * @see Restaurant
 */
public interface RestaurantApi {

    /**
     * Retrieves the details of a restaurant.
     * <p>
     * This method will usually be connected to a network call or database query in its
     * implementing class, fetching the required restaurant information.
     * </p>
     *
     * @return The {@link Restaurant} object containing all the details of the restaurant.
     */
    Restaurant getRestaurant();

    /**
     * Retrieves all the reviews of the restaurant.
     * <p>
     * This method will usually be connected to a network call or database query in its
     * implementing class, fetching the list of the existing reviews.
     * </p>
     *
     * @return The {@link Restaurant} object containing all the details of the restaurant.
     */
    List<Review> getReviews();

    /**
     * Retrieves the average rating of the restaurant.
     * <p>
     * This method adds a review to the restaurant.
     * </p>
     * @param comment
     * @param rating
     * @param avatar
     * @param userName
     */
    void addReview(String comment,Integer rating, String avatar, String userName);

    /**
     * Retrieves the user.
     */
    User getUser();
}
