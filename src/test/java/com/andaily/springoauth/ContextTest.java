package com.andaily.springoauth;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * @author Shengzhao Li
 * @since 2.0.0
 */

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public abstract class ContextTest {


    @BeforeTransaction
    public void before() throws Exception {

    }


}