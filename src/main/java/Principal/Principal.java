package Principal;

import Model.Servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        
        List<Socket> clientes = new ArrayList<>();
        
        try {
            ServerSocket servidor = new ServerSocket(4444);
            System.out.println("Aguardando por um cliente.");
            
            int clienteCont = 0;
            
            while (true) {
                Socket socket = servidor.accept();
                
                clientes.add(socket);
                clienteCont++;
                
                Servidor cliente = new Servidor(socket);
                System.out.println("Chegou o cliente " + clienteCont + ".");
                cliente.start();
                
                System.out.println("Clientes: " + clientes);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO.");
        }
    }
}