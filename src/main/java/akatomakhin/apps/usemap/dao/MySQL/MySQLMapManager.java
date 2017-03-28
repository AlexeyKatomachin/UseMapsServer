package akatomakhin.apps.usemap.dao.MySQL;

import akatomakhin.apps.usemap.dao.MapRepositoryInterface;
import akatomakhin.apps.usemap.entity.connection.db.hibernate.entity.MapEntity;
import akatomakhin.apps.usemap.entity.map.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableTransactionManagement
public class MySQLMapManager {

    private MapRepositoryInterface mapRepository;

    @Autowired
    public MySQLMapManager(MapRepositoryInterface mapRepository){
        this.mapRepository = mapRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createMapData(Map map){
        MapEntity mapEntity = new MapEntity();
        mapEntity.setMap(map);
        mapRepository.save(mapEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMapDada(Map map, int mapID) {
        MapEntity mapEntity = new MapEntity();
        mapEntity.setMap(map);
        mapEntity.setId(mapID);
        mapRepository.save(mapEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMapData(int mapID) {
        mapRepository.delete(mapID);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Map getMapDada(int mapID) {
        return mapRepository.findOne(mapID).getMap();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public int getMapId(Map map){
        int mapId = 0;
        List<MapEntity> mapEntities = (ArrayList<MapEntity>)mapRepository.findAll();
        for (MapEntity mapEntity: mapEntities) {
            if((mapEntity.getAccuracy() == map.getAccuracy())&&(mapEntity.getLat() == map.getLocation().getLat())&&(mapEntity.getLng() == map.getLocation().getLng())){
                mapId = mapEntity.getId();
            }
        }
        return mapId;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Map> getAllMapData() {
        List<MapEntity> mapEntities = (ArrayList<MapEntity>)mapRepository.findAll();
        ArrayList<Map> maps = new ArrayList<Map>();
        for (MapEntity mapEntity: mapEntities) {
            maps.add(mapEntity.getMap());
        }
        return maps;
    }
}
