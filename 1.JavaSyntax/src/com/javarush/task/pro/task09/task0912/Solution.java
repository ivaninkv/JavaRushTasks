package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        //напишите тут ваш код
        int delimiterIndex = url.indexOf("://");
        if (delimiterIndex >= 0) {
            return url.substring(0, delimiterIndex);
        }
        return "неизвестный";
    }

    public static String checkDomain(String url) {
        //напишите тут ваш код
        int delimiterIndex = url.lastIndexOf(".");
        if (delimiterIndex >= 0) {
            String domain = url.substring(delimiterIndex + 1);
            if (Arrays.asList(new String[]{"com", "net", "org", "ru"}).contains(domain)) {
                return domain;
            }
        }
        return "неизвестный";
    }
}
