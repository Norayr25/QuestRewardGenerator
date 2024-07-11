# Quest Reward Generator

## Overview

The quest reward generator is a Java application designed to generate a sequence of quest rewards based on a predefined
pattern. The application uses Lagrange interpolation to create sequences for any given number of quests, ensuring that
the distribution of rewards closely follows the original pattern.

## Features

Generates a sequence of quest rewards (b for bronze chest and s for silver chest) based on a predefined pattern.

Uses Lagrange interpolation to ensure smooth transitions and accurate representation of the predefined pattern for any
number of quests.

## Predefined Pattern

The predefined pattern for 100 quests is:
bbbbbbbbbsbbbbbbbbsbbbsbbbsbbbbsbsbbsbsbbsbbsbsbsbsbssbsbsbsbsbsssbsssbssbssbsssssbssssssbssssssssss

## Example of usage

Enter the number of quests: 10

Quest rewards: bbbbbbbbsb

## Setup and Running the Project

#### Clone the repository to your local machine using Git:

git clone <repository-url>

cd QuestRewardGenerator

#### Navigate to the project directory and compile the Java files:

javac -d out src/org/example/*.java

#### Run the compiled Java program:

java -cp out org.example.Main

Follow the prompt to enter the number of quests. For example, if you enter 100, you will get an output sequence similar
to the predefined pattern.