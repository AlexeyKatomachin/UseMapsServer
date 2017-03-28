package akatomakhin.apps.usemap.facade;

/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class MySQLMapManagerTest {

    @Autowired
    private MapManagerInterface mapManager;

    public static LocationData location(){
        LocationData location = new LocationData();
        WiFiData wiFiData = new WiFiData();
        wiFiData.setSignalStrength(-43);
        wiFiData.setSignalToNoiseRatio(0);
        wiFiData.setMacAddress("00:25:9c:cf:1c:ac");
        location.setWifiAccessPoints(wiFiData);
        WiFiData wiFiData1 = new WiFiData();
        wiFiData1.setMacAddress("00:25:9c:cf:1c:ad");
        wiFiData1.setSignalStrength(-55);
        wiFiData1.setSignalToNoiseRatio(0);
        location.setWifiAccessPoints(wiFiData1);
        location.setHomeMobileCountryCode(375);
        location.setHomeMobileNetworkCode(293);
        location.setCarrier("");
        location.setConsiderIp("false");
        return location;
    }


    public static Map map(){
        Map map = new Map();
        Location location = new Location();
        location.setLat(53.904539799999995);
        location.setLng(27.5615244);
        map.setLocation(location);
        map.setAccuracy(16854);
        return map;
    }

    @Test
    public void createMapTest(){
        mapManager.create(location());
        int mapId = mapManager.getMapId(map());
        assertEquals(map().getAccuracy(), mapManager.getMap(mapId).getAccuracy(),map().getAccuracy());
        assertEquals(map().getLocation().getLat(),mapManager.getMap(mapId).getLocation().getLat(),map().getLocation().getLat());
        assertEquals(map().getLocation().getLng(),mapManager.getMap(mapId).getLocation().getLng(),map().getLocation().getLng());
    }

    @Test
    public void updateMapTest(){
        int mapId = mapManager.getMapId(map());
        mapManager.update(location(),mapId);
        assertEquals(map().getAccuracy(), mapManager.getMap(mapId).getAccuracy(),map().getAccuracy());
        assertEquals(map().getLocation().getLat(),mapManager.getMap(mapId).getLocation().getLat(),map().getLocation().getLat());
        assertEquals(map().getLocation().getLng(),mapManager.getMap(mapId).getLocation().getLng(),map().getLocation().getLng());
    }

    @Test
    public void getMapTest(){
        int mapId = mapManager.getMapId(map());
        assertEquals(map().getAccuracy(), mapManager.getMap(mapId).getAccuracy(),map().getAccuracy());
        assertEquals(map().getLocation().getLat(),mapManager.getMap(mapId).getLocation().getLat(),map().getLocation().getLat());
        assertEquals(map().getLocation().getLng(),mapManager.getMap(mapId).getLocation().getLng(),map().getLocation().getLng());
    }

    @Test
    public void getAllMapsTest(){
        for (Map map: mapManager.getAllMapsData()) {
            assertNotNull(map.getLocation().getLng());
            assertNotNull(map.getLocation().getLat());
            assertNotNull(map.getAccuracy());
        }
    }

    @Test
    public void deleteMap(){
        int mapId = mapManager.getMapId(map());
        System.out.println("======================= " + mapId);
        mapManager.deleteMap(mapId);
        */
/*for (Map map: mapManager.getAllMapsData()) {
            assertNotEquals(map().getAccuracy(),map.getAccuracy(),map().getAccuracy());
            assertNotEquals(map().getLocation().getLng(),map.getLocation().getLng(),map().getLocation().getLng());
            assertNotEquals(map().getLocation().getLat(),map.getLocation().getLat(),map().getLocation().getLat());
        }*//*

    }
}
*/
