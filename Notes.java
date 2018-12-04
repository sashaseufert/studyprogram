//Albert Tang (with Chen, Seufert)
//November 28 2018
//Notes Class

package projmangproj;
import java.util.ArrayList;

public class Notes {
    private ArrayList<Chapter> noteChapters = new ArrayList();
    
    /**
     * Primary Constructor: Construct a Notes Object with an empty chapter ArrayList
     */
    public Notes(){
        noteChapters.add(new Chapter("", ""));
    }
    
    /**
     * Secondary Constructor: Construct a Notes Object given an ArrayList of notes
     * @param noteSections The ArrayList containing all the sections of the notes
     */
    public Notes(ArrayList<Chapter> noteSections){
        this.noteChapters = noteSections;
    }
    
    /**
     * Behaviour Method: This method add a section to the notes
     * @param title The title of the section
     * @param bodyParagraph The bodeyParagraph of the section
     */
    public void addChapters(String title, String bodyParagraph){
        noteChapters.add(new Chapter(title, bodyParagraph)); //Add this section to the end of the arrayList
    }
    
    /**
     * Behaviour Method: Moving a chapter of the note to a different location in the ArrayList (hence rearranging the order of the notes
     * @param chapterCurrent The current chapter the notes is at
     * @param location The location the notes want to be moved to
     */
    public void moveChapters(int chapterCurrent, int location){
        noteChapters.add(location,noteChapters.get(chapterCurrent)); //Add the chapter of the notes that we want to move to the spot that we want
        //Now we remove the original chapter to the location that it actually is
        if(chapterCurrent >= location){//Check to see if the location that we want to move to is less than or equal to the chapter the note is on
            //This means that the original chapter has moved back one space
            noteChapters.remove(chapterCurrent + 1); //Remove that section of the chapter
        }else{
            //Otherwise: This means that the original chapter is still where it is
            noteChapters.remove(chapterCurrent); //Remove that section of the chapter
        }
    }
    
    /**
     * Behaviour method that deletes a chapter from the notes
     * @param chapter The chapter that the user wants to delete
     */
    public void deleteChapters(int chapter){
        noteChapters.remove(chapter);
    }
    
    /**
     * Mutator Method: set the ArrayList of all the chapters of the note
     * @param noteChapters the ArrayList of all the chapters of the note
     */
    public void setNoteChapters(ArrayList<Chapter> noteChapters){
        this.noteChapters = noteChapters;
    }
    
    /**
     * Accessor Method: get the ArrayList containing all the chapters of the Note
     * @return ArrayList containing all the chapters of the Note
     */
    public ArrayList<Chapter> getNoteChapters(){
        return noteChapters;
    }
    
    /**
     * Equals method that checks to see if two notes are identical to each other
     * @param notes The 2nd Notes that we are comparing to
     * @return Whether the two notes contain identical ArrayLists of chapters
     */
    public boolean equals(Notes notes){
        return this.noteChapters == notes.noteChapters;
    }
    
    /**
     * Clone method that creates another Note
     * @return Another note that has the identical Chapters as the original one
     */
    public Notes clone(){
        return new Notes(noteChapters);
    }
    
    /**
     * toString method that will output all the information for all chapters
     * @return Information (title and body) of all chapters
     */
    public String toString(){
        String ret = "";
        for(int i = 0; i < noteChapters.size(); i++){
            ret += (noteChapters.get(i)).toString();
        }  
        return ret;
    }
    
}
