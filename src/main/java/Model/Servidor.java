package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor extends Thread {

    private Socket con;
    private BufferedReader in;
    private PrintWriter out;

    public Servidor(Socket socket) {
        try {
            con = socket;
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            out = new PrintWriter(con.getOutputStream(), true);
        } catch (IOException ioe) {
            System.err.println("Problemas de IO.");
        }
    }

    @Override
    public void run() {
        try {
            out.println("Bem vindo!");
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
            
        } catch (IOException ioe) {
            System.err.println("Problemas de IO.");
        }
    }
}
