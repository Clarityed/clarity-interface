package com.clarity.clarityinterface;

import com.clarity.clarityinterface.Model.User;
import com.clarity.clarityinterface.client.ClarityClient;

/**
 * 客户端
 *
 * @author: clarity
 * @date: 2022年11月10日 15:28
 */
public class Main {
    public static void main(String[] args) {
        ClarityClient client = new ClarityClient("clarity", "abcdefgh");
        String result1 = client.getNameByGet("clarity");
        String result2 = client.getNameByPost("clarity");
        User user = new User();
        user.setName("clarity");
        String result3 = client.getUsernameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
