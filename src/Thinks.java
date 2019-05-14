import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class Thinks {

    public double Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return -1;
        if ((a + b) > c && (c + b) > a && (a + c) > b)
            return a + b + c;
        return -1;
    }

    public String Write(String text) {
        if (text == null)
            return null;
        return text;
    }

    public void MG(){

        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoCredential credential;
        credential = MongoCredential.createCredential("root","JavaUser", "password".toCharArray());
        MongoDatabase database = mongoClient.getDatabase("JavaUser");

        MongoCollection<org.bson.Document> col = database.getCollection("PID");

        List listDob = new ArrayList();

        try (MongoCursor<org.bson.Document> cur = col.find().iterator()) {
            while (cur.hasNext()) {

                org.bson.Document doc = cur.next();

                List listPid = new ArrayList(doc.values());
                System.out.print(listDob.get(1));
                System.out.print(": ");
                System.out.println(listDob.get(2));
                System.out.print(": ");
                System.out.println(listDob.get(3));

            }
        }

        mongoClient.close();

    }

}
