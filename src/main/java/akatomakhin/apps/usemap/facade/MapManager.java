package akatomakhin.apps.usemap.facade;

import akatomakhin.apps.usemap.dao.MySQL.MySQLMapManager;
import akatomakhin.apps.usemap.entity.messages.message.Message;
import akatomakhin.apps.usemap.entity.messages.message.entity.MessageEntity;
import akatomakhin.apps.usemap.entity.map.Map;
import akatomakhin.apps.usemap.entity.map.geolocation.client.request.LocationData;
import akatomakhin.apps.usemap.google.api.geolocation.GeolocationConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MapManager implements MapManagerInterface {

    private MySQLMapManager mySQLMapManager;

    @Autowired
    public MapManager(MySQLMapManager mySQLMapManager) {
        this.mySQLMapManager = mySQLMapManager;
    }



    @Override
    public Message create(LocationData locationData) {
        Map map = new GeolocationConvertor().convert(locationData);
        mySQLMapManager.createMapData(map);
        MessageEntity messageEntity = new MessageEntity();
        Message message = new Message();
        if (map.equals(new Map())){
            messageEntity.setDomain("Create map Error");
            messageEntity.setMessage("Map wasn't create. Your ID isn't correct");
            messageEntity.setReason("Create map Error");
            message.setErrors(messageEntity);
            message.setCode(400);
            message.setMessage("Request Error");
            return message;
        }else{
            message.setCode(200);
            return message;
        }
    }

    @Override
    public Message update(LocationData locationData, int mapID) {
        Map map = mySQLMapManager.getMapDada(mapID);
        mySQLMapManager.updateMapDada(new GeolocationConvertor().convert(locationData), mapID);
        MessageEntity messageEntity = new MessageEntity();
        Message message = new Message();

        if (map.equals(mySQLMapManager.getMapDada(mapID))){
            messageEntity.setDomain("Update map Error");
            messageEntity.setMessage("Map wasn't create. Your gmail isn't correct");
            messageEntity.setReason("Update map Error");
            message.setErrors(messageEntity);
            message.setCode(400);
            message.setMessage("Request Error");
            return message;
        }else{
            message.setCode(200);
            return message;
        }
    }


    @Override
    public Message deleteMap(int mapID) {
        mySQLMapManager.deleteMapData(mapID);
        MessageEntity messageEntity = new MessageEntity();
        Message message = new Message();
        if (new Map().equals(mySQLMapManager.getMapDada(mapID))){
            message.setCode(200);
            return message;
        }else{
            messageEntity.setDomain("Delete map Error");
            messageEntity.setMessage("Map wasn't delete. Your ID isn't correct");
            messageEntity.setReason("Delete Map Error");
            message.setErrors(messageEntity);
            message.setCode(400);
            message.setMessage("Request Error");
            return message;
        }
    }

    @Override
    public int getMapId(Map map){
        return mySQLMapManager.getMapId(map);
    }

    @Override
    public Map getMap(int mapID) {
        return mySQLMapManager.getMapDada(mapID);
    }

    @Override
    public List<Map> getAllMapsData() {
        return mySQLMapManager.getAllMapData();
    }
}
