/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsletterdatabase;


/**
 *
 * @author Majitel
 */
final public class Element{
    protected DataElements[] DE;    
    protected String[] strings_of_elements; 

    public Element(DataElements[] DE, String[] strings_of_elements) {
        this.DE = DE;
        this.strings_of_elements = contorlStringElement(strings_of_elements);
    }
    
    
    public Element(DataElements[] DE, String strin_of_elements){
        this.DE = DE;
        this.strings_of_elements  = parseString(strin_of_elements);
    }
    
     
    public String controlDatabaseElement(DataElements dl, String ss) {
        
        switch (dl) {
            case DAY:
                break;
            case MONTH:
                break;
            case YEAR:
                break;
            case HOUR:
                break;
            case MINUTE:
                break;
            case HEAD:
                break;
            case HEAD_LINK:
                break;
            case TOWN:
                break;
            case PLACE:
                break;
            case TEXT:
                break;
            case LINK1_TEXT:
                break;
            case LINK2_TEXT:
                break;
            case LINK3_TEXT:
                break;
            case LINK1:
                break;
            case LINK2:
                break;
            case LINK3:
                break;
            case NAME:
                break;
            case MEDIUM:
                break;          
        }
        return null;
            
    }
    
    public boolean setString_of_element(String ss,int i) {
        if(ss.compareTo("")!=0){
            ss = controlDatabaseElement(DE[i], ss);
            if(ss != null){
                this.strings_of_elements[i] = ss;
                return true;
            } else {
                return false;
            }
        } else {
            this.strings_of_elements[i] = ss;
            return true;
        }
    }
    
    
    public String[] parseString(String string_to_parse){
        String[] ss = string_to_parse.split("[#]");
        for (int i = 0; i < this.DE.length; i++) {
            if(ss.length < i) {
            this.strings_of_elements[i] = controlDatabaseElement(DE[i], ss[i]);
            } else {
            this.strings_of_elements[i] = "";    
            }
        }
        return ss;
    }
    
    public String[] contorlStringElement(String[] strings_of_elements) {
        String ss[] = new String[DE.length];
        for (int i = 0; i < DE.length; i++) {
            if((strings_of_elements[i].compareTo("")!=0)){
             ss[i] = controlDatabaseElement(DE[i], strings_of_elements[i]);
            }         
        }
        return ss;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.strings_of_elements.length-1; i++) {
            sb.append(this.strings_of_elements[i]);
            sb.append("#");
        }
        sb.append(this.strings_of_elements[this.strings_of_elements.length-1]);
        return sb.toString();
    }    
    
}
