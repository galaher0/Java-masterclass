import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * 1. https://ideone.com/Vzj8eY - дописать в среде разработки и
 * сделать скриншот кода
 *
 * 2. Написать код, который печатает дату в формате 20190109_170952,
 * запустить его и сделать скриншот кода и результата его вывода в консоль
 *
 * 3. Написать код, который получает скриншот экрана, "кладёт" его в
 * объект класса BufferedImage, а затем печатает размеры экрана в консоль.
 * Запустить код, сделать скриншот кода и вывода в консоль
 *
 * Отправить скриншоты как файлы одним сообщением в телеграм-чат с тэгом #явделе
 */

public class Main
{
    public static void main(String[] args) throws java.lang.Exception
    {

        //задание 1
        System.out.println("Задание 1:\nКофе-машина");

        int moneyAmount = 120;

        String drinks[] = {"каппучино", "эспрессо", "молоко", "вода"};
        int prices[] = {150, 80, 40, 20};

        boolean canBuyAnything = false;

        for (int i = 0; i < drinks.length; i++)
        {
            System.out.println(drinks[i] + " - " + prices[i]);
            if (prices[i] <= moneyAmount)
            {
                canBuyAnything = true;
            }
        }

        if(!canBuyAnything)
        {
            System.out.println("Недостаточно средств");
        }

        //задание 2
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String currentDate = dateFormat.format(new Date());
        System.out.println("\nЗадание 2:\nТекущее время: " + currentDate);

        //задание 3
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        System.out.println("\nЗадание 3:\nРазмер скрина: " + image.getWidth() + "x" + image.getHeight());
    }
}
