package com.openclassrooms.tajmahal.ui.restaurant;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.domain.model.User;

import javax.inject.Inject;

import java.util.Calendar;
import java.util.List;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * MainViewModel is responsible for preparing and managing the data for the {@link DetailsFragment}.
 * It communicates with the {@link RestaurantRepository} to fetch restaurant details and provides
 * utility methods related to the restaurant UI.
 *<p>
 * This ViewModel is integrated with Hilt for dependency injection.
 *<p>
 * * MainViewModel est responsable de la préparation et de la gestion des données pour le {@link DetailsFragment}.
 * Il communique avec le {@link RestaurantRepository} pour récupérer les détails du restaurant
 * et fournit des méthodes utilitaires liées à l'interface utilisateur du restaurant.
 *<p>
 * Ce ViewModel est intégré à Hilt pour l'injection de dépendances.
 */

@HiltViewModel
public class DetailsViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;

    /**
     * Constructor that Hilt will use to create an instance of MainViewModel.
     * @param restaurantRepository The repository which will provide restaurant data.
     * Constructeur que Hilt utilisera pour créer une instance de MainViewModel.
     * @param restaurantRepository Le référentiel qui fournira les données du restaurant.
     */
    @Inject
    public DetailsViewModel(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * the code initializes the "DetailsViewModel" with a "RestaurantRepository" using a
     * "RestaurantFakeApi", which allows to simulate the behavior of a real API.
     * le code initialise le "DetailsViewModel" avec un "RestaurantRepository" en utilisant un
     * "RestaurantFakeApi", ce qui permet de simuler le comportement d'une API réelle
     */
    public DetailsViewModel(){
        this.restaurantRepository = new RestaurantRepository(new RestaurantFakeApi());
    }

    /**
     * Fetches the details of the Taj Mahal restaurant.
     * @return LiveData object containing the details of the Taj Mahal restaurant.
     * Récupère les détails du restaurant Taj Mahal.
     * Objet @return LiveData contenant les détails du restaurant Taj Mahal.
     */
    public LiveData<Restaurant> getTajMahalRestaurant() {
        return restaurantRepository.getRestaurant();
    }

    /** Returns a LiveData object that contains the user's information, obtained from the restaurantRepository.
     * Renvoie un objet LiveData qui contient les informations de l'utilisateur, obtenu depuis le
     * restaurantRepository.
     */
    public LiveData<User> getUser() {
        return restaurantRepository.getUser();
    }

    /**
     * Retrieves customer review details
     * @return LiveData object containing review details.
     * Récupère les détails des avis clients
     * Objet @return LiveData contenant les détails des avis.
     */
    public LiveData<List<Review>> getReviews(){
        return restaurantRepository.getReviews();
    }

    /** Adds a new review associated with a user with a specified comment, rating and avatar, using
     * the restaurantRepository to perform the operation.
     *  Ajoute une nouvel avis associé à un utilisateur avec un commentaire, une note et un avatar
     *  spécifiés, en utilisant le restaurantRepository pour effectuer l'opération.
     */
    public void addReview(String comment, Integer rating, String avatar, String userName) {
        restaurantRepository.addReview(comment, rating, avatar, userName);
    }

    /**
     * Retrieves the current day of the week in French.
     * @return A string representing the current day of the week in French.
     * Récupère le jour actuel de la semaine en français.
     * @return Une chaîne de charactère représentant le jour actuel de la semaine en français.
     */
    public String getCurrentDay(Context context) {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayString;

        switch (dayOfWeek) {
            case Calendar.MONDAY:
                dayString = context.getString(R.string.monday);
                break;
            case Calendar.TUESDAY:
                dayString = context.getString(R.string.tuesday);
                break;
            case Calendar.WEDNESDAY:
                dayString = context.getString(R.string.wednesday);
                break;
            case Calendar.THURSDAY:
                dayString = context.getString(R.string.thursday);
                break;
            case Calendar.FRIDAY:
                dayString = context.getString(R.string.friday);
                break;
            case Calendar.SATURDAY:
                dayString = context.getString(R.string.saturday);
                break;
            case Calendar.SUNDAY:
                dayString = context.getString(R.string.sunday);
                break;
            default:
                dayString = "";
        }
        return dayString;
    }

}
