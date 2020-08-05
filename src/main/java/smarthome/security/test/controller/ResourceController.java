package smarthome.security.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月27日 下午2:40:11
* @description 
*/
@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping
    public String listTasks(){
        return "resource_list";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String newTasks(){
        return "add a resource";
    }

    @PutMapping("/{resourceId}")
    public String updateTasks(@PathVariable("resoureceId")Integer id){
        return "update id:"+id;
    }

    @DeleteMapping("/{resourceId}")
    public String deleteTasks(@PathVariable("resourceId")Integer id){
        return "delete id:"+id;
    }
}
