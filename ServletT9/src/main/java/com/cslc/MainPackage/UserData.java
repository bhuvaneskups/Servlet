package com.cslc.MainPackage;
public class UserData {
public void storeUserCredentials (String user_name, String user_password) {
Connect con=new Connect();
try {
    con.getConnection();
    String query="insert into test.user_credentials values (NULL,'"+user_name+"','"+user_password+"')";
    con.executeUpdateQuery(query);
    con.closeConnection();
}
catch (Exception e) {
    System.out.println("Something went wrong.");
}
}
public void viewUserCredentials() {
}
}