package akatomakhin.apps.usemap.controller;

import akatomakhin.apps.usemap.entity.map.Map;
import akatomakhin.apps.usemap.entity.map.geolocation.client.request.LocationData;
import akatomakhin.apps.usemap.entity.messages.Error;
import akatomakhin.apps.usemap.entity.messages.message.Message;
import akatomakhin.apps.usemap.entity.user.User;
import akatomakhin.apps.usemap.facade.MapManagerInterface;
import akatomakhin.apps.usemap.facade.UserManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
@Controller
@RequestMapping("/usemaps")
public class UseMapsController {

    private UserManagerInterface userManager;
    MapManagerInterface mapManager;

    @Autowired
    public UseMapsController(UserManagerInterface userManager, MapManagerInterface mapManager){
        this.userManager = userManager;
        this.mapManager = mapManager;
    }

    /* Get Methods*/
    @RequestMapping(path = "/map/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map getMap(@PathVariable("id") int id){
        return mapManager.getMap(id);
    }

    @RequestMapping(path = "/user/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") int id){
        return userManager.getUser(id);
    }

    @RequestMapping(path = "/user",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(){
        return userManager.getAllUsers();
    }

    @RequestMapping(path = "/map",method = RequestMethod.GET)
    @ResponseBody
    public List<Map> getAllMaps(){
        return mapManager.getAllMapsData();
    }

    /* PUT Methods*/
    @RequestMapping(path = "/user/{id}",method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Error> updateUser(@RequestBody User user, @PathVariable("id") int id){
        Message message = userManager.update(user, id);
        Error error = new Error();
        error.setError(message);
        if(message.getCode() == 200) {
            return new ResponseEntity<Error>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(path = "/map/{id}",method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Error> updateMap(@RequestBody LocationData locationData, @PathVariable("id") int id){
        Message message = mapManager.update(locationData,id);
        Error error = new Error();
        error.setError(message);
        if(message.getCode() == 200){
            return new ResponseEntity<Error>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
        }
    }

    /* POST Methods*/
    @RequestMapping(path = "/user",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> createUser(@RequestBody User user){
        Message message = userManager.create(user);
        new User().setId(userManager.getUserId(user));
        user.setId(userManager.getUserId(user));
        if(message.getCode() == 200){
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }else {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Error> createMap(@RequestBody LocationData locationData){
        Message message = mapManager.create(locationData);
        Error error = new Error();
        error.setError(message);
        if(message.getCode() == 200){
            return new ResponseEntity<Error>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
        }
    }

    /* DELETE Methods*/
    @RequestMapping(path = "/user/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody ResponseEntity<Error> deleteUser(@PathVariable("id") int id){
        Message message = userManager.deleteUser(id);
        Error error = new Error();
        error.setError(message);
        if(message.getCode() == 200){
            return new ResponseEntity<Error>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/map/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Error> deleteMap(@PathVariable("id") int id){
        Message message = mapManager.deleteMap(id);
        Error error = new Error();
        error.setError(message);
        if(message.getCode() == 200){
            return new ResponseEntity<Error>(error,HttpStatus.OK);
        }else {
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

}
