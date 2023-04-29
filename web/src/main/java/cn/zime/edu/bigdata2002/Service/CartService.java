package cn.zime.edu.bigdata2002.Service;

import cn.zime.edu.bigdata2002.Mapper.CartMapper;
import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Model.Order;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartMapper cartMapper;
    public int selectCounti(){ return cartMapper.selectCounti();}

    public List<Cart> selectAllCart(){
        return cartMapper.selectAllCart();
    }

    public int deleteCart(Integer cid){
        return cartMapper.deleteCart(cid);
    }

    public int selectItem(){return cartMapper.selectItem(); }

//    购物图书总数
    public int selectCountSum(){ return  cartMapper.selectCountSum();}

    public double selectSum(){ return cartMapper.selectSum(); }

    //更新数量
    public int updateMPP(Integer cid){ return cartMapper.updateMPP(cid);}
    public int updateMPPT(Integer cid){ return  cartMapper.updateMPPT(cid);}
    public int updateMPM(Integer cid){ return cartMapper.updateMPM(cid);}
    public int updateMPMT(Integer cid){ return  cartMapper.updateMPMT(cid);}


    //单个图书价格
    public double itemCheck(double cid){ return  cartMapper.itemCheck(cid);}


    //更新check值
    public int updateCheckY(){ return  cartMapper.updateCheckY();}
    public int updateCheckN(){ return  cartMapper.updateCheckN();}

    //已选择多少件
    public int getCheckNum(){return cartMapper.getCheckNum();}

    //单选操作
    public String selectCheckItemok(Integer cid){return cartMapper.selectCheckItemok(cid);}
    public int updateCheckItemY(Integer cid){return cartMapper.updateCheckItemY(cid);}
    public int updateCheckItemN(Integer cid){return cartMapper.updateCheckItemN(cid);}

    /**
     *
     * 确认订单
     */
    //选择的图书进入图书订单
    public List<Cart> selectCheckCart(){return  cartMapper.selectCheckCart();}

    public int selectCheckBookNum(){return cartMapper.selectCheckBookNum();}

    public double selectGetTotalPrice(){ return cartMapper.selectGetTotalPrice();}


    /**
     * 我的订单表操作
     */
    //插入到订单表
    public int insertOrder(Order order){
        return cartMapper.insertOrder(order);
    }
    //订单列表
    public List<Order> selectOrders(){
        return cartMapper.selectOrders();
    }
    //查询订单表的商品
    public int selectOrderNum(){ return cartMapper.selectOrderNum();}
    //查询订单表总价
    public double selectOrderTotal(){return  cartMapper.selectOrderTotal();}
}
