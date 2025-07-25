package Server;
import java.util.ArrayList;
import java.net.Socket;
import java.io.*;


public class ClientHandler implements Runnable{
    

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientHandler(Socket socket)
    {
        try {
            
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientUsername = bufferedReader.readLine();
            clientHandlers.add(this);
            broadCastMessage("SERVER: " + clientUsername + " has joined the chat!");
        } catch (IOException e)
        {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }



    @Override
    public void run()
    {
        String messageFromClient;

        while(socket.isConnected())
        {
            try {
                messageFromClient = bufferedReader.readLine();

                if(messageFromClient == null)
                {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                    break;
                }

                broadCastMessage(messageFromClient);

            } catch (IOException e)
            {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void removeClientHandler() 
    {
        clientHandlers.remove(this);
        broadCastMessage("SERVER: " + clientUsername + " has left the chat...");

    }



    public void broadCastMessage(String messageToSend)
    {
        for (ClientHandler clientHandler : clientHandlers) 
        {
            try {
                if(!clientHandler.clientUsername.equals(clientUsername))
                {
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            } catch (IOException e) 
            {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
    {
        removeClientHandler();
        
        try {
            if(bufferedReader != null)
            {
                bufferedReader.close();
            }
            if(bufferedWriter != null)
            {
                bufferedWriter.close();
            }
            if(socket != null)
            {
                socket.close();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}




