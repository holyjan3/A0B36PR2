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
        HeadAdvatisment("Zahlovi reklama","1-2-1-1-1-3",new DataElement[]{DataElement.PRINTED , DataElement.TEXT, DataElement.TEXT_LINK }),
        Introduction ("Uvod","1-2-1-1-1-3",new DataElement[]{DataElement.PRINTED ,  DataElement.TEXT, DataElement.TEXT_LINK}),
        EventFuture("Pozvanky","1-2-1-4", new DataElement[]{DataElement.PRINTED,DataElement.HEAD, DataElement.DATE,
        DataElement.TIME,DataElement.HEAD_LINK,DataElement.PLACE,DataElement.TEXT,
        DataElement.LINK1_TEXT, DataElement.LINK2_TEXT, DataElement.LINK3_TEXT, DataElement.LINK1, DataElement.LINK2,DataElement.LINK3}),
        EventPast("Proběhlo","1-2-1-6-1-1-1", new DataElement[]{DataElement.PRINTED,DataElement.HEAD,DataElement.TEXT, DataElement.LINK1_TEXT,
        DataElement.LINK1,DataElement.LINK2_TEXT,DataElement.LINK2,DataElement.LINK3_TEXT,DataElement.LINK3}),
        EvetPastAdvertisement ("probehlo reklama","1-2-1-6-1-2-1", new DataElement[]{DataElement.PRINTED, DataElement.TEXT,DataElement.TEXT_LINK}),
        Declaration("prohlaseni","1-2-1-8",new DataElement[]{DataElement.PRINTED,DataElement.HEAD,DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TYPE}),
        Petition("peticni stanky","1-2-1-9-1",new DataElement[]{DataElement.PRINTED,DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT}),
        Plan("planuje se","1-2-1-11-1-1-1-1",new DataElement[] {DataElement.PRINTED,DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT}),
        PlanAdvertisement("planuje se reklama","1-2-1-11-2", new DataElement[]{DataElement.PRINTED, DataElement.TEXT, DataElement.TEXT_LINK}),
        PlanInRegion("planuje se v regionech","1-2-1-13", new DataElement[]{DataElement.PRINTED,DataElement.HEAD, DataElement.HEAD_LINK,DataElement.TEXT,DataElement.TOWN}),
        Article("clenove napsali","1-2-1-15",new DataElement[]{DataElement.PRINTED,DataElement.HEAD,DataElement.HEAD_LINK,DataElement.NAME,DataElement.MEDIUM});
                
                
        
        protected String name;
        protected String path;
        protected DataElement[] dataElemen;

    private DataDatabase(String name, String path, DataElement[] dataElemen) {
        this.name = name;
        this.path = path;
        this.dataElemen = dataElemen;
    }
        
        
        
        
}
