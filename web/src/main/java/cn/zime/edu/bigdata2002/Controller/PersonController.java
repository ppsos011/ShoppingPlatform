package cn.zime.edu.bigdata2002.Controller;

import cn.zime.edu.bigdata2002.Model.Person;
import cn.zime.edu.bigdata2002.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    //获取收货地址
    @GetMapping("/getAllPerson")
    public List<Person> selectPerson(){
        System.out.println("成功");
        return personService.selectPerson();

    }
    //插入新地址
    @GetMapping("/insertaddress")
    public int insertPerson(@RequestParam(value = "key1") int id,
                             @RequestParam(value = "key2") String name,
                             @RequestParam(value = "key3") String role,
                             @RequestParam(value = "key4") String number,
                             @RequestParam(value = "key5") String favor,
                             @RequestParam(value = "key6") String favorAuthor,
                             @RequestParam(value = "key7") String genda,
                             @RequestParam(value = "key8") String input,
                             @RequestParam(value = "key9") String autograph,
                             @RequestParam(value = "key10") String fullAddress) {
//        if(id.isEmpty()) return 0;
//        else
            return personService.insertPerson(new Person(id,name,role,number,favor,favorAuthor,genda,input,autograph,fullAddress));
    }
    //删除地址
    @GetMapping("/deleteAddress")
    public int deletePerson(@RequestParam(value = "key1")String name,
                             @RequestParam(value = "key2") String number,
                             @RequestParam(value = "key3") String genda,
                             @RequestParam(value = "key4") String fullAddress){
        System.out.println(name+"-"+number+"-"+genda+"-"+fullAddress);
        return personService.deletePerson(name,number,genda,fullAddress);
    }
    //更新地址
    @GetMapping("/updateAddress")
    public int updatePerson(@RequestParam(value = "key1") int id,
                            @RequestParam(value = "key2") String name,
                            @RequestParam(value = "key3") String role,
                            @RequestParam(value = "key4") String number,
                            @RequestParam(value = "key5") String favor,
                            @RequestParam(value = "key6") String favorAuthor,
                            @RequestParam(value = "key7") String genda,
                            @RequestParam(value = "key8") String input,
                            @RequestParam(value = "key9") String autograph,
                            @RequestParam(value = "key10") String fullAddress){
        return personService.updatePerson(new Person(id,name,role,number,favor,favorAuthor,genda,input,autograph,fullAddress));
    }
//    @GetMapping("/deleteAddress")
//    public int deleteAddress(@RequestParam(value = "key1")String name){
//        System.out.println("---------NAME:"+name);
//        return addressService.deleteAddress(name);
//    }
}
