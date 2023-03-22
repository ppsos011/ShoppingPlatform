package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CartMapper {
        /*
        购物车数量
         */
    @Select("select sum(count) from cartble")
    public int selectCounti();


//    图书列表
    @Select("select * from cartble")
    public List<Cart> selectAllCart();

//        删除图书
    @Delete("delete from cartble where cid=#{cid}")
    public int deleteCart(Integer cid);

//        判断购物车是否有商品
    @Select("select count(*) from cartble")
    public int selectItem();

//      计算商品的总数
    @Select("select sum(count) from cartble")
    public int selectCountSum();

    @Select("select sum(total) from cartble")
    public double selectSum();

    /*
    * 加减商品数量和单个图书总价*/
    @Update("update cartble set count=count+1 where cid=#{cid}")
    public int updateMPP(Integer cid);

    @Update("update cartble set total=price*count where cid=#{cid}")
    public int updateMPPT(Integer cid);

    @Update("update cartble set count=count-1 where cid=#{cid}")
    public int updateMPM(Integer cid);
    @Update("update cartble set total=price*count where cid=#{cid}")
    public int updateMPMT(Integer cid);

    //单个图书的价格
    @Select("select price*count from cartble where cid=#{cid}")
    public double itemCheck(double cid);


    //更新check值
    @Update("update cartble set checkok=1 where checkok=0")
    public int updateCheckY();
    @Update("update cartble set checkok=0 where checkok=1")
    public int updateCheckN();

    //已选择多少图书
    @Select("select count(*) from cartble where checkok=1")
    public int getCheckNum();

    //单选操作
    @Select("select checkok from cartble where cid=#{cid}")
    public String selectCheckItemok(Integer cid);
    @Update("update cartble set checkok=1 where cid=#{cid}")
    public int updateCheckItemY(Integer cid);
    @Update("update cartble set checkok=0 where cid=#{cid}")
    public int updateCheckItemN(Integer cid);


    /**
     *
     * 确认订单
     */
    //选择的图书进入图书订单
    @Select("select * from cartble where checkok=1")
    public List<Cart> selectCheckCart();

    //图书件数
    @Select("select sum(count) from cartble where checkok=1")
    public int selectCheckBookNum();

    //总价
    @Select("select sum(total) from cartble where checkok=1")
    public double selectGetTotalPrice();


    /**
     * 我的订单表操作
     */
    //插入到订单表
    @Insert("insert into cartorders values(#{order_id},#{imgURL},#{info},#{price},#{count},#{total},#{order_time})")
    public int insertOrder(Order o);
    //订单列表
    @Select("select * from cartorders")
    public List<Order> selectOrders();
    //查询订单表的商品
    @Select("select sum(count) from cartorders")
    public int selectOrderNum();
    //查询订单表总价
    @Select("select sum(total) from cartorders")
    public double selectOrderTotal();
}
