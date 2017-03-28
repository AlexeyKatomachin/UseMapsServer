package akatomakhin.apps.usemap.dao;

import akatomakhin.apps.usemap.entity.connection.db.hibernate.entity.MapEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public interface MapRepositoryInterface extends CrudRepository<MapEntity,Integer>{

}
