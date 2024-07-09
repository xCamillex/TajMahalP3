package com.openclassrooms.tajmahal.domain.model;


import java.util.Objects;

/**
 * Represents a restaurant and its various attributes.
 * <p>
 * This class models a restaurant with its name, type (e.g., Indian, Italian), operational hours,
 * address, website, phone number, and availability of dine-in and take-away options.
 * </p>
 * <p>
 * For beginners: A class is a blueprint for creating objects in Java. Objects are instances of a class.
 * In this case, the class 'Restaurant' allows us to represent different restaurants with their specific details.
 * <p>
 * Example:
 * <pre>
 * Restaurant tajMahal = new Restaurant("Taj Mahal", "Indian", "11h30 - 22h00",
 *                                      "123 Street", "http://tajmahal.com", "1234567890", true, false);
 * </pre>
 *
 * * Représente un restaurant et ses différents attributs.
 *<p>
 * Cette classe modélise un restaurant avec son nom, son type (par exemple, indien, italien),
 * ses heures d'ouverture, son adresse, son site Web, son numéro de téléphone et la disponibilité
 * des options de restauration sur place et à emporter.
 *<p>
 * Pour les débutants: une classe est un plan directeur pour la création d'objets en Java.
 * Les objets sont des instances d'une classe.
 * Dans ce cas, la classe 'Restaurant' nous permet de représenter différents restaurants avec
 * leurs détails spécifiques.
 *<p>
 *Exemple:
 * Restaurant tajMahal = new Restaurant("Taj Mahal", "Indian", "11h30 - 22h00",
 * "123 Street", "http://tajmahal.com", "1234567890", true, false);
 */

public class Restaurant {

    // Member variables representing attributes of a restaurant.
    private String name;
    private String type;
    private String hours;
    private String address;
    private String website;
    private String phoneNumber;
    private boolean dineIn;
    private boolean takeAway;

    /**
     * Constructor for the Restaurant class.
     *
     * @param name        The name of the restaurant.
     * @param type        The type or cuisine of the restaurant (e.g., Indian, Italian).
     * @param hours       The operational hours of the restaurant.
     * @param address     The address of the restaurant.
     * @param website     The website URL of the restaurant.
     * @param phoneNumber The contact phone number of the restaurant.
     * @param dineIn      A boolean indicating if dine-in is available.
     * @param takeAway    A boolean indicating if take-away service is available.
     */
    public Restaurant(String name, String type, String hours, String address, String website, String phoneNumber, boolean dineIn, boolean takeAway) {
        this.name = name;
        this.type = type;
        this.hours = hours;
        this.address = address;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.dineIn = dineIn;
        this.takeAway = takeAway;
    }

    /** This code overrides the equals method for a Restaurant class. The equals method is used to
     * compare two objects for equality.
     * Ce code redéfinit la méthode equals pour une classe Restaurant. La méthode equals est utilisée
     * pour comparer deux objets. Cette méthode est essentielle pour des opérations de collections
     * comme la recherche, la suppression ou l'utilisation des objets comme clés dans des maps.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return dineIn == that.dineIn && takeAway == that.takeAway && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(hours, that.hours) && Objects.equals(address, that.address) && Objects.equals(website, that.website) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    /** This code overrides the hashCode() method to calculate and return a hash code based on several of its attributes.
     * Ce code redéfinit la méthode hashCode() pour calculer et retourner un code de hachage basé
     * sur plusieurs de ses attributs.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, type, hours, address, website, phoneNumber, dineIn, takeAway);
    }

    /** This code defines a method "getName()" as "public", which means it can be called from
     * anywhere with return type "String", which indicates that the method returns a string that
     * returns the value of the attribute "name".
     * Ce code définit une méthode "getName()" de manière "public", ce qui signifie qu'elle peut
     * être appelée depuis n'importe où avec type de retour "String" , ce qui indique que la méthode
     * retourne une chaîne de caractères qui retourne la valeur de l'attribut "name".
     */
    public String getName() {
        return name;
    }

    /** This code defines a method "setName" as "public", which means it can be called from anywhere
     * with return type "String", which indicates that the method returns a string that allows to set
     * or update the value of the "name" attribute of the current object.
     * Ce code définit une méthode "setName" de manière "public", ce qui signifie qu'elle peut être
     * appelée depuis n'importe où avec un type de paramètre "String", indiquant que la méthode attend
     * une chaîne de caractères comme argument qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "name" de l'objet actuel.
     */
    public void setName(String name) {
        this.name = name; //attribue la valeur passée en paramètre (name) à l'attribut name de l'objet courant (this).
        // L'attribut name doit être défini dans la classe où cette méthode est déclarée.
    }

    /** This code defines a method "getType()" as "public", which means it can be called from
     * anywhere with return type "String", which indicates that the method returns a string that
     * returns the value of the attribute "type".
     * Ce code définit une méthode "getType()" de manière "public", ce qui signifie qu'elle peut
     * être appelée depuis n'importe où avec type de retour "String" , ce qui indique que la méthode
     * retourne une chaîne de caractères qui retourne la valeur de l'attribut "type".
     */
    public String getType() {
        return type;
    }

