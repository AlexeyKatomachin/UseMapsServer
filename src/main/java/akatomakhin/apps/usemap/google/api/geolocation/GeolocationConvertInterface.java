package akatomakhin.apps.usemap.google.api.geolocation;

import akatomakhin.apps.usemap.entity.map.Map;
import akatomakhin.apps.usemap.entity.map.geolocation.client.request.LocationData;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public interface GeolocationConvertInterface {
    Map convert(LocationData locationData);
}
