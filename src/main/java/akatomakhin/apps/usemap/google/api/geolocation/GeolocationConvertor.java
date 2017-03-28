package akatomakhin.apps.usemap.google.api.geolocation;

import akatomakhin.apps.usemap.entity.map.Map;
import akatomakhin.apps.usemap.entity.map.geolocation.client.request.LocationData;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class GeolocationConvertor implements GeolocationConvertInterface {

    @Value("${geolocation.url}")
    private String url = "https://www.googleapis.com/geolocation/v1/geolocate";

    @Value("${geolocation.key}")
    private String key = "AIzaSyBXw9R1X9oJeGgGZwsy5E1-P7zI-4H4sgg";
    ///js - AIzaSyCW-wEaEWLarfhU6SVs1C-4Y95U80JFwq8
    @Override
    public Map convert(LocationData locationData) {
        Map map = new Map();
        try {
            URL obj = new URL(url+"?key=" + key);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setConnectTimeout(1000);

            connection.setRequestProperty("Content-type", "application/json");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.setRequestMethod("POST");
            connection.connect();
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());


            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer,locationData);
            writer.flush();
            writer.close();

            DataInputStream in = new DataInputStream(connection.getInputStream());
            map = mapper.readValue(in,Map.class);

            System.out.println();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
