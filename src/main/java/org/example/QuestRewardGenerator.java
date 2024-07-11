package org.example;

import java.util.ArrayList;

public class QuestRewardGenerator {


    /**
     * Generates a sequence of quest rewards based on the predefined pattern.
     *
     * @param N the number of quests.
     * @return a string representing the sequence of quest rewards.
     */
    public static String generateQuestSequence(int N) {
        // Predefined pattern for N = 100
        String pattern = "bbbbbbbbbsbbbbbbbbsbbbsbbbsbbbbsbsbbsbsbbsbbsbsbsbsbssbsbsbsbsbsssbsssbssbssbsssssbssssssbssssssssss";

        final ArrayList<Integer> xPositions = new ArrayList<>(pattern.length());
        final ArrayList<Integer> yValues = new ArrayList<>(pattern.length());

        // Populate known positions and values for interpolation.
        for (int i = 0; i < pattern.length(); i++) {
            xPositions.add(i);
            yValues.add(pattern.charAt(i) == 'b' ? 1 : 0);
        }

        // Generate sequence based on interpolation.
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < N; i++) {
            double xPosition = (double) i * (pattern.length() - 1) / (N - 1); // Map position to the pattern range
            double interpolatedValue = lagrangeInterpolation(xPositions, yValues, xPosition);
            if (interpolatedValue > 0.5) {
                sequence.append('b');
            } else {
                sequence.append('s');
            }
        }

        return sequence.toString();
    }


    /**
     * Performs Lagrange interpolation to calculate the interpolated value at a given position.
     *
     * @param xPositions the x-coordinates of the known data points
     * @param yValues    the y-coordinates (values) of the known data points
     * @param xPosition  the x-coordinate where the interpolated value is needed
     * @return the interpolated value at the given xPosition
     */
    public static double lagrangeInterpolation(final ArrayList<Integer> xPositions,
                                               final ArrayList<Integer> yValues,
                                               double xPosition) {
        double interpolatedValue = 0.0;

        for (int i = 0; i < xPositions.size(); ++i) {
            double lagrangePolynomial = 1.0;
            for (int j = 0; j < xPositions.size(); ++j) {
                if (i != j) {
                    lagrangePolynomial *= (xPosition - xPositions.get(j)) / (xPositions.get(i) - xPositions.get(j));
                }
            }
            interpolatedValue += lagrangePolynomial * yValues.get(i);
        }

        return interpolatedValue;
    }
}