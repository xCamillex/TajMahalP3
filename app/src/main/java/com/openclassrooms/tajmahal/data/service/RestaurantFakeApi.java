package com.openclassrooms.tajmahal.data.service;

import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.domain.model.User;

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
     *<p>
     * with pre-defined attributes. The object represents the "Taj Mahal" restaurant
     * with specific details.
     * </p>
     * @return The hard-coded {@link Restaurant} object for the "Taj Mahal".
     * Récupère un objet {@link Restaurant} codé en dur (intégrer directement des valeurs spécifiques
     * ou des données statiques dans le code source d'un programme) pour le "Taj Mahal". Cette
     * méthode simule un appel d'API en renvoyant immédiatement un objet Restaurant. Avec des attributs prédéfinis.
     * L'objet représente le restaurant "Taj Mahal" avec des détails spécifiques.
     * @return L'objet {@link Restaurant} codé en dur pour le "Taj Mahal".
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
     * @return The hard-coded list {@link Review} for the "Taj Mahal".
     * Récupère un objet {@link Review} codé en dur pour le "Taj Mahal". Cette méthode simule un
     * appel d'API en renvoyant immédiatement une liste d'avis avec des attributs prédéfinis.
     * @return La liste codée en dur {@link Review} pour le « Taj Mahal ».
     */
    @Override
    public List<Review> getReviews() {
        return reviews;
    }

    /** This code is an addReview method that adds a new review to a list of reviews.
     * The method first checks if the review is empty or if the rating is zero. If either of these
     * conditions is met, it returns immediately without doing anything. Otherwise, it creates a new
     * review with the information provided, adds it to a new temporary list followed by the existing
     * reviews, and then updates the list of reviews with this new list.
     * Ce code est une méthode addReview qui ajoute un nouvel avis (review) à une liste d'avis.
     * Elle accepte quatre paramètres : comment (un commentaire sous forme de chaîne de caractères),
     * rating (une note sous forme d'entier), avatar (un avatar sous forme de chaîne de caractères),
     * et userName (un nom d'utilisateur sous forme de chaîne de caractères).
     * La méthode vérifie d'abord si le commentaire est vide ou si la note est nulle. Si l'une de
     * ces conditions est remplie, elle retourne immédiatement sans rien faire. Sinon, elle crée un
     * nouvel avis que avec les informations fournies, l'ajoute à une nouvelle liste temporaire suivie
     * des avis existants, puis met à jour la liste des avis avec cette nouvelle liste.
     */
    @Override
    public void addReview (String comment, Integer rating, String avatar, String userName) {
        if (comment.isEmpty()) return; //Si le commentaire est vide, la méthode retourne immédiatement sans ajouter d'avis.
        if (rating == null) return; //Si la note est nulle, la méthode retourne immédiatement sans ajouter d'avis.
        Review review = new Review(userName, avatar, comment, rating); //Une nouvelle instance de la classe Review est créée avec les informations fournies.
        List<Review> tmp = new ArrayList<>();//Une nouvelle liste temporaire d'avis est créée.
        tmp.add(review); //Le nouvel avis est ajouté à la liste temporaire.
        tmp.addAll(reviews); //Toutes les avis existants sont ajoutées à la liste temporaire.
        reviews = tmp; //La liste des avis est mis à jour pour pointer vers la nouvelle liste temporaire contenant le nouvel avis en premier, suivie des avis existants.
    }

    /** This code overrides the getUser method in a Java class and creates a User object with
     * hardcoded values for avatar and username.
     * Ce code redéfinit la méthode getUser dans une classe en Java et crée un objet User avec des
     * valeurs codées en dur pour l'avatar et le nom d'utilisateur.
     */
    @Override
    public User getUser() {
        String avatar = "https://xsgames.co/randomusers/assets/avatars/female/1.jpg";
        String userName = "Manon Garcia";
        return new User(userName, avatar);
    }
}
