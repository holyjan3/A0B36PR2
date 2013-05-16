/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import javax.swing.JTextArea;
import javax.swing.text.Document;

/**
 * Textová Area s číslem
 * @author Jan Holý
 */
public class JTextAreaWithNumber extends JTextArea{

    final int number;


    public JTextAreaWithNumber(int number) {
        this.number = number;
    }

    public JTextAreaWithNumber(int number, Document doc) {
        super(doc);
        this.number = number;
    }


    public JTextAreaWithNumber(int number, String text) {
        super(text);
        this.number = number;
    }


    public JTextAreaWithNumber(int number, int rows, int columns) {
        super(rows, columns);
        this.number = number;
    }


    public JTextAreaWithNumber(int number, String text, int rows, int columns) {
        super(text, rows, columns);
        this.number = number;
    }


    public JTextAreaWithNumber(int number, Document doc, String text, int rows, int columns) {
        super(doc, text, rows, columns);
        this.number = number;
    }

  
}
