package cn.zime.edu.bigdata2002.Service;

import cn.zime.edu.bigdata2002.Mapper.PersonMapper;
import cn.zime.edu.bigdata2002.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;
    public List<Person> selectPerson(){
        return personMapper.selectPerson();
    }

    public int insertPerson(Person person){
        return personMapper.insertPerson(person);
    }

    public int deletePerson(String name,String number,String genda,String fullAddress){
        return personMapper.deletePerson(name,number,genda,fullAddress);
    }

    public int updatePerson(Person person){
        return personMapper.updatePerson(person);
    }
//    public int deleteAddress(String name){
//        return addressMapper.deleteAddress(name);
//   }
}