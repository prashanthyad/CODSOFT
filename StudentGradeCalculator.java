package com.codsoft;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        int numSubjects = getValidInput(scanner, "Enter the number of subjects: ", 1, Integer.MAX_VALUE);
        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            totalMarks += getValidInput(scanner, "Enter marks obtained in Subject " + i + " (out of 100): ", 0, 100);
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        // Displaying results efficiently using String.format()
        System.out.println("\n--- Student Result ---");
        System.out.println(String.format("Total Marks: %d", totalMarks));
        System.out.println(String.format("Average Percentage: %.2f%%", averagePercentage));
        System.out.println(String.format("Grade: %s", grade));

        scanner.close();
    }

    // Method to validate user input within a given range
    private static int getValidInput(Scanner scanner, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= min && value <= max) break;
                System.out.println("Error: Please enter a number between " + min + " and " + max + ".");
            } else {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }

    // Optimized grade calculation method
    private static String calculateGrade(double percentage) {
        return (percentage >= 90) ? "A (Excellent)" :
               (percentage >= 80) ? "B (Very Good)" :
               (percentage >= 70) ? "C (Good)" :
               (percentage >= 60) ? "D (Satisfactory)" :
               (percentage >= 50) ? "E (Needs Improvement)" : "F (Fail)";

	}

}
