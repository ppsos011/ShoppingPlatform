package cn.zime.edu.bigdata2002.Service;

import cn.zime.edu.bigdata2002.Mapper.AddressMapper;
import cn.zime.edu.bigdata2002.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressMapper addressMapper;
    public List<Address> selectAddress(){
        return addressMapper.selectAddress();
    }

    public int insertAddress(Address address){
        return addressMapper.insertAddress(address);
    }

    public int deleteAddress(String name,String number,String genda,String fullAddress){
        return addressMapper.deleteAddress(name,number,genda,fullAddress);
    }

    public int updateAddress(Address address){
        return addressMapper.updateAddress(address);
    }
//    public int deleteAddress(String name){
//        return addressMapper.deleteAddress(name);
//   }
}