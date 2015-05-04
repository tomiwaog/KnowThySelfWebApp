package knowthyselfserver;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

//@WebService is a service endpoint interface (SEI)
//which declare the abstract methods of KTS-Service-Server
@Stateless
@WebService(serviceName = "KnowThySelfWebService", portName = "AppWebPort")
public class KnowThySelfWebService {

    //Setters and getters
    
//Web Service Operation
    @WebMethod(operationName = "welcomeUser")
    public String welcomeUser(@WebParam(name = "user") String uName) {
        return " Hello, " + uName + "!"; // Server welcomes the user (whatever is passed on the parameter)
    }

    
    @WebMethod(operationName = "getDayOfBirth")
    //Method to get users DAY of birth via string passed from client
    public String getDayOfBirth(@WebParam(name = "dd") String dobdd) {
        return " Born on the " + dobdd + " day "; //Server the string with dobb value passed from client
    }

    //Gets users month of birth via String parameter
    @WebMethod(operationName = "getMonthOfBirth")
    public String getMOnthOfBirth(@WebParam(name = "monthdob") String dobmm) {
        return "of month of " + dobmm; //returns the month of birth will be passed to String dobmm from clientside
    }

    //This method gets the users full dob and prints it when called
    @WebMethod(operationName = "getDateOfBirth")
    public String getDateOfBirth(@WebParam(name = "dd") String dobdd, @WebParam(name = "mm") String dobmm, @WebParam(name = "yyyy") int dobyyyy) {
        return "Date of Birth: " + dobdd + "/" + dobmm + "/" + dobyyyy;//returns users full DOB
    }

    //Hidden Operation on the server not required by the user
    @WebMethod(operationName = "getZodiacSign")
    public String getZodiacSign(@WebParam(name = "zodiac") String zodiac) {
        return "SIGN: " + zodiac; //returns user's zodiac 
    }

    //method to return users favorite colour
    @WebMethod(operationName = "getFaveColor")
    public String getFaveColor(@WebParam(name = "color") String color) {
        return " You like the color " + color + ", "; //return passed string
    }

    //Method to get user favourite food and can be called by appropriate client
    @WebMethod(operationName = "getFaveFood")
    public String getFaveFood(@WebParam(name = "food") String food) {
        return "your favortie food is " + food;
    }

    //Gets users favorite drink.
    @WebMethod(operationName = "getFaveDrink")
    public String getFaveDrink(@WebParam(name = "drink") String drink) {
        return " \n and you like drinking " + drink + "?.\n";
    }

    //Returns a user statement based on the value of the zodia.
    @WebMethod(operationName = "findZodiac")
    public String findZodiac(@WebParam(name = "typeZodiacc") String typeZodiac) {
        System.out.println("SUMMARY: ");
        
        //Switch case statements to determine the return value
        //which is based on the value of typeZodiac passed from client side.
        //The Server then reurns the text depending of the value the String typeZodiac passes to it
        switch (typeZodiac) {
            case "gemini": //if typeZodiac value is "gemini" return the following
                return "\n You are intelligent, a thinker , communicative, \nhumorous,"
                        + " multiskilled, indecisive, mutable, \nAdaptable, restless, witty and devious";
            case "leo": //if typeZodiac value is "leo" return the following
                return "\n You are confident, melodramatic, generous, loyal, \nstubborn, vain, pretentious, family-oriented or \nprone to family issues";
            case "capricorn": //if typeZodiac value is "capricorn" return the following
                return "\nYou are stubborn, resourceful, \nhardworking, ambitous, dictorial,"
                        + " conceited, \nemotional, distrusting, responsible";
            case "pisces"://if typeZodiac value is "pisces" return the following
                return "\nYou are emotional, compassionate, devoted, lazy, \nimaginative,"
                        + " oversensitive, self-pitying, and \nan escapist";
            case "aquarius"://if typeZodiac value is "aquarius" return the following
                return "\nYou are witty, communicative, original, \nintelligent, aloof and unemotional";
            case "aries"://if typeZodiac value is "aries" return the following
                return "\nYou are Independent, generous, moody, \nshort-tempered, optimistic, self-involved \nand Nimpatient";
            case "taurus"://if typeZodiac value is "taurus" return the following
                return "\nYou are stubborn, honest, materialistic, \nlazy and self indulging";
            case "cancer"://if typeZodiac value is "cancer" return the following
                return "\nYou are moody, homely, family-oriented \nand (or) family issues or daddy issues,"
                        + " \nover-sensitive, insecure, caring, responsive \nand dependable";
            case "virgo"://if typeZodiac value is "virgo" return the following
                return "\nYou are analytical, observant, fussy, precise, \ncold, interferromg"
                        + ", inflexible, direct, \nhelpful, reliable, not fun";
            case "libra"://if typeZodiac value is "libra" return the following
                return "\nYou are Diplomatic, hospitable, colourful, Vain, \nindecisive, fair, social, intelligent \nand people pleaser";
            case "scorpio"://if typeZodiac value is "scorpio" return the following
                return "\nYou are resourceful, passionate, loyal, evil, \nstubborn, determined"
                        + "obsessive, jealous, \nintuitive, violent, aggressive, \nmanipulative, ride or \ndie person";
            case "sagittarius"://if typeZodiac value is "sagittarius" return the following
                return "\nYou are exciting, independent, unemotional, adventurous, \nmutable, philosophical, "
                        + "stubborn and argumentative";
            default: //If none of the above cases was returned, Then Return the following message
                return "Invalid Data entered, Server returning nothing!";
        }
    }
}
