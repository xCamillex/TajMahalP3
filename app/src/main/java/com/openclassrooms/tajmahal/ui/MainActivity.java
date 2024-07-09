package com.openclassrooms.tajmahal.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.ActivityMainBinding;
import com.openclassrooms.tajmahal.ui.restaurant.DetailsFragment;

import dagger.hilt.android.AndroidEntryPoint;

/** MainActivity is the main activity of the application, which initializes the view binding and
 * loads the DetailsFragment fragment on first launch.
 *The activity uses View Binding to access the views in the layout and dynamically manages fragments
 * by replacing the contents of the specified container with a new fragment.
 * MainActivity est l'activité principale de l'application, qui initialise le binding des vues et
 * charge le fragment DetailsFragment lors du premier lancement.
 * L'activité utilise View Binding pour accéder aux vues du layout et gère dynamiquement les fragments
 * en remplaçant le contenu du conteneur spécifié par un nouveau fragment.
 */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetailsFragment.newInstance())
                    .commitNow();
        }
    }

}