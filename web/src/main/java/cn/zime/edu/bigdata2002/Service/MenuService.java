package cn.zime.edu.bigdata2002.Service;

import cn.zime.edu.bigdata2002.Mapper.MenuMapper;
import cn.zime.edu.bigdata2002.Model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> selectMenu(){
        return menuMapper.selectMenu();
    }
}
