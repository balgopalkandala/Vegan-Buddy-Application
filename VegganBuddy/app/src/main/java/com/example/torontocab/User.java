package com.example.torontocab;

public class User {

    String userId;
    String userFirstName;
    String userLastName;
    String userCard;
    String userExpirationDate;

     public User(){


     }

    public User(String userId, String userFirstName, String userLastName){
         this.userId = userId;
         this.userFirstName = userFirstName;
         this.userLastName = userLastName;
     }


    public String getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }


    public User(String userCard, String userExpirationDate){
         this.userCard = userCard;
         this.userExpirationDate = userExpirationDate;
    }

}
