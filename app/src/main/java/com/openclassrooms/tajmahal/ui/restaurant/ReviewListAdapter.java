package com.openclassrooms.tajmahal.ui.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;


/** ReviewListAdapter is an adapter class for a RecyclerView that manages a list of Review objects.
 * It binds the data of the reviews to the corresponding views using ViewHolders.
 * - The constructor initializes the empty review list.
 * - The updateList method updates the review list and notifies the RecyclerView of changes.
 * - onCreateViewHolder creates and returns a ReviewListViewHolder for an item in the list.
 * - onBindViewHolder binds the data of a Review object to the corresponding view.
 * - getItemCount returns the size of the review list.
 * ReviewListAdapter est une classe d'adaptateur pour un RecyclerView qui gère une liste d'objets Review.
 * Elle lie les données des avis aux vues correspondantes en utilisant des ViewHolder.
 *  - Le constructeur initialise la liste d'avis vide.
 *  - La méthode updateList met à jour la liste des avis et notifie le RecyclerView des changements.
 *  - onCreateViewHolder crée et retourne un ReviewListViewHolder pour un élément (item) de la liste.
 *  - onBindViewHolder lie les données d'un objet Review à la vue correspondante.
 *  - getItemCount retourne la taille de la liste d'avis.
 */
public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListViewHolder>{
    private List<Review> listReview;
    public ReviewListAdapter() {
        listReview = new ArrayList<>();
    }

    public void updateList(List<Review> listReview) {
        this.listReview = listReview;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_review_item, parent, false);
        return new ReviewListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewListViewHolder viewHolder, int position) {
        viewHolder.setReview(this.listReview.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listReview.size();
    }
}