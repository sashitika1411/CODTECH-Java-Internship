import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {

        // Sample user preference
        String userPreference = "Action";

        // Sample dataset (item -> category)
        Map<String, String> items = new HashMap<>();
        items.put("Avengers", "Action");
        items.put("John Wick", "Action");
        items.put("Inception", "Sci-Fi");
        items.put("Titanic", "Romance");
        items.put("Notebook", "Romance");
        items.put("Interstellar", "Sci-Fi");

        System.out.println("User Preference: " + userPreference);
        System.out.println("Recommended Items:");

        // Recommendation logic
        for (Map.Entry<String, String> entry : items.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(userPreference)) {
                System.out.println("- " + entry.getKey());
            }
        }
    }
}
