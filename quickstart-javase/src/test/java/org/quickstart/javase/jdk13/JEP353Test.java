package org.quickstart.javase.jdk13;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 09:51
 */
public class JEP353Test {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      boolean running = true;

      serverSocket.setSoTimeout(5000); // timeout in 5 seconds
      Socket clientSocket = serverSocket.accept();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      while (running) {
        out.println("output");
        if (out.checkError()) {
          System.out.println("ERROR writing data to socket !!!");
        }
        System.out.println(clientSocket.isConnected());
        System.out.println(clientSocket.getInputStream().read());
        // thread sleep ...
        // break condition , close sockets and the like ...
      }

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

}
