package com.project1.project1.util;

import com.project1.project1.utils.SHA256Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SHA256UtilTest {

    @Test
    public void testSHA256() {
        String testString = "testString";
        String s = SHA256Util.encrypt(testString);
        System.out.println(s);
    }
}
