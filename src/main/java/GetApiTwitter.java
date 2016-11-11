import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;



import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.List;

import java.util.List;
import java.util.Properties;

/**
 * Created by cloudera on 11/10/16.
 */
public class GetApiTwitter {

     public  void getApiTwitter() throws IOException {



         try {

            String CONSUMER_KEY = "4uw7DrBbWZgXvNmv7RwNGrUWv";
            String CONSUMER_SECRET ="ysspNPKf99FQ4WS4ZcmrNmnoeszUfOT389Q3vcD5fAr4e3ntlp";
            String ACCESS_KEY="94846576-TtJ30mS2aiP8o1A24g0XvHGDb54QON0LqvLQZIrI";
            String ACCESS_SECRET="JDxKC0OubMBELAnINpnwRDtXYj2HZ61wmRr4v5XBbU9N3";


            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(CONSUMER_KEY)
                    .setOAuthConsumerSecret(CONSUMER_SECRET)
                    .setOAuthAccessToken(ACCESS_KEY)
                    .setOAuthAccessTokenSecret(ACCESS_SECRET);

            // gets Twitter instance with default credentials

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

             List<Status> statuses = twitter.getHomeTimeline();
            //System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }



        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }

    }

}
