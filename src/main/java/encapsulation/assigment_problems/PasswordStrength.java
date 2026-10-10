package encapsulation.assigment_problems;

// Key idea: the password is private and final, with no getter; the class only ever
// reveals a computed strength label.
class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int len = password.length();
        if (len < 6) return "Weak";
        if (len < 10) return "Medium";
        return "Strong";
    }
}

public class PasswordStrength {
    public static void main(String[] args) {
        System.out.println("abcd -> " + new PasswordChecker("abcd").getStrength());
        System.out.println("abcdefgh -> " + new PasswordChecker("abcdefgh").getStrength());
        System.out.println("abcdefghij -> " + new PasswordChecker("abcdefghij").getStrength());
        System.out.println("abcdefghijkl -> " + new PasswordChecker("abcdefghijkl").getStrength());
    }
}
