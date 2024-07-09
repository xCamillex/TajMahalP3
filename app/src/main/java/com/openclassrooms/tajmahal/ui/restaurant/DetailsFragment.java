package com.openclassrooms.tajmahal.ui.restaurant;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentDetailsBinding;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * DetailsFragment is the entry point of the application and serves as the primary UI.
 * It displays details about a restaurant and provides functionality to open its location
 * in a map, call its phone number, or view its website.
 * <p>
 * This class uses {@link FragmentDetailsBinding} for data binding to its layout and
 * {@link DetailsViewModel} to interact with data sources and manage UI-related data.
 *<p>
 * * DetailsFragment est le point d'entrée de l'application et sert d'interface utilisateur principale.
 * Il affiche les détails d'un restaurant et fournit des fonctionnalités pour ouvrir son emplacement
 * sur une carte, appeler son numéro de téléphone ou consulter son site Web.
 *<p>
 * Cette classe utilise {@link FragmentDetailsBinding} pour la liaison de données à sa mise en page
 * et {@link DetailsViewModel} pour interagir avec les sources de données et gérer les données liées
 * à l'interface utilisateur.
 */

@AndroidEntryPoint
public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    private DetailsViewModel detailsViewModel;

    /**
     * This method is called when the fragment is first created.
     * It's used to perform one-time initialization.
     *<p>
     * @param savedInstanceState A bundle containing previously saved instance state.
     * If the fragment is being re-created from a previous saved state, this is the state.
     * Cette méthode est appelée lorsque le fragment est créé pour la première fois. Elle est
     * utilisée pour effectuer une initialisation unique.
     * @param savedInstanceState Un bundle (conteneur pour les données qui doivent être transférées
     * entre différents composant d'une appli)contenant l'état d'instance précédemment enregistré. Si
     * le fragment est recréé à partir d'un état enregistré précédemment, il s'agit de l'état.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * This method is called immediately after `onCreateView()`.
     * Use this method to perform final initialization once the fragment views have been inflated.
     *<p>
     * @param view The View returned by `onCreateView()`.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * Cette méthode est appelée immédiatement après `onCreateView()`.
     * Utilisez cette méthode pour effectuer l'initialisation finale une fois que les vues de
     * fragment ont été gonflées (fait référence au processus par lequel un fichier XML est converti
     * en "View" utilisable dans le code).
     * @param view The View returned by `onCreateView()`.
     * @param savedInstanceState Si la valeur n'est pas nulle, ce fragment est reconstruit à partir
     * d'un état enregistré précédent comme indiqué ici.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI(); // Sets up user interface components.
        setupViewModel(); // Prepares the ViewModel for the fragment.
        detailsViewModel.getTajMahalRestaurant().observe(requireActivity(), this::updateUIWithRestaurant); // Observes changes in the restaurant data and updates the UI accordingly.
    }

    /**
     * Creates and returns the view hierarchy associated with the fragment.
     *<p>
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * The fragment should not add the view itself but return it.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * @return Returns the View for the fragment's UI, or null.
     * Crée et renvoie la hiérarchie de vues associée au fragment.
     * @param inflater L'objet LayoutInflater qui peut être utilisé pour gonfler toutes les vues du fragment.
     * @param container Si non nul, il s'agit de la vue parente à laquelle l'interface utilisateur
     * du fragment doit être attachée.
     * Le fragment ne doit pas ajouter la vue elle-même mais la renvoyer.
     * @param savedInstanceState Si non nul, ce fragment est en cours de reconstruction à partir
     * d'un état enregistré précédent comme indiqué ici.
     * @return Renvoie la vue de l'interface utilisateur du fragment, ou null.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false); // Binds the layout using view binding.
        return binding.getRoot(); // Returns the root view.
    }


    /**
     * Sets up the UI-specific properties, such as system UI flags and status bar color.
     * Définit les propriétés spécifiques à l'interface utilisateur, telles que les indicateurs de
     * l'interface utilisateur système et la couleur de la barre d'état.
     */
    private void setupUI() {
        Window window = requireActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * Initializes the ViewModel for this activity. Initialise le ViewModel pour cette activité.
     */
    private void setupViewModel() {
        detailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
    }

    /**
     * Updates the UI components with the provided restaurant data.
     *<p>
     * @param restaurant The restaurant object containing details to be displayed.
     * Met à jour les composants de l'interface utilisateur avec les données de restaurant fournies.
     * @param restaurant L'objet restaurant contenant les détails à afficher.
     */
    private void updateUIWithRestaurant(Restaurant restaurant) {
        if (restaurant == null) return;

        binding.tvRestaurantName.setText(restaurant.getName());
        binding.tvRestaurantDay.setText(detailsViewModel.getCurrentDay(requireContext()));
        binding.tvRestaurantType.setText(String.format("%s %s", getString(R.string.restaurant), restaurant.getType()));
        binding.tvRestaurantHours.setText(restaurant.getHours());
        binding.tvRestaurantAddress.setText(restaurant.getAddress());
        binding.tvRestaurantWebsite.setText(restaurant.getWebsite());
        binding.tvRestaurantPhoneNumber.setText(restaurant.getPhoneNumber());
        binding.chipOnPremise.setVisibility(restaurant.isDineIn() ? View.VISIBLE : View.GONE);
        binding.chipTakeAway.setVisibility(restaurant.isTakeAway() ? View.VISIBLE : View.GONE);

        binding.buttonAdress.setOnClickListener(v -> openMap(restaurant.getAddress()));
        binding.buttonPhone.setOnClickListener(v -> dialPhoneNumber(restaurant.getPhoneNumber()));
        binding.buttonWebsite.setOnClickListener(v -> openBrowser(restaurant.getWebsite()));

        /** Observe changes in a list of reviews using a LiveData in a ViewModel. When a review
         * update occurs, it calculates the number of reviews for each rating from 1 to 5 stars and
         * updates the corresponding progress bars.
         * - total stores the total number of reviews.
         * - The variables reviewFiveStars, reviewFourStars, reviewThreeStars, reviewTwoStars, and
         * reviewOneStar initialized to zero count the reviews for each rating.
         * - Loops through each review and increments the corresponding counter based on the review
         * rating (review.getRate()).
         * - Updates the progress bars for each review rating with the number of corresponding reviews.
         * - setProgress sets the number of reviews for that rating.
         * - setMax sets the total number of reviews so that the progress bar is proportional to the total.
         * Observe les changements dans une liste d'avis à l'aide d'un LiveData dans un ViewModel.
         * Lorsqu'une mise à jour des avis se produit, il calcule le nombre d'avis pour chaque note
         * de 1 à 5 étoiles et met à jour les barres de progression correspondantes.
         * - total stocke le nombre total d'avis.
         * - Les variables reviewFiveStars, reviewFourStars, reviewThreeStars, reviewTwoStars et
         * reviewOneStar initialisées à zéro comptent les avis pour chaque note.
         * - Parcoure chaque avis et incrémente le compteur correspondant en fonction de la note de
         * l'avis (review.getRate()).
         * - Met à jour les barres de progression pour chaque note d'avis avec le nombre d'avis
         * correspondants.
         * - setProgress définit le nombre d'avis pour cette note.
         * - setMax définit le nombre total d'avis pour que la barre de progression soit
         * proportionnelle au total.
         */
        detailsViewModel.getReviews().observe(this, reviews -> {
        int total = reviews.size();
        int reviewFiveStars = 0;
        int reviewFourStars = 0;
        int reviewThreeStars = 0;
        int reviewTwoStars = 0;
        int reviewOneStar = 0;

        for (Review review:reviews) {
            if (review.getRate() == 5){
                reviewFiveStars += 1;
            } else if (review.getRate() == 4) {
                reviewFourStars +=1;
            } else if (review.getRate() == 3) {
                reviewThreeStars +=1;
            } else if (review.getRate() == 2) {
                reviewTwoStars +=1;
            }  else if (review.getRate() == 1) {
                reviewOneStar +=1;
            }
        }
        binding.progressFive.setProgress(reviewFiveStars);
        binding.progressFive.setMax(total);

        binding.progressFour.setProgress(reviewFourStars);
        binding.progressFour.setMax(total);

        binding.progressThree.setProgress(reviewThreeStars);
        binding.progressThree.setMax(total);

        binding.progressTwo.setProgress(reviewTwoStars);
        binding.progressTwo.setMax(total);

        binding.progressOne.setProgress(reviewOneStar);
        binding.progressOne.setMax(total);
    });

    binding.tvLeaveReview.setOnClickListener(v -> {
        changeFragment ();
    });

    }

    /** The changeFragment method replaces the current fragment with a new instance of ReviewFragment.
     * The fragment transaction is added to allow back navigation when clicking the arrow.
     * La méthode changeFragment remplace le fragment actuel par une nouvelle instance de ReviewFragment.
     */
    private void changeFragment(){
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ReviewFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    /**
     * Opens the provided address in Google Maps or shows an error if Google Maps
     * is not installed.
     *<p>
     * @param address The address to be shown in Google Maps.
     * Ouvre l'adresse fournie dans Google Maps ou affiche une erreur si Google Maps n'est pas installé.
     * @param address L'adresse à afficher dans Google Maps.
     */
    private void openMap(String address) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(requireActivity(), R.string.maps_not_installed, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Dials the provided phone number or shows an error if there's no dialing application
     * installed.
     *<p>
     * @param phoneNumber The phone number to be dialed.
     * Compose le numéro de téléphone fourni ou affiche une erreur si aucune application de
     * numérotation n'est installée.
     * @param phoneNumber Le numéro de téléphone à composer.
     */
    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(requireActivity(), R.string.phone_not_found, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Opens the provided website URL in a browser or shows an error if there's no
     * browser installed.
     *<p>
     * @param websiteUrl The URL of the website to be opened.
     * Ouvre l'URL du site Web fourni dans un navigateur ou affiche une erreur si aucun navigateur
     * n'est installé.
     * @param websiteUrl L'URL du site Web à ouvrir.
     */
    private void openBrowser(String websiteUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(requireActivity(), R.string.no_browser_found, Toast.LENGTH_SHORT).show();
        }
    }

    /** Creates and returns a new instance of DetailsFragment.
     * Crée et retourne une nouvelle instance de DetailsFragment.
     */
    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

}