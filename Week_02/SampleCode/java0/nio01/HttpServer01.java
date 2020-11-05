package java0.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpServer01 {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8088);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void service(Socket socket) {
        try {
            Thread.sleep(20);

            InputStream is = socket.getInputStream();
            String requestString = readRequest(is);
            System.out.println("请求内容为：");
            System.out.println(requestString);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            String resp = "hello,nio";
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("Content-Length:"+resp.getBytes().length);
            printWriter.println();
            printWriter.write(resp);
            printWriter.close();
            socket.close();
            System.out.println("响应完成");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String readRequest(InputStream is) throws IOException{
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        final int inputStreamLength = is.available();
        Reader in = new InputStreamReader(is,StandardCharsets.UTF_8);
        int charsRead;
        while((charsRead = in.read(buffer,0,buffer.length))>0) {
            out.append(buffer,0,charsRead);
            //System.out.println(out.length() + " | " + inputStreamLength);
            if ( out.length() >= inputStreamLength ) {
                break;
            }
        }
        return out.toString();
    }
}
