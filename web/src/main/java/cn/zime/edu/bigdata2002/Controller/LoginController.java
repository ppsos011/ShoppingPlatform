package cn.zime.edu.bigdata2002.Controller;



import cn.zime.edu.bigdata2002.Model.Result;
import cn.zime.edu.bigdata2002.Model.User;
import cn.zime.edu.bigdata2002.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Objects;

@RestController
@Component
public class LoginController {
    @Autowired
    UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        //定义一个下标，方便赋值
        int result = 0;
        //将数据库中的user1表封装成List集合，以便编译
        List<User> users = userService.getUser();
        //获得网页中用户输入的账号和密码
        String name = requestUser.getUsername();
        String password = requestUser.getPassword();
        //将特殊字符转义成HTML
        name = HtmlUtils.htmlEscape(name);

        for (User user : users) {
            if (Objects.equals(name, user.getUsername()) && Objects.equals(password, user.getPassword())) {
                //如果获得的账号密码和数据库中相同，那么赋值给result为0
                result = 0;
            } else {
                //如果获得的账号密码和数据库中不相同，那么赋值给result为1
                result = 1;
            }
        }

        if (result == 0){
            //如果result=0，那么给一个200响应码传给前端
            return new Result(200, "success");
        } else {
            //如果result=1，那么给一个400响应码传给前端
            return new Result(400, "fail");
        }
    }
}
