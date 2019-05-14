import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThinksTest {

    @Before
    public void setUp() throws Exception {

        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoCredential credential;
        credential = MongoCredential.createCredential("root","JavaUser", "password".toCharArray());
        MongoDatabase database = mongoClient.getDatabase("JavaUser");

        MongoCollection<Document> col = database.getCollection("PID");

        Document user1 = new Document();
        Document user2 = new Document();
        Document user3 = new Document();

        user1.append("fname","a").append("lname","q").append("pid","2104199865");
        user2.append("fname","b").append("lname","w").append("pid","1778598652");
        user3.append("fname","c").append("lname","e").append("pid","0102456589");

        col.insertOne(user1);
        col.insertOne(user2);
        col.insertOne(user3);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void triangle() {
        Thinks ts = new Thinks();
        assertEquals(-1, ts.Triangle(5,6,25), 0.00000001 );
    }

    @Test
    public void write() {

    }
}