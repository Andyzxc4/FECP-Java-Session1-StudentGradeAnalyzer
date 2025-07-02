package org.example;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        // declare scanner object
        Scanner scannerObj = new Scanner(System.in);

        //  declare 3 Arraylists to store students name, grades, grades count
        ArrayList<String> studentsName = new ArrayList<>(); //  will store all students name
        ArrayList<Integer> studentsGrade = new ArrayList<>(); //    store all students grade (numerical)
        ArrayList<Character> gradesCount = new ArrayList<>(); //    store all grades (A, B, C...etc)

        //  number of students input
        System.out.print("Enter number of students: ");
        int numberStudentInput = scannerObj.nextInt();

        for (int i = 0; i < numberStudentInput; i++) {
            //  input name of student
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String studentNameInput = scannerObj.next();
            studentsName.add(studentNameInput); // add student name to arraylist

            //  input student score
            System.out.print("Enter score for " + studentNameInput + ": ");
            int studentScoreInput = scannerObj.nextInt();
            studentsGrade.add(studentScoreInput);    //  add student score to arraylist

            //  grade display
            System.out.println(studentNameInput + " got grade: " + calculateScore(studentScoreInput, gradesCount));
        }

        //  class summary output
        System.out.println("\n----- Class Summary -----");
        System.out.printf("Average Score: %,.2f", calculateAverage(studentsGrade));
        System.out.println("\nGrade Counts: " + getGradesCount(gradesCount));
        System.out.println("Top Student(s): " + getHighestStudent(studentsName, studentsGrade));

        // close scanner object
        scannerObj.close();

    }

    public static String getHighestStudent(ArrayList<String> studentsName, ArrayList<Integer> studentsGrade) {
        //  get the highest value of students grade
        int highestGrade = Collections.max(studentsGrade);

        /*
            Since both ArrayList of students grade and name have the same indexes:
                1. We want to get the highest grade in studentsGrade ArrayList (stored in highestGrade)
                2. Get the index of highest grade in studentsGrade ArrayList
                3. Get the name of the student with highest grade based on the index of the highest grade from highestGradeIndex
         */
        int highestGradeIndex = studentsGrade.indexOf(highestGrade);
        String highestStudent = studentsName.get(highestGradeIndex);

        //  return formatted string with student's highest grade and name
        return String.format("%s (%s)", highestStudent, highestGrade);

    }

    //  method to fetch the grade counts of students
    public static String getGradesCount(ArrayList<Character> gradesCount) {
        int countGradesA = 0;
        int countGradesB = 0;
        int countGradesC = 0;
        int countGradesD = 0;
        int countGradesF = 0;
        int countGradesNone = 0;

        for (Character gradeCount : gradesCount) {
            switch (gradeCount) {
                case 'A':
                    countGradesA++ ;
                    break;
                case 'B':
                    countGradesB++ ;
                    break;
                case 'C':
                    countGradesC++ ;
                    break;
                case 'D':
                    countGradesD++ ;
                    break;
                case 'F':
                    countGradesF++ ;
                    break;
                default:
                    countGradesNone++ ;
            }
        }

        //  return formatted string of the grades compilation
        return String.format("A:%s B:%s C:%s D:%s F:%s" , countGradesA, countGradesB, countGradesC, countGradesD, countGradesF);
    }

    //  method to calculate average of average scores of all students
    public static float calculateAverage(ArrayList<Integer> grades) {
        float sumGrades = 0;

        //  enhanced for loop to get the sum of all grades
        for (Integer grade : grades) {
            sumGrades = grade + sumGrades;
        }

        //  get sum of all grades & divide to the total count of all grades (grades.size()) to get the average
        return sumGrades / grades.size();
    }

    //  method to calculate score of student
    public static char calculateScore(float score, ArrayList<Character> gradesCount) {
        //  return the score based on student's grade
        if (score >= 90 && score <= 100) {
            gradesCount.add('A');
            return 'A';
        }
        else if (score >= 80 && score <= 89) {
            gradesCount.add('B');
            return 'B';
        }
        else if (score >= 70 && score <= 79) {
            gradesCount.add('C');
            return 'C';
        }
        else if (score >= 60 && score <= 69) {
            gradesCount.add('D');
            return 'D';
        }
        else if (score < 60) {
            gradesCount.add('F');
            return 'F';
        }
        else {
            gradesCount.add('-');
            return '-';
        }
    }
}
