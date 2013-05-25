/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasework;

import databasework.DataElement;
import databasework.DataElementInterface;
import databasework.DataDatabaseInteraface;


/**
 * jsou zde uložena jaké položky obsahují jednotlivé typy záznamů metoda name() vraci jmeno typu záznamu v databázi
 * @author Jan Holý
 */
public enum DataDatabase implements DataDatabaseInteraface{    
        
    /**
     * Záhlaví reklama
     */
    HeadAdvertisement("Záhlaví reklama",1,new DataElement []{ DataElement.HEAD,DataElement.TEXT_LINK, DataElement.HEAD_LINK}),
        
    /**
     * Úvod
     */
    Introduction ("Úvod",1,new DataElement[]{DataElement.TEXT}),
        
    /**
     * Chystá se
     */
    EventsFuture("Chystá se",0,new DataElement[]{DataElement.HEAD,DataElement.TEXT_LINK,DataElement.HEAD_LINK,DataElement.DATE,
        DataElement.TIME,DataElement.TOWN,DataElement.PLACE,DataElement.TEXT,DataElement.LINK1_TEXT, DataElement.LINK1, DataElement.LINK2_TEXT,
        DataElement.LINK2, DataElement.LINK3_TEXT, DataElement.LINK3}),
        
    /**
     * Proběhlo
     */
    EventsPast("Proběhlo",0,new DataElement[]{DataElement.HEAD,DataElement.TEXT_LINK,DataElement.HEAD_LINK,DataElement.TEXT, DataElement.LINK1_TEXT,
        DataElement.LINK1,DataElement.LINK2_TEXT,DataElement.LINK2,DataElement.LINK3_TEXT,DataElement.LINK3}),
        
    /**
     * Proběhlo reklama
     */
    EventPastAdvertisements ("Proběhlo reklama",0, new DataElement[]{DataElement.HEAD, DataElement.TEXT_LINK,DataElement.HEAD_LINK, DataElement.TEXT}),
        
    /**
     * Prohlášeni
     */
    Declarations("Prohlášeni",0,new DataElement[]{DataElement.HEAD,DataElement.TEXT_LINK,DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TYPE}),
        
    /**
     * Petični stánky
     */
    Petitions("Petični stánky",3,new DataElement[]{DataElement.HEAD, DataElement.TEXT_LINK,DataElement.HEAD_LINK,DataElement.TEXT}),
        
    /**
     * Na čem se pracuje
     */
    Plans("Na čem se pracuje",3,new DataElement[] {DataElement.HEAD,DataElement.TEXT_LINK, DataElement.HEAD_LINK,DataElement.TEXT}),
        
    /**
     * Na čem se pracuje Reklama
     */
    PlanAdvertisement("Na čem se pracuje Reklama",1, new DataElement[]{DataElement.HEAD,DataElement.TEXT_LINK, DataElement.HEAD_LINK,DataElement.TEXT}),
        
    /**
     * Na čem se pracuje v regionech
     */
    PlansInRegion("Na čem se pracuje v regionech",3, new DataElement[]{DataElement.HEAD,DataElement.TEXT_LINK, DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TOWN}),
        
    /**
     * Členove napsali
     */
    Articles("Členove napsali",0,new DataElement[]{DataElement.HEAD,DataElement.TEXT_LINK,DataElement.HEAD_LINK,DataElement.NAME,DataElement.MEDIUM});
                
                
        
        
    /**
     * název databáze určena pro styk s uživatelem
     */
    final private String name;               
    /**
     * maximální počet záznamů vložitelné do html tabulky
     */
    final private int max;        
    /**
     *  typy položek DateElement uložené  v záznamech
     */
    final private DataElementInterface[] dataElemen;

    private DataDatabase(String name,int max, DataElement[] dataElemen) {
        this.name = name;
        this.max = max;
        this.dataElemen = dataElemen;
       
    }
    
    public String getName(){
        return name;
    }

    public DataElementInterface[] getDataElemen() {
        return dataElemen;
    }

    public int getMax() {
        return max;
       
       
    }

   
    @Override
    public DataDatabaseInteraface[] valuesReturn() {
        return null;
    }
}
