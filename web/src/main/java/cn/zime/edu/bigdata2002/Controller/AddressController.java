package cn.zime.edu.bigdata2002.Controller;

import cn.zime.edu.bigdata2002.Model.Address;
import cn.zime.edu.bigdata2002.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    //获取收货地址
    @GetMapping("/getAllAddress")
    public List<Address> selectAddress(){
        System.out.println("成功");
        return addressService.selectAddress();

    }
    //插入新地址
    @GetMapping("/insertaddress")
    public int insertAddress(@RequestParam(value = "key1") int id,
                             @RequestParam(value = "key2") String name,
                             @RequestParam(value = "key3") String number,
                             @RequestParam(value = "key4") String favor,
                             @RequestParam(value = "key5") String favorAuthor,
                             @RequestParam(value = "key6") String genda,
                             @RequestParam(value = "key7") String input,
                             @RequestParam(value = "key8") String autograph,
                             @RequestParam(value = "key9") String fullAddress) {
//        if(id.isEmpty()) return 0;
//        else
            return addressService.insertAddress(new Address(id,name,number,favor,favorAuthor,genda,input,autograph,fullAddress));
    }
    //删除地址
    @GetMapping("/deleteAddress")
    public int deleteAddress(@RequestParam(value = "key1")String name,
                             @RequestParam(value = "key2") String number,
                             @RequestParam(value = "key3") String genda,
                             @RequestParam(value = "key4") String fullAddress){
        System.out.println(name+"-"+number+"-"+genda+"-"+fullAddress);
        return addressService.deleteAddress(name,number,genda,fullAddress);
    }
    //更新地址
    @GetMapping("/updateAddress")
    public int updateAddress(@RequestParam(value = "key1") int id,
                             @RequestParam(value = "key2") String name,
                             @RequestParam(value = "key3") String number,
                             @RequestParam(value = "key4") String favor,
                             @RequestParam(value = "key5") String favorAuthor,
                             @RequestParam(value = "key6") String genda,
                             @RequestParam(value = "key7") String input,
                             @RequestParam(value = "key8") String autograph,
                             @RequestParam(value = "key9") String fullAddress){
        return addressService.updateAddress(new Address(id,name,number,favor,favorAuthor,genda,input,autograph,fullAddress));
    }
//    @GetMapping("/deleteAddress")
//    public int deleteAddress(@RequestParam(value = "key1")String name){
//        System.out.println("---------NAME:"+name);
//        return addressService.deleteAddress(name);
//    }
}
