package org.example;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        // declare scanner object
        Scanner scannerObj = new Scanner(System.in);

        //  declare 2 Arraylists to store students name, grades, grades count
        ArrayList<String> studentsName = new ArrayList<>();
        ArrayList<Integer> studentsGrade = new ArrayList<>();
        ArrayList<Character> gradesCount = new ArrayList<>();

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

        System.out.println("\n----- Class Summary -----");
        System.out.printf("Average Score: %,.2f", calculateAverage(studentsGrade));
        System.out.println("\nGrade Counts: " + getGradesCount(gradesCount));
        System.out.println("Top Student(s): " + getHighestStudent(studentsName, studentsGrade));

        // close scanner object
        scannerObj.close();

    }

    public static String getHighestStudent(ArrayList<String> studentsName, ArrayList<Integer> studentsGrade) {
        int highestGrade = Collections.max(studentsGrade);

        //  get the highest grade in gradesCount in the last element after sort
        int highestGradeIndex = studentsGrade.indexOf(highestGrade);
        String highestStudent = studentsName.get(highestGradeIndex);

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

        return String.format("A:%s B:%s C:%s D:%s F:%s" , countGradesA, countGradesB, countGradesC, countGradesD, countGradesF);
    }

    //  method to calculate average of average scores of all students
    public static float calculateAverage(ArrayList<Integer> grades) {
        float sumGrades = 0;

        for (Integer grade : grades) {
            sumGrades = grade + sumGrades;
        }

        return sumGrades / grades.size();
    }

    //  method to calculate score of student
    public static char calculateScore(float score, ArrayList<Character> gradesCount) {
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
