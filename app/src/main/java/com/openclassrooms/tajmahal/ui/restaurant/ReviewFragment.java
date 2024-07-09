package com.openclassrooms.tajmahal.ui.restaurant;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentReviewBinding;
import com.openclassrooms.tajmahal.domain.model.User;

import java.util.Objects;

/**Fragment that displays a list of reviews and allows the user to add a new review.
 * Uses DetailsViewModel to manage data and UI interactions.
 * Fragment qui affiche une liste d'avis et permet à l'utilisateur d'ajouter un nouvel avis.
 * Utilise DetailsViewModel pour gérer les données et les interactions avec l'interface utilisateur.
 */
public class ReviewFragment extends Fragment {

   private ReviewListAdapter reviewListAdapter;
   private DetailsViewModel detailsViewModel;

   private FragmentReviewBinding binding;

    public ReviewFragment() {
        // Required empty public constructor
    }

    /** Creates a new instance of ReviewFragment with optional arguments.
     * Uses a Bundle to pass data between fragments.
     * Crée une nouvelle instance de ReviewFragment avec des arguments facultatifs.
     * Utilise un Bundle pour passer des données entre fragments (c'est un conteneur utilisé pour
     * stocker les données qui doivent être transférées entre différent composant de l'application) .
     */
    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /** Inflates the layout of the fragment, initializes the RecyclerView to display notices, and
     * sets up observers for data updates.
     * Gonfle la vue du fragment (processus par lequel un fichier XML est converti en une "view"
     * utilisable dans le code), initialise le RecyclerView pour afficher les avis, et configure
     * les observateurs pour les mises à jour de données.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReviewBinding.inflate(inflater, container, false);
        reviewListAdapter = new ReviewListAdapter();
        binding.fragmentReviewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.fragmentReviewRecyclerView.setAdapter(reviewListAdapter);
            setupViewModel();
            updateUI();
            setupAddReview();
            setupAvatar();

            binding.buttonBack.setOnClickListener(view -> {
                returnFragment();
            });
        return binding.getRoot();
    }

    /** Replaces the current fragment with a new instance of DetailsFragment
     * Remplace le fragment actuel par une nouvelle instance de DetailsFragment
     */
    private void returnFragment(){
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    /** Sets the display of the user's avatar and name in the UI.
     * Uses detailsViewModel to get the user's information through a LiveData object.
     * When the user's data is updated:
     * - Uses Glide to load and display the user's avatar in the corresponding ImageView.
     * - Displays the user's name in the associated TextView.
     * Configure l'affichage de l'avatar et du nom de l'utilisateur dans l'interface utilisateur.
     * Utilise detailsViewModel pour obtenir les informations de l'utilisateur à travers un objet LiveData.
     * Lorsque les données de l'utilisateur sont mises à jour :
     * - Utilise Glide pour charger et afficher l'avatar de l'utilisateur dans l'ImageView correspondant.
     * - Affiche le nom de l'utilisateur dans le TextView associé.
     */
    private void setupAvatar() {
        // Appeler le detailViewModel getUser()
        LiveData<User> user = detailsViewModel.getUser();
        user.observe(getViewLifecycleOwner(), user1 -> {
            //avec glide mettre en place l'avatar dans l'ui
            Glide.with(binding.ivNewReviewAvatar.getContext())
                    .load(user1.getPictureUrl())
                    .centerCrop()
                    .into(binding.ivNewReviewAvatar);
            binding.tvNewReviewName.setText(user1.getUserName());
        });
    }

    /** Sets the click handler for the validation button. When the button is clicked:
     * - Retrieves the user-entered comment and rating from the associated views.
     * - Validates that the comment is not empty and that the rating is non-zero.
     * - Displays appropriate toast messages if the input is invalid.
     * - Uses the detailsViewModel to add the review with the user's default data.
     * - Updates the UI after the review is added.
     * - Resets the comment and rating input fields.
     * Configure le gestionnaire de clics pour le bouton de validation. Lorsque le bouton est cliqué :
     * - Récupère le commentaire et la note saisis par l'utilisateur depuis les vues associées.
     * - Valide que le commentaire n'est pas vide et que la note est différent de zéro.
     * - Affiche des messages Toast appropriés en cas de saisie invalide.
     * - Utilise detailsViewModel pour ajouter l'avis avec les données par défaut de l'utilisateur.
     * - Met à jour l'interface utilisateur après l'ajout de l'avis.
     * - Réinitialise les champs de saisie de commentaire et de note.
     */
    private void setupAddReview() {
        binding.buttonValidate.setOnClickListener(
                arg -> {
                    String comment = String.valueOf(Objects.requireNonNull(binding.tietNewReviewComment.getText()));
                    float rating = binding.rbNewReviewRate.getRating();

                    if (comment.isEmpty() && (rating == 0)){
                        Toast.makeText(getContext(), R.string.please_enter_a_comment_or_provide_a_rating, Toast.LENGTH_SHORT).show();
                        return;
                    } else if (comment.isEmpty()){
                        Toast.makeText(getContext(), R.string.please_enter_a_comment, Toast.LENGTH_SHORT).show();
                        return;
                    } else if (rating == 0){
                        Toast.makeText(getContext(), R.string.please_provide_a_rating

                                , Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Appeler le detailViewModel getUser()
                    String avatar = "https://xsgames.co/randomusers/assets/avatars/female/1.jpg";
                    String userName = "Manon Garcia";
                    detailsViewModel.addReview(comment, (int) rating, avatar, userName);
                    updateUI();

                    binding.tietNewReviewComment.setText("");
                    binding.rbNewReviewRate.setRating(0);
                }
        );
    }

    /** Updates the UI by observing changes in the list of reviews obtained from detailsViewModel.
     * When the list is updated, it is passed to reviewListAdapter to display the new data.
     * Met à jour l'interface utilisateur en observant les changements dans la liste des avis
     * obtenue depuis detailsViewModel. Lorsque la liste est mise à jour, elle est transmise à
     * reviewListAdapter pour afficher les nouvelles données.
     */
    private void updateUI (){
        detailsViewModel.getReviews().observe(getViewLifecycleOwner(), reviews -> {
            Log.d("TEST", "updateUI: "+reviews.size());
            reviewListAdapter.updateList(reviews);
        });
    }

    /**
     * Initialize and configure detailsViewModel using ViewModelProvider to get an instance of
     * DetailsViewModel, attached to this fragment.
     * Initialise et configure detailsViewModel en utilisant ViewModelProvider pour obtenir une
     * instance de DetailsViewModel, attachée à ce fragment.
     */
    private void setupViewModel(){
        detailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
    }
}