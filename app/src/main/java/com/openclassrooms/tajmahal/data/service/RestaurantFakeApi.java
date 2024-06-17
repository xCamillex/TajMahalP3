package com.openclassrooms.tajmahal.data.service;

import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A mock implementation of the {@link RestaurantApi} for testing and development purposes.
 * <p>
 * This class simulates an API by returning a hard-coded {@link Restaurant} object, eliminating the
 * need for real network or database calls. Such fake or mock implementations are commonly used in
 * unit testing and when prototyping an application.
 * </p>
 * <p>
 * For beginners: In software development, a mock is a simulated version of an external system
 * (like an API). Mocks are used to isolate and test certain parts of the software without
 * depending on external systems. By using a mock, developers can simulate how the real system
 * would behave. In this case, instead of making a real API call to get restaurant details,
 * we are using hardcoded values.
 *
 * <p>
 * This class returns details of a specific restaurant, "Taj Mahal", with pre-defined attributes.
 * </p>
 *
 *  * * Une implémentation fictive de {@link RestaurantApi} à des fins de test et de développement.
 *  *
 *  * Cette classe simule une API en renvoyant un objet {@link Restaurant} codé en dur, éliminant ainsi
 *  * le besoin d'appels réels au réseau ou à la base de données. De telles implémentations factices ou
 *  * fictives sont couramment utilisées dans les tests unitaires et lors du prototypage d'une application.
 *  *
 *  * * Pour les débutants: dans le développement de logiciels, un mock est une version simulée
 *  * d'un système externe (comme une API). Les mocks sont utilisés pour isoler et tester certaines
 *  * parties du logiciel sans dépendre de systèmes externes. En utilisant un mock, les développeurs
 *  * peuvent simuler le comportement du système réel. Dans ce cas, au lieu de faire un véritable appel
 *  * d'API pour obtenir les détails du restaurant, nous utilisons des valeurs codées en dur.
 *  *
 *  * Cette classe renvoie les détails d'un restaurant spécifique, "Taj Mahal", avec des attributs prédéfinis.
 *  *
 * @see Restaurant
 * @see RestaurantApi
 */
public class RestaurantFakeApi implements RestaurantApi {

    List<Review> reviews = Arrays.asList(
            new Review("Ranjit Singh", "https://xsgames.co/randomusers/assets/avatars/male/71.jpg", "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!", 5),
            new Review("Martyna Siddeswara", "https://xsgames.co/randomusers/assets/avatars/female/31.jpg", "Un service excellent et des plats incroyablement savoureux. Nous sommes vraiment satisfaits de notre expérience au restaurant.", 4),
            new Review("Komala Alanazi", "https://xsgames.co/randomusers/assets/avatars/male/46.jpg", "La cuisine est délicieuse et le service est également excellent. Le propriétaire est très sympathique et veille toujours à ce que votre repas soit satisfaisant. Cet endroit est un choix sûr!", 5),
            new Review("David John", "https://xsgames.co/randomusers/assets/avatars/male/67.jpg", "Les currys manquaient de diversité de saveurs et semblaient tous à base de tomates. Malgré les évaluations élevées que nous avons vues et nos attentes, nous avons été déçus.", 2),
            new Review("Emilie Hood", "https://xsgames.co/randomusers/assets/avatars/female/20.jpg", "Très bon restaurant Indien ! Je recommande.", 4)
    );


    /**
     * Retrieves a hard-coded {@link Restaurant} object for the "Taj Mahal".
     * <p>
     * This method simulates an API call by immediately returning a Restaurant object
     * with pre-defined attributes. The object represents the "Taj Mahal" restaurant
     * with specific details.
     * </p>
     *
     * @return The hard-coded {@link Restaurant} object for the "Taj Mahal".
     */
    @Override
    public Restaurant getRestaurant() {
        return new Restaurant("Taj Mahal", "Indien", "11h30 - 14h30・18h30 - 22h00",
                "12 Avenue de la Brique - 75010 Paris", "http://www.tajmahal.fr", "06 12 34 56 78",
                true, true);
    }


    /**
     * Retrieves a hard-coded {@link Review} object for the "Taj Mahal".
     * <p>
     * This method simulates an API call by immediately returning a Review list
     * with pre-defined attributes.
     * </p>
     *
     * @return The hard-coded list {@link Review} for the "Taj Mahal".
     */
    @Override
    public List<Review> getReviews() {
        return reviews;
    }

}
