public class HealthTip {

    public static String getTip(String category) {
        switch (category) {
            case "Underweight":
                return "Eat nutrient-rich foods and consider consulting a dietitian to gain healthy weight.";
            case "Normal":
                return "Great job! Maintain your healthy weight with a balanced diet and regular exercise.";
            case "Overweight":
                return "Consider increasing physical activity and reducing calorie intake to reach a healthy weight.";
            case "Obese":
                return "Consult a healthcare provider for a personalized plan to safely reduce your weight.";
            default:
                return "Stay active and eat a balanced diet for overall good health.";
        }
    }
}
