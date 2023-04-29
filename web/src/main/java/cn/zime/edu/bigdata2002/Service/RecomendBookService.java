package cn.zime.edu.bigdata2002.Service;

import cn.zime.edu.bigdata2002.Mapper.RecomendBookMapper;
import cn.zime.edu.bigdata2002.Model.RecomendBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecomendBookService {
    @Autowired
    RecomendBookMapper recomendBookMapper;
    public List<RecomendBook> selectRecomendBook(){
        return recomendBookMapper.selectRecomendBook();
    }
}
