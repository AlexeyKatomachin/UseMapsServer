package akatomakhin.apps.usemap.facade;

import akatomakhin.apps.usemap.entity.map.Map;
import akatomakhin.apps.usemap.entity.map.geolocation.client.request.LocationData;
import akatomakhin.apps.usemap.entity.messages.message.Message;

import java.util.List;


public interface MapManagerInterface {
    Message create (LocationData locationData);
    Message update (LocationData locationData, int mapID);
    Message deleteMap (int mapID);
    int getMapId (Map map);
    Map getMap(int mapID);
    List<Map> getAllMapsData();
}
