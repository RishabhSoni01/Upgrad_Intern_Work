package org.example.Day1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeRepository{
    private Employee[] repository;
    private long repository_size;

    private int i;


    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    public EmployeeRepository(int size){
        repository = new Employee[size];
        this.repository_size=size;
        this.i=0;
    }

    public void add(Employee E){
        if(this.i==this.repository_size){
            System.out.println("repository filled");
            return;
        }
        this.repository[i++]=E;
    }

    public void update(long id,String name,long age,String department){
        for(int in=0;in<this.repository_size;in++){
            if(repository[in].id==id){
                repository[in].setter(repository[in].id,name,age,department);
                logger.info("update emplyee ->id: {}",id);
                return;
            }
        }
    }

    public void retrive(long id){
        for(int in=0;in<this.repository_size;in++){
            if(repository[in].id==id){
                repository[in].getter();
                logger.info("retrive employee: {}",id);
                return;
            }
        }
    }

    public void retrive(){
        for(int in=0;in<this.repository_size;in++){
            repository[in].getter();
        }
    }

}