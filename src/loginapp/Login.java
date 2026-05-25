package loginapp;

public class Login {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellPhoneNumber;

    public Login() {
    }

    public boolean checkUserName(String userName) {
        return userName != null
                && userName.contains("_")
                && userName.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password != null
                && password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber != null
                && cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String firstName, String lastName, String userName, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;

        if (!checkUserName(userName)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "User has been registered successfully.";
    }

    public boolean loginUser(String enteredUserName, String enteredPassword) {
        return this.userName != null
                && this.password != null
                && this.userName.equals(enteredUserName)
                && this.password.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}