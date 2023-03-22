package cn.zime.edu.bigdata2002.Controller;

import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Model.Order;
import cn.zime.edu.bigdata2002.Service.CartService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cartbookssum")
    public int selectCounti(){return cartService.selectCounti();}

//    图书列表
    @GetMapping("/cartlists")
    public List<Cart> selectALLCart(){
        return cartService.selectAllCart();
    }



//    判断购物车是否有商品
    @GetMapping("/searchshow")
    public int selectItem(){
        return cartService.selectItem();
    }

    // 计算商品的总数//
    @GetMapping("/getnum")
    public int selectCountSum(){return  cartService.selectCountSum();}

    @GetMapping("/selectsumm")
    public double selectSum(){
        return cartService.selectSum();
    }


    //更新数量
    @GetMapping("/cminplusp")
    public int updateMPP(@RequestParam(value = "key1") Integer cid){
        return cartService.updateMPP(cid);
    }
    @GetMapping("/cminpluspp")
    public int updateMPPT(@RequestParam(value = "key1") Integer cid){ return cartService.updateMPPT(cid);}
    @GetMapping("/cminplusm")
    public int updateMPM(@RequestParam(value = "key1") Integer cid){ return cartService.updateMPM(cid);  }
    @GetMapping("/cminplusmm")
    public int updateMPMT(@RequestParam(value = "key1") Integer cid){ return cartService.updateMPMT(cid);}



    //    删除图书
    @GetMapping("/deletebook")
    public int deleteCart(@RequestParam(value = "key1") Integer cid){
        return cartService.deleteCart(cid);
    }

    //单个图书价格
    @GetMapping("/itemcheck")
    public double itemCheck(@RequestParam(value = "key1") double cid) { return cartService.itemCheck(cid);}

    //更新check值
    @GetMapping("/updatecheck1")
    public int updateCheckY(){return cartService.updateCheckY();}
    @GetMapping("/updatecheck0")
    public int updateCheckN(){return cartService.updateCheckN();}


    //已选择多少件
    @GetMapping("/getchecknum")
    public int getCheckNum(){return cartService.getCheckNum();}

    //单选操作
    @GetMapping("/checkitem")
    public String selectCheckItemok(@RequestParam(value = "key1") Integer cid){
        return cartService.selectCheckItemok(cid);
    }
    @GetMapping("/updatecheckitem1")
    public int updateCheckItemY(@RequestParam(value = "key1") Integer cid){return cartService.updateCheckItemY(cid);}
    @GetMapping("/updatecheckitem0")
    public int updateCheckItemN(@RequestParam(value = "key1") Integer cid){return cartService.updateCheckItemN(cid);}

    /**
     *
     * 确认订单
     */
    //选择的图书进入图书订单
    @GetMapping("/getcheckbook")
    public List<Cart> selectCheckCart(){ return cartService.selectCheckCart();}

    @GetMapping("/getcheckbooknum")
    public int selectCheckBookNum(){return cartService.selectCheckBookNum();}

    @GetMapping("/gettotalpricea")
    public double selectGetTotalPrice(){return cartService.selectGetTotalPrice();}


    /**
     * 我的订单表操作
     */

    //插入到订单表
    @GetMapping("/addtoorder")
    public int insertOrder(@RequestParam(value = "key0") String order_id,
                           @RequestParam(value = "key1") String imgURL,
                           @RequestParam(value = "key2") String info,
                           @RequestParam(value = "key3") Float price,
                           @RequestParam(value = "key4") String count,
                           @RequestParam(value = "key5") Float total,
                           @RequestParam(value = "key6") String order_time
                           ){
                return cartService.insertOrder(new Order(order_id,imgURL,info,price,count,total,order_time));
    }
    //订单列表
    @GetMapping("/getmyorders")
    public List<Order> selectOrders(){
        return cartService.selectOrders();
    }
    //查询订单表的商品
    @GetMapping("/getmyordersnum")
    public int selectOrderNum(){
        return cartService.selectOrderNum();
    }
    //查询订单表总价
    @GetMapping("/getmyorderstotal")
    public double selectOrderTotal(){
        return cartService.selectOrderTotal();
    }
}
