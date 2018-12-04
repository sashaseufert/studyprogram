/*
 * Sasha Albert Mark
 * Nov 28 2018
 * Quiz class
 */

package sam;

import java.util.ArrayList;

/**
 *
 * @author mache9294
 */
public class Quiz {
    
    private int numOfQuestion = 10;
    private ArrayList<Question> questions = new ArrayList();
    private int correct,incorrect;
    private double percentage = 0.0;
    
    /**
     * Primary constructor of the quiz class
     */
    public Quiz(){
        numOfQuestion = 1;
        questions = null;
        correct = 0;
        incorrect = 0;
        percentage = 0.0;
    }
    
    /**
     * Secondary constructor of the quiz class
     * @param questionArray - the array of questions
     */
    public Quiz(ArrayList<Question> questionArray){
        this();
        this.numOfQuestion = questionArray.size();
        this.questions = questionArray;
    }
    
    /**
     * Tertiary constructor of the quiz class
     * @param questionArray - the array of question
     * @param correct - the number of correct questions
     */
    public Quiz(ArrayList<Question> questionArray, int correct){
        this(questionArray);
        this.correct = correct;
        this.incorrect = numOfQuestion - this.correct;
        this.percentage = (double) correct / (double) numOfQuestion;
    }
    
    
    /**
     * This method adds a question to the quiz at a chosen index
     * @param newQuestion - the new question to be added
     * @param element - the element to put the new
     */
    public void addQuestionToIndex(Question newQuestion, int element){
        questions.add(element,newQuestion);
    }
    
    /**
     * This method adds a question to the quiz
     * @param newQuestion - the new question to be added
     */
    public void addQuestion(Question newQuestion){
        questions.add(newQuestion);
    }
    
    /**
     * This method will randomize the order of the question in the quiz
     * @param questions - the array of questions to be randomized
     * @return - the new question array list
     */
    public ArrayList<Question> randomizeQuestionOrder(ArrayList<Question> questions){
        int currentIndex = questions.size(), randomIndex;
        Question tempVal;
        
        // While there are elements to randomize order
        while (0 != currentIndex){
            //Pick a remaining element
            randomIndex = (int) Math.floor(Math.random()* currentIndex);
            currentIndex--;
            
            //Swap the elements
            tempVal = questions.get(currentIndex);
            questions.set(currentIndex,questions.get(randomIndex));
            questions.set(randomIndex,tempVal);
        }
        
        return questions;
    }
    
    /**
     * Equals method to determine whether the two quizzes are the same
     * @param comparedQuiz - The quiz we are comparing to
     * @return - Whether the title and the body questions are equal
     */
    public boolean equals(Quiz comparedQuiz){
        return  numOfQuestion == comparedQuiz.numOfQuestion &&
                equateQuestion(questions,comparedQuiz.questions);
    }
    
    /**
     * This method will take 2 the question arrays and see if they contain the exact same thing
     * @param array1 - the first array to be compared to the other one
     * @param array2 - other array that is compared for equality
     * @return 
     */
    public boolean equateQuestion(ArrayList<Question> array1, ArrayList<Question> array2){
        int array1Len = array1.size();
        int array2Len = array2.size();
        boolean equal = true;
        
        //Compares the length first
        if (array1Len == array2Len) {
            //If the arrays have the same length, check each element to see if they are equal
            for (int i = 0; i < array1Len; i++) {
                //If the elements are not equal, stop the check and return false
                if (!array1.get(i).equals(array2.get(i))) {
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
     * ToString method that returns a string formatted to show the attributes of a question
     * @return - the String containing the information about this question
     */
    public String toString(){
        String out =    "Quiz Question Number:" + numOfQuestion + "\n"
                    +   "Questions:" +  stringTheQuestions(questions) + "\n" 
                    +   "Correct Answers:" + correct + "\n" 
                    +   "Incorrect Answers:" + incorrect + "\n" 
                    +   "Percentage:" + percentage + "\n"; 
        return out;
    }
    
    /**
     * Returns a formatted String version of the list of questions
     * @param questions - the list of questions to be formatted
     * @return - String version of the questions
     */
    public String stringTheQuestions(ArrayList<Question> questions){
        String addOn = "";
        for (int i = 0; i < questions.size(); i++) {
            addOn+= String.valueOf(questions.get(i));
        }
        return addOn;
    }
    
    
    /**
     * Clone method that creates another identical quiz
     * @return - another quiz that has the same questions
     */
    public Quiz clone(){
        return new Quiz(questions);
    }
    
    
    /**
     * @return the numOfQuestion
     */
    public int getNumOfQuestion() {
        return numOfQuestion;
    }

    /**
     * @param numOfQuestion the numOfQuestion to set
     */
    public void setNumOfQuestion(int numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }

    /**
     * @return the questions
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * @param correct the correct to set
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    /**
     * @return the incorrect
     */
    public int getIncorrect() {
        return incorrect;
    }

    /**
     * @param incorrect the incorrect to set
     */
    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
