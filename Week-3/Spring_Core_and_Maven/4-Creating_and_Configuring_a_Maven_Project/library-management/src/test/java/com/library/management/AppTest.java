package com.library.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.serices.BookService;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static ApplicationContext context;

    @BeforeAll
    public static void setup(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDependencyInjection() {
        // Arrange
        BookService service = context.getBean(BookService.class);
        //Act
        String result = service.addBook();
        //Assert
        assertEquals("Book Inserted", result);
    }
}
