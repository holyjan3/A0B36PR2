/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetonewsletter;

/**
 *
 * @author Majitel
 */
public enum DataDatabase {    
        HeadAdvatisment("Záhlaví reklama",0,1,false,new DataElement[]{ DataElement.HEAD, DataElement.HEAD_LINK }),
        Introduction ("Úvod",1,1,false,new DataElement[]{DataElement.TEXT}),
        EventFuture("Chystá se",2,0,true, new DataElement[]{DataElement.HEAD,DataElement.HEAD_LINK, DataElement.DATE,
        DataElement.TIME,DataElement.TOWN,DataElement.PLACE,DataElement.TEXT,DataElement.LINK1_TEXT, DataElement.LINK1, DataElement.LINK2_TEXT,
        DataElement.LINK2, DataElement.LINK3_TEXT, DataElement.LINK3}),
        EventPast("Proběhlo",3,0,true, new DataElement[]{DataElement.HEAD,DataElement.HEAD_LINK,DataElement.TEXT, DataElement.LINK1_TEXT,
        DataElement.LINK1,DataElement.LINK2_TEXT,DataElement.LINK2,DataElement.LINK3_TEXT,DataElement.LINK3}),
        PastAdvertisement ("Proběhlo reklama",4,0,true, new DataElement[]{DataElement.HEAD, DataElement.HEAD_LINK, DataElement.TEXT}),
        Declaration("Prohlášeni",5,0,true,new DataElement[]{DataElement.HEAD,DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TYPE}),
        Petition("Petični stánky",6,3,true,new DataElement[]{DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT}),
        Plan("Plánuje se",7,3,true,new DataElement[] {DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT}),
        PlanAdvertisement("Na čem se pracuje",8,1,false, new DataElement[]{DataElement.TEXT, DataElement.TEXT_LINK}),
        PlanInRegion("Na čem se pracuje v regionech",9,4,true, new DataElement[]{DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TOWN}),
        Article("Členove napsali",10,0,true,new DataElement[]{DataElement.HEAD,DataElement.HEAD_LINK,DataElement.NAME,DataElement.MEDIUM});
                
                
        
        protected String name;
        protected int number;
        protected int max;
        protected DataElement[] dataElemen;
        boolean moreInsert;

    private DataDatabase(String name, int number,int max,boolean moreInsert, DataElement[] dataElemen) {
        this.name = name;
        this.max = max;
        this.moreInsert = moreInsert;
        this.number = number;
        this.dataElemen = dataElemen;
    }
        
        
        
        
}
