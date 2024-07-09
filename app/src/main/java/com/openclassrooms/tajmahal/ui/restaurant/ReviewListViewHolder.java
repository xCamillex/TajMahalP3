package com.openclassrooms.tajmahal.ui.restaurant;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.databinding.FragmentReviewItemBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

/** ReviewListViewHolder is a ViewHolder class for a RecyclerView that binds the data of a Review to
 * a review list view. It uses View Binding to access the views in the list item's layout and Glide
 * to load images efficiently.
 * - The constructor initializes the View Binding for the list item.
 * - The setReview method binds the properties of a Review object to the corresponding views in the
 * layout.
 * ReviewListViewHolder est une classe ViewHolder pour un RecyclerView qui lie les données d'un
 * Review à une vue de liste d'avis. Elle utilise View Binding pour accéder aux vues du layout de
 * l'élément de la liste (FragmentReviewItem) et Glide pour charger les images de manière efficace.
 * (bibliothèque de gestion d'images conçue pour simplifier le chargement et l'affichage d'images)
 * - Le constructeur initialise le View Binding pour l'élément de la liste.
 * - La méthode setReview lie les propriétés d'un objet Review aux vues correspondantes dans le layout.
 */
public class
ReviewListViewHolder extends RecyclerView.ViewHolder {
    private Review review;
    private FragmentReviewItemBinding binding;
    public ReviewListViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = FragmentReviewItemBinding.bind(itemView);
    }

    public void setReview(Review review) {
        this.review = review;
        binding.tvReviewComment.setText(review.getComment());
        Glide.with(binding.ivItemAvatar.getContext())
                .load(review.getPicture())
                .centerCrop()
                .into(binding.ivItemAvatar);
        binding.tvItemName.setText(review.getUsername());
        binding.rbItemRate.setRating(review.getRate());
    }
}

