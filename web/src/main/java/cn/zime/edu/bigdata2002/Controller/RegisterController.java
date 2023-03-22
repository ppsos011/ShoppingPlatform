package cn.zime.edu.bigdata2002.Controller;


import cn.zime.edu.bigdata2002.Model.User;
import cn.zime.edu.bigdata2002.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping("/register")
    public int insertUser(@RequestParam(value = "Uname") String username,
                          @RequestParam(value = "Upsd") String password,
                          @RequestParam(value = "UphoneN") String phonenum,
                          @RequestParam(value = "Upro") String profession){
        return registerService.insertUser(new User(username,password,phonenum,profession));

    }
}
