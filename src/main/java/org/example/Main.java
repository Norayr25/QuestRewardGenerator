package org.example;

import java.util.Scanner;

import static org.example.QuestRewardGenerator.generateQuestSequence;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of quests: ");
        int N = scanner.nextInt();

        String rewardString = generateQuestSequence(N);
        System.out.println("Quest rewards: " + rewardString);
    }
}