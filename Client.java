import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(2000);

        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);

        try {
            startRun(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }

        socket.close();
    }

    private static void startRun(Socket client) {
        try {
            InputStream in = System.in;
            BufferedReader input = new BufferedReader(new InputStreamReader(in));

            OutputStream outputStream = client.getOutputStream();
            PrintStream socketPrintStream = new PrintStream(outputStream);

            InputStream inputStream = client.getInputStream();
            BufferedReader socketBufferedReader = new BufferedReader(
                new InputStreamReader(inputStream));

            boolean flag = true;
            do {
                String str = input.readLine();
                socketPrintStream.println(str);

                String echo = socketBufferedReader.readLine();
                if ("bye".equalsIgnoreCase(echo)) {
                    flag = false;
                } else {
                    System.out.println(echo);
                }
            } while (flag);

            socketPrintStream.close();
            socketBufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}