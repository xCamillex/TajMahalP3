package com.openclassrooms.tajmahal.domain.model;

/** Represents a user.
 * This class encapsulates all the details of a user, their username and profile picture.
 * Représente un utilisateur.
 * Cette classe encapsule tous les détails d'un utilisateur , son nom d'utilisateur et sa photo de profil.
 */

public class User {
    private String userName;
    private String pictureUrl;

/**
 * Constructor for the User class.
 *
 * @param userName       The name of the user.
 * @param pictureUrl     The picture of the user.
 */
 public User(String userName, String pictureUrl) {
        this.userName = userName;
        this.pictureUrl = pictureUrl;
    }

    /** The "getUserName()" method allows you to access and retrieve the value of the "userName" attribute.
     *La méthode "getUserName()" permet d'accéder et de récupérer la valeur de l'attribut "userName".
     */
    public String getUserName() {
        return userName;
    }

    /** The "setUserName(String userName)" method allows you to change or set the value of the
     * "userName" attribute.
     *La méthode "setUserName(String userName)" permet de modifier ou de définir la valeur de
     * l'attribut "userName".
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** The "getPictureUrl()" method allows you to access and retrieve the value of the "pictureUrl" attribute.
     *La méthode "getPictureUrl()" permet d'accéder et de récupérer la valeur de l'attribut "pictureUrl".
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /** The "setPictureUrl(String pictureUrl)" method allows you to change or set the value of the
     * "pictureUrl" attribute.
     *La méthode "setPictureUrl(String pictureUrl)" permet de modifier ou de définir la valeur de
     * l'attribut "pictureUrl".
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
