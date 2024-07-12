package com.openclassrooms.tajmahal.domain.model;

import java.util.List;

/**
 *  Utility class for handling operations related to reviews, including calculating the average
 *  rating from a list of reviews.
 * Classe utilitaire pour gérer les opérations liées aux avis, notamment le calcul de la note
 * moyenne à partir d'une liste d'avis.
 */
public class ReviewUtils {

    /**
     * Calculates the average rating from a list of reviews.
     * Returns 0.0f if the list is null or empty.
     * @param reviews The list of reviews to calculate the average rating from.
     * @return The average rating of the reviews, or 0.0f if the list is null or empty.
     * Calcule la note moyenne à partir d'une liste d'avis.
     * Renvoie 0,0f si la liste est nulle ou vide.
     * @param reviews La liste des avis à partir de laquelle calculer la note moyenne.
     * @return La note moyenne des avis, ou 0,0f si la liste est nulle ou vide.
     */
    public static float calculateAverageRating(List<Review> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0f;
        }

        float sum = 0.0f;
        for (Review review : reviews) {
            sum += review.getRate();
        }

        return sum / reviews.size();
    }
}