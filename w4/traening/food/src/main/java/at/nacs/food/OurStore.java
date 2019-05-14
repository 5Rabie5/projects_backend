package at.nacs.food;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class OurStore {
    Set<String> fruits =new HashSet<>( );

    public List<String> getFruits(){
        return new ArrayList<>(fruits);
    }

    public void add(String frut){
        fruits.add(frut);
    }
}
