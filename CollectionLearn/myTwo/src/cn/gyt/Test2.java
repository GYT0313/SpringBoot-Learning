package cn.gyt;

import com.gyt3.MyService;

import java.util.ServiceLoader;

public class Test2 {
    public static void main(String[] args) {
        ServiceLoader<MyService> myServices = ServiceLoader.load(MyService.class);
        for (MyService service : myServices) {
            service.service();
        }

    }
}
