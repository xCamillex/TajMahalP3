package com.openclassrooms.tajmahal;

import org.junit.Test;

import static org.junit.Assert.*;

import com.openclassrooms.tajmahal.data.service.RestaurantApi;
import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /** The goal of this test is to verify that the "getReviews" method of the "RestaurantFakeApi"
     * implementation returns exactly 5 reviews.
     * Le but de ce test est de verifier que la méthode « getReviews » de l’implémentation
     * « RestaurantFakeApi » retourne exactement 5 avis.
     */
    @Test
    public void countReview() {
        RestaurantApi api = new RestaurantFakeApi();
        int reviewsCount = api.getReviews().size();
        assertEquals(5, reviewsCount);
    }

    /** Checks that when trying to add a review with an empty comment, the review is not added and
     * the total number of reviews should remain at 5.
     * Vérifie que lorsqu’on tente d’ajouter un avis avec un commentaire vide, l’avis n’est pas
     * ajouté et le nombre total d’avis doit rester à 5.
     */
    @Test
    public void addEmptyCommentReview(){
        RestaurantApi api = new RestaurantFakeApi();
        api.addReview("",0,"","");
        assertEquals(5,api.getReviews().size());
    }

    /** Checks that when trying to add a review with a zero rating, the review is not added and the
     * total number of reviews should remain at 5.
     * Vérifie que lorsqu'on tente d'ajouter un avis avec une note nulle, l’avis n’est pas ajouté
     * et le nombre total d’avis doit rester à 5.
     */
    @Test
    public void addEmptyRatingReview (){
        RestaurantApi api = new RestaurantFakeApi();
        api.addReview("comment",null,"","");
        assertEquals(5,api.getReviews().size());
    }

    /** Check that adding a review with a comment, a rating of 4, an avatar and a user “Manon Garcia”
     * increases the number of reviews in the “RestaurantApi” by 1 going from 5 to 6.
     * Vérifie que l’ajout d’un avis avec un commentaire, une note de 4, un avatar et un utilisateur
     * « Manon Garcia » augmente le nombre d’avis dans le « RestaurantApi » de 1 passant de 5 à 6.
     */
    @Test
    public  void addReview(){
        RestaurantApi api = new RestaurantFakeApi();
        api.addReview("comment",4,"","Manon Garcia");
        assertEquals(6,api.getReviews().size());
    }
}