    /** This code defines a method "setType" as "public", which means it can be called from anywhere
     * with return type "String", which indicates that the method returns a string that allows to set
     * or update the value of the "type" attribute of the current object.
     * Ce code définit une méthode "setType" de manière "public", ce qui signifie qu'elle peut être
     * appelée depuis n'importe où avec un type de paramètre "String", indiquant que la méthode attend
     * une chaîne de caractères comme argument qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "type" de l'objet actuel.
     */
    public void setType(String type) {
        this.type = type;
    }

    /** This code defines a method "getHours()" as "public", which means it can be called from
     * anywhere with return type "String", which indicates that the method returns a string that
     * returns the value of the attribute "hours".
     * Ce code définit une méthode "getHours()" de manière "public", ce qui signifie qu'elle peut
     * être appelée depuis n'importe où avec type de retour "String" , ce qui indique que la méthode
     * retourne une chaîne de caractères qui retourne la valeur de l'attribut "hours".
     */
    public String getHours() {
        return hours;
    }

    /** This code defines a method "setHours" as "public", which means it can be called from anywhere
     * with return type "String", which indicates that the method returns a string that allows to set
     * or update the value of the "hours" attribute of the current object.
     * Ce code définit une méthode "setHours" de manière "public", ce qui signifie qu'elle peut être
     * appelée depuis n'importe où avec un type de paramètre "String", indiquant que la méthode attend
     * une chaîne de caractères comme argument qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "hours" de l'objet actuel.
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /** This code defines a method "getAddress()" as "public", which means it can be called from
     * anywhere with return type "String", which indicates that the method returns a string that
     * returns the value of the attribute "address".
     * Ce code définit une méthode "getAddress()" de manière "public", ce qui signifie qu'elle peut
     * être appelée depuis n'importe où avec type de retour "String" , ce qui indique que la méthode
     * retourne une chaîne de caractères qui retourne la valeur de l'attribut "address".
     */
    public String getAddress() {
        return address;
    }

    /** This code defines a method "setAddress" as "public", which means it can be called from anywhere
     * with return type "String", which indicates that the method returns a string that allows to set
     * or update the value of the "address" attribute of the current object.
     * Ce code définit une méthode "setAddress" de manière "public", ce qui signifie qu'elle peut être
     * appelée depuis n'importe où avec un type de paramètre "String", indiquant que la méthode attend
     * une chaîne de caractères comme argument qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "address" de l'objet actuel.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** This code defines a method "getWebsite()" as "public", which means it can be called from
     * anywhere with return type "String", which indicates that the method returns a string that
     * returns the value of the attribute "website".
     * Ce code définit une méthode "getWebsite()" de manière "public", ce qui signifie qu'elle peut
     * être appelée depuis n'importe où avec type de retour "String" , ce qui indique que la méthode
     * retourne une chaîne de caractères qui retourne la valeur de l'attribut "website".
     */
    public String getWebsite() {
        return website;
    }

    /** This code defines a method "setWebsite" as "public", which means it can be called from anywhere
     * with return type "String", which indicates that the method returns a string that allows to set
     * or update the value of the "website" attribute of the current object.
     * Ce code définit une méthode "setWebsite" de manière "public", ce qui signifie qu'elle peut être
     * appelée depuis n'importe où avec un type de paramètre "String", indiquant que la méthode attend
     * une chaîne de caractères comme argument qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "website" de l'objet actuel.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /** This code defines a method "getPhoneNumber()" as "public", which means it can be called from
     * anywhere with return type "String", which indicates that the method returns a string that
     * returns the value of the attribute "phoneNumber".
     * Ce code définit une méthode "getPhoneNumber()" de manière "public", ce qui signifie qu'elle peut
     * être appelée depuis n'importe où avec type de retour "String" , ce qui indique que la méthode
     * retourne une chaîne de caractères qui retourne la valeur de l'attribut "phoneNumber".
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /** This code defines a method "setPhoneNumber" as "public", which means it can be called from anywhere
     * with return type "String", which indicates that the method returns a string that allows to set
     * or update the value of the "phoneNumber" attribute of the current object.
     * Ce code définit une méthode "setPhoneNumber" de manière "public", ce qui signifie qu'elle peut être
     * appelée depuis n'importe où avec un type de paramètre "String", indiquant que la méthode attend
     * une chaîne de caractères comme argument qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "phoneNumber" de l'objet actuel.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /** Defines a "public" method "isDineIn()" of boolean return type (true or false) and which
     * returns the value of the "dineIn" attribute.
     * Définit une méthode "isDineIn()"  de manière "publique" de type retour   boolean (true ou
     * false) et qui retourne la valeur de l'attribut "dineIn".
     */
    public boolean isDineIn() {
        return dineIn;
    }

    /** Defines a method "setDineIn" which allows to set or update the value of the "dineIn" attribute.
     * Définit une méthode "setDineIn"  qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "dineIn".
     */
    public void setDineIn(boolean dineIn) {
        this.dineIn = dineIn;
    }

    /** Defines a "public" method "isTakeAway()" of boolean return type (true or false) and which
     * returns the value of the "takeAway" attribute.
     * Définit une méthode "isTakeAway()"  de manière "publique" de type retour   boolean (true ou
     * false) et qui retourne la valeur de l'attribut "takeAway".
     */
    public boolean isTakeAway() {
        return takeAway;
    }

    /** Defines a method "setTakeAway" which allows to set or update the value of the "takeAway" attribute.
     * Définit une méthode "setTakeAway"  qui permet de définir ou de mettre à jour la valeur de
     * l'attribut "takeAway".
     */
    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }


}
