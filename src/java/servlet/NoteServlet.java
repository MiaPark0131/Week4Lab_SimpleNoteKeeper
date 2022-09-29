/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import models.Note;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author meeye
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(path));
 
        String title = br.readLine();
        String contents = br.readLine();
        String edit = request.getParameter("edit");
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);

        try {
            if (edit.equals(""))  {
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        } catch(NullPointerException e) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
        
        br.close();
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        Note note = new Note();
        
        note.setTitle(request.getParameter("title"));
        note.setContents(request.getParameter("contents"));
        
        request.setAttribute("note", note);
        
        
        pw.println(note.getTitle());
        pw.println(note.getContents());
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        pw.close();
    }

    
}
