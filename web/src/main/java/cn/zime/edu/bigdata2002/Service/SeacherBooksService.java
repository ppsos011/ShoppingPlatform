package cn.zime.edu.bigdata2002.Service;


import cn.zime.edu.bigdata2002.Mapper.SeacherBooksMapper;
import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Model.SeacherTg;
import cn.zime.edu.bigdata2002.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeacherBooksService {

    @Autowired
    SeacherBooksMapper seacherBooksMapper;

    //从controller层拿到这两个值
    public Object selectBooks(Integer page,Integer limit){
        //通过这个工具类来分页
        PageHelper.startPage(page,limit);
        return ResponseUtil.okList(seacherBooksMapper.selectBooks());

    }

    public List<SeacherTg> selectTg(){
        return seacherBooksMapper.selectTg();
    }

    public int inserCart(Cart cart){return seacherBooksMapper.insertCart(cart);}

//    public List<SeacherBooks> selectBooks2(String input){
//        return  seacherBooksMapper.selectBooks2(input);
//    }

}
