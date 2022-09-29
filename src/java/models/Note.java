/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author meeye
 */
public class Note {
    private String title;
    private String contents;

    public Note() {
        this.title = "";
        this.contents = "";
    }

    public Note(String _title, String _contents) {
        this.title = _title;
        this.contents = _contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    
    
}
