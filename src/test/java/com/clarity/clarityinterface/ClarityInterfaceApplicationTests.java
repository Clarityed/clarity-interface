package com.clarity.clarityinterface;

import com.clarity.apiclientsdk.Model.User;
import com.clarity.apiclientsdk.client.ClarityClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ClarityInterfaceApplicationTests {

    @Resource
    private ClarityClient clarityClient;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("keQing");
        String result = clarityClient.getUsernameByPost(user);
        System.out.println(result);
    }

}
