package com.openclassrooms.tajmahal.domain.model;

import java.util.List;
import java.util.Objects;


/**
 * Represents a user review.
 * This class encapsulates all the details of a review, including the username of the reviewer,
 * their profile picture, the comment they left, and the rating they gave.
 *<p>
 * * Représente un avis d'utilisateur.
 * Cette classe encapsule tous les détails d'un avis, y compris le nom d'utilisateur de l'auteur
 * de l'avis, sa photo de profil, le commentaire qu'il a laissé et la note qu'il a attribuée.
 */
public class Review {

    /** The name of the user who left the review. */
    private String username;

    /** The profile picture of the user who left the review. */
    private String picture;

    /** The comment or feedback given by the user. */
    private String comment;

    /** The rating provided by the user. Typically out of 5 or 10. */
    private int rate;

    /**
     * Constructs a new Review instance.
     *
     * @param username the name of the user leaving the review
     * @param picture  the profile picture URL or path of the user
     * @param comment  the feedback or comment from the user
     * @param rate     the rating given by the user
     */
    public Review(String username, String picture, String comment, int rate) {
        this.username = username;
        this.picture = picture;
        this.comment = comment;
        this.rate = rate;
    }

    /**
     * Returns the username of the reviewer. Renvoie le nom d'utilisateur de la personne qui a laissé un avis.
     *
     * @return a String representing the username. @return une chaîne de characctère représentant le nom d'utilisateur
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets or updates the username of the reviewer. Définit ou met à jour le nom d'utilisateur.
     *<p>
     * @param username the new username to be set. @param username le nouveau nom d'utilisateur à définir
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the profile picture of the reviewer. Renvoie la photo de profil de la personne qui a laissé un avis.
     *<p>
     * @return a String representing the picture's URL or path. @return une chaîne de charactère
     * représentant l'URL ou le chemin de l'image
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets or updates the profile picture of the reviewer. Définit ou met à jour la photo de profil.
     *
     * @param picture the new profile picture's URL or path to be set.
     * @param picture l'URL ou le chemin de la nouvelle photo de profil à définir
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Returns the comment left by the reviewer. Renvoie le commentaire laissé par l'utilisateur.
     *
     * @return a String containing the feedback or comment.
     * @return une chaîne de charactère contenant le retour ou le commentaire.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets or updates the comment left by the reviewer. Définit ou met à jour le commentaire laissé.
     *
     * @param comment the new comment or feedback to be set.
     * @param comment le nouveau commentaire ou feedback à définir
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the rating given by the reviewer. Renvoie la note attribuée par l'utilisateur.
     *
     * @return an integer representing the rating value. @return un entier représentant la valeur de la note
     */
    public int getRate() {
        return rate;
    }

    /**
     * Sets or updates the rating given by the reviewer. Définit ou met à jour la note donnée par l'utilisateur.
     *
     * @param rate the new rating value to be set. @param évalue la nouvelle valeur de note à définir
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * Compares this review with another object for equality.
     * Two reviews are considered equal if all their fields are identical.
     *
     * @param o the object to be compared with
     * @return true if the objects are equal, false otherwise
     * Compare cet avis avec un autre objet pour l'égalité.
     * Deux avis sont considérés comme égaux si tous leurs champs sont identiques.
     * @param o l'objet à comparer avec
     * @return true si les objets sont égaux, sinon false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return rate == review.rate && Objects.equals(username, review.username) && Objects.equals(picture, review.picture) && Objects.equals(comment, review.comment);
    }

    /**
     * Generates a hash code for this review based on its fields.
     *Génère un code de hachage pour cet avis en fonction de ses champs.
     * @return the generated hash code. @return le code de hachage généré
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, picture, comment, rate);
    }

}
