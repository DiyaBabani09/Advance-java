package org.example.Connections;


//import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class Hibernatecon {
  private static SessionFactory sf;
static{
    try{
        if(sf==null){
            Configuration cfg=new Configuration();
            cfg.configure("hibernate.config.xml");
           sf= cfg.buildSessionFactory();

        }
    }catch(Exception e){
        System.out.println( e);
    }
}
public static SessionFactory getSession(){
    return sf;
}

}
