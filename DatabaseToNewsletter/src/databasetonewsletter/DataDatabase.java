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
        HeadAdvatisment("Zahlovi reklama",1,new DataElement[]{DataElement.PRINTED , DataElement.TEXT, DataElement.TEXT_LINK }),
        Introduction ("Uvod",2,new DataElement[]{DataElement.PRINTED ,  DataElement.TEXT, DataElement.TEXT_LINK}),
        EventFuture("Pozvanky",3, new DataElement[]{DataElement.PRINTED,DataElement.HEAD, DataElement.DATE,
        DataElement.TIME,DataElement.HEAD_LINK,DataElement.PLACE,DataElement.TEXT,
        DataElement.LINK1_TEXT, DataElement.LINK2_TEXT, DataElement.LINK3_TEXT, DataElement.LINK1, DataElement.LINK2,DataElement.LINK3}),
        EventPast("Proběhlo",4, new DataElement[]{DataElement.PRINTED,DataElement.HEAD,DataElement.TEXT, DataElement.LINK1_TEXT,
        DataElement.LINK1,DataElement.LINK2_TEXT,DataElement.LINK2,DataElement.LINK3_TEXT,DataElement.LINK3}),
        EvetPastAdvertisement ("probehlo reklama",5, new DataElement[]{DataElement.PRINTED, DataElement.TEXT,DataElement.TEXT_LINK}),
        Declaration("prohlaseni",6,new DataElement[]{DataElement.PRINTED,DataElement.HEAD,DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TYPE}),
        Petition("peticni stanky",7,new DataElement[]{DataElement.PRINTED,DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT}),
        Plan("planuje se",8,new DataElement[] {DataElement.PRINTED,DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT}),
        PlanAdvertisement("planuje se reklama",9, new DataElement[]{DataElement.PRINTED, DataElement.TEXT, DataElement.TEXT_LINK}),
        PlanInRegion("planuje se v regionech",10, new DataElement[]{DataElement.PRINTED,DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TOWN}),
        Article("clenove napsali",11,new DataElement[]{DataElement.PRINTED,DataElement.HEAD,DataElement.HEAD_LINK,DataElement.NAME,DataElement.MEDIUM});
                
                
        
        protected String name;
        protected int number;
        protected DataElement[] dataElemen;

    private DataDatabase(String name, int number, DataElement[] dataElemen) {
        this.name = name;
        this.number = number;
        this.dataElemen = dataElemen;
    }
        
        
        
        
}
