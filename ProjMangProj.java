/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projmangproj;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ProjMangProj {

    public static ArrayList<Chapter> readNotes(){
        ArrayList<Chapter> chapters = new ArrayList();
        try{
            FileReader fr = new FileReader("src\\projmangproj\\NoteContent");
            BufferedReader br = new BufferedReader(fr);
            boolean eof = false;
            while(!eof){
                String line = br.readLine();
                if(line == null){
                    eof = true;
                }else{
                    if(line.substring(0,7).equals("Chapter")){
                        chapters.add(new Chapter(line,""));
                    }else{
                        int length = chapters.size();
                        (chapters.get(length - 1)).setBody((chapters.get(length - 1)).getBody() + "\n" + line);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("ERROR " + e);
        }
        return chapters;
    }
    
    public static Question[] readQuestions(String[] args) {
        Question[] questionSet = new Question[10];
        try {
            int questionNumber = -1;
            FileReader fr = new FileReader("src\\sam\\QuizContent");
            BufferedReader br = new BufferedReader(fr);
            boolean eof = false;
            String question = "";
            String questionAnswer = "";
            String[] questionChoices = new String[4];
            while (!eof) {
                question = br.readLine();
                if (question == null) {
                    eof = true;
                } else {
                    questionNumber++;
                    questionChoices[0] = br.readLine();
                    questionChoices[1] = br.readLine();
                    questionChoices[2] = br.readLine();
                    questionChoices[3] = br.readLine();
                    questionAnswer = br.readLine();
                    questionSet[questionNumber] = new Question(question, questionChoices, translateLetterToInt(questionAnswer));
                }
            }
            System.out.println(printArray(questionSet));
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        return questionSet;
    }
    
    public static int translateLetterToInt(String input) {
        switch (input) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            default:
                return 3;
        }
    }
    public static String printArray(Question[] array) {
        String addOn = "";
        for (Question elem : array) {
            addOn+= elem + "\n";
        }
        return addOn;
    }
    
    public static void main(String[] args) {
        
    }
    
}
