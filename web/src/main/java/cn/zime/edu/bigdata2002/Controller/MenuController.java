package cn.zime.edu.bigdata2002.Controller;

import cn.zime.edu.bigdata2002.Model.Menu;
import cn.zime.edu.bigdata2002.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    //获取收货地址
    @GetMapping("/getMenu")
    public List<Menu> selectMenu(){
        System.out.println("成功");
        return menuService.selectMenu();

    }
}
