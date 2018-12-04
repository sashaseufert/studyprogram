/*
 * Sasha Albert Mark
 * Nov 28 2018
 * Question class
 */

package sam;

import java.util.Arrays;

/**
 *
 * @author mache9294
 */
public class Question {
    private String question;
    private String[] choices;
    private int correctAnswerIndex;
    private int userAnswer;
    
    /**
     * This is the primary constructor of the Question class
     */
    public Question(){
        this.question = "No Question";
        this.choices = null;
        this.correctAnswerIndex = 0;
        this.userAnswer = 0;
    }
    /**
     * This is the secondary constructor of the Question Class
     * @param question - the question to be asked
     * @param choices - the array of choices of answers
     * @param correctAnswerIndex - the index of the correct answer
     */
    public Question(String question, String[] choices, int correctAnswerIndex){
        this();
        this.question = question;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }
    
    /**
     * This is the tertiary constructor of the Question Class
     * @param question - the question to be asked
     * @param choices - the array of choices of answers
     * @param correctAnswerIndex - the index of the correct answer
     * @param userAnswer - the index of the user's choice out of the answers
     */
    public Question(String question, String[] choices, int correctAnswerIndex, int userAnswer){
        this(question, choices, correctAnswerIndex);
        this.userAnswer = userAnswer;
    }
    
    /**
     * This method will tell the user if their answer is correct.
     * @return - true or false, after comparing if the selected element
     */
    public boolean tellUserIfCorrect(){
        return (getCorrectAnswerIndex() == getUserAnswer());
    }
    
    /**
     * Equals method to determine whether the two questions are the same
     * @param comparedQuestion - The question we are comparing to
     * @return - Whether the title and the body questions are equal
     */
    public boolean equals(Question comparedQuestion){
        return  this.getQuestion().equals(comparedQuestion.getQuestion()) &&
                equateArrays(this.getChoices(),comparedQuestion.getChoices()) &&
                this.getCorrectAnswerIndex() == comparedQuestion.getCorrectAnswerIndex();
                
    }
    
    /**
     * Clone method that creates another identical question
     * @return - another question that has the same attributes as this question
     */
    public Question clone(){
        return new Question(getQuestion(), getChoices(), getCorrectAnswerIndex());
    }
    
    /**
     * ToString method that returns a string formatted to show the attributes of a question
     * @return - the String containing the information about this question
     */
    public String toString(){
        String out =    "Question:" + getQuestion() + "\n"
                    +   "Choices:" + Arrays.toString(getChoices()) + "\n" 
                    +   "Correct Answer:" + getCorrectAnswerIndex() + "\n" 
                    +   "User Answer:" + getUserAnswer() + "\n"; 
        return out;
    }
    
    
    
    /**
     * This method will take 2 String arrays, which are the user answer choices, and see if they contain the exact same thing
     * @param array1 - the first array to be compared to the other one
     * @param array2 - other array that is compared for equality
     * @return 
     */
    public boolean equateArrays(String[] array1, String[] array2){
        int array1Len = array1.length;
        int array2Len = array2.length;
        boolean equal = true;
        
        //Compares the length first
        if (array1Len == array2Len) {
            //If the arrays have the same length, check each element to see if they are equal
            for (int i = 0; i < array1Len; i++) {
                //If the elements are not equal, stop the check and return false
                if (!array1[i].equals(array2[i])) {
                    i = array1Len+1;
                    equal = false;
                }
            }
        } else {
            //If the lengths are different, the arrays are different
            equal = false;
        }
        
         return equal;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the choices
     */
    public String[] getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    /**
     * @return the correctAnswerIndex
     */
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    /**
     * @param correctAnswerIndex the correctAnswerIndex to set
     */
    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * @return the userAnswer
     */
    public int getUserAnswer() {
        return userAnswer;
    }

    /**
     * @param userAnswer the userAnswer to set
     */
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
    
}
