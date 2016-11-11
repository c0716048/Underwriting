import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by cloudera on 11/11/16.
 */


public class GetApiWatson {
    public void getApiWatson(){

        PersonalityInsights service = new PersonalityInsights("2016-10-20");
        service.setUsernameAndPassword("60a2dcf0-5eb2-4ad3-9e54-e2578ef6a47d", "DPaIeZ6kDPmV");


        try {
            JsonReader jReader = new JsonReader(new FileReader("./profile.json"));

            Content content = GsonSingleton.getGson().fromJson(jReader, Content.class);
            ProfileOptions options = new ProfileOptions.Builder()
                    .contentItems(content.getContentItems())
                    .consumptionPreferences(true)
                    .rawScores(true)
                    .build();
            Profile profile = service.getProfile(options).execute();
            System.out.println(profile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    }

