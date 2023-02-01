import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.concurrent.TimeUnit;


public class Lesson23 extends BaseTest {
    @Test
    public void cookiesTest() {

        driver.get("https://ya.ru");
//    Добавить Cookie#1 с параметром Otus1 и значением Value1
        driver.manage().addCookie(new Cookie("Otus1", "Value1"));
//    Добавить Cookie#2 с параметром Otus2 и значением Value2
        driver.manage().addCookie(new Cookie("Otus2", "Value2"));
//    Добавить Cookie#3 с параметром Otus3 и значением Value3 (добавлять через переменную, переменная должна быть сохранена)
        Cookie cookie = new Cookie("Otus3", "Value3");
        driver.manage().addCookie(cookie);
//    Добавить Cookie#4 с параметром Otus4 и значением Value4
        driver.manage().addCookie(new Cookie("Otus4", "Value4"));


//    Вывести на экран все Cookies
        System.out.println(driver.manage().getCookies());
//    Вывести на экран Cookie1
        System.out.println(driver.manage().getCookieNamed("Otus1"));
//    Удалить Cookie#2 по имени куки
        driver.manage().deleteCookieNamed("Otus2");
//    Удалить Cookie#3 по переменной Cookie
        driver.manage().deleteCookie(cookie);
//    Удалить все куки, убедиться что их нет
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());
    }

    @Test
    public void timoutTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void windowTest() throws InterruptedException {
//        Группа А: Запустить тест в полном окне («не киоск»), получить его размер
        driver.manage().window().maximize();  //fullscreen(); - киосок
        System.out.println(driver.manage().window().getSize());
//        Группа Б: Запустить тест в расширении 800 на 600, получить его позицию
        driver.manage().window().setSize(new Dimension(800, 600));
        System.out.println(driver.manage().window().getPosition());
//        Группа В: Тоже, что группа Б + передвинуть браузер по квадрату (четырем точкам)
        Point point = driver.manage().window().getPosition();

        point.x += 100;
        Thread.sleep(1000);
        driver.manage().window().setPosition(point);

        point.y += 100;
        Thread.sleep(1000);
        driver.manage().window().setPosition(point);

        point.x += -100;
        Thread.sleep(1000);
        driver.manage().window().setPosition(point);

        point.y -= 100;
        Thread.sleep(1000);
        driver.manage().window().setPosition(point);
    }
}