package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        //напишите тут ваш код
        URLConnection urlConn = url.openConnection();
        urlConn.setDoOutput(true);
        OutputStream outputStream = urlConn.getOutputStream();
        outputStream.write("Hello from javarush!".getBytes());
        InputStream inputStream = urlConn.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));
    }
}
