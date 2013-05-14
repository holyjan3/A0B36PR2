/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter.userinterface;

import javax.swing.JTextArea;
import javax.swing.text.Document;

/**
 *
 * @author Majitel
 */
public class JTextAreaWithNumber extends JTextArea{
    /**
     *
     */
    final int number;

    /**
     *
     * @param number
     */
    public JTextAreaWithNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @param number
     * @param doc
     */
    public JTextAreaWithNumber(int number, Document doc) {
        super(doc);
        this.number = number;
    }

    /**
     *
     * @param number
     * @param text
     */
    public JTextAreaWithNumber(int number, String text) {
        super(text);
        this.number = number;
    }

    /**
     *
     * @param number
     * @param rows
     * @param columns
     */
    public JTextAreaWithNumber(int number, int rows, int columns) {
        super(rows, columns);
        this.number = number;
    }

    /**
     *
     * @param number
     * @param text
     * @param rows
     * @param columns
     */
    public JTextAreaWithNumber(int number, String text, int rows, int columns) {
        super(text, rows, columns);
        this.number = number;
    }

    /**
     *
     * @param number
     * @param doc
     * @param text
     * @param rows
     * @param columns
     */
    public JTextAreaWithNumber(int number, Document doc, String text, int rows, int columns) {
        super(doc, text, rows, columns);
        this.number = number;
    }

  
}
