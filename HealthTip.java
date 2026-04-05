public class HealthTip {

    public static String getTip(String category) {
        switch (category) {
            case "Underweight":
                return "Eat nutrient-rich foods and consult a doctor to reach a healthy weight.";
            case "Normal":
                return "Great job! Maintain your weight with a balanced diet and regular exercise.";
            case "Overweight":
                return "Consider a balanced diet and moderate exercise to reduce excess weight.";
            case "Obese":
                return "Consult a healthcare professional for a personalised weight-loss plan.";
            default:
                return "Stay healthy with a balanced diet and regular physical activity.";
        }
    }
}
