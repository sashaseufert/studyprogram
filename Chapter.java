//Albert Tang (with Chen, Seufert)
//November 28 2018
//Chapter Class

package projmangproj;

public class Chapter {
    private String title;
    private String body;
    
    /**
     * Primary Constructor: Construct a new chapter object with no title or body information
     */
    public Chapter(){
        title = "";
        body = "";
    }
    
    /**
     * Secondary Constructor: Construct a new chapter object with a given title and body
     * @param title The given title of the chapter
     * @param body The give body paragraph(s) of the chapter
     */
    public Chapter(String title, String body){
        this.title = title;
        this.body = body;
    }
    
    /**
     * Mutator Method: get the title of the chapter
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Accessor Method: set the title of the chapter
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Mutator Method: get the body paragraph(s) of the chapter
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Accessor Method: set the body paragraph(s) of the chapter
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    /**
     * Equals method to determine whether two chapters are equal
     * @param chapter The chapter that we are comparing to
     * @return Whether the title and the body paragraph(s) of the chapter are equal
     */
    public boolean equals(Chapter chapter){
        return this.title == chapter.title &&
                this.body == chapter.body;
    }
    
    /**
     * Clone method to generate an identical Chapter
     * @return an identical Chapter object
     */
    public Chapter clone(){
        return new Chapter(title, body);
    }    
    
    /**
     * toString method to generate String that contain information about what the title and body of the chapter is
     * @return String that contain information about what the title and body of the chapter is
     */
    public String toString(){
        return "Title: " + title + "\nBody: " + body;
    }

    
    
}
