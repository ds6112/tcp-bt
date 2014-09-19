import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import GivenTools.*;

public class RUBTClient {

	public static void main(String[] args) {
		
		//Check if the arguments are valid
		if ( args.length < 2 || args.length > 2){
			System.out.println("Usage: RUBTClient torrent_file file_save_name\n");
			return;
		}
		else {
			
			// Check if first argument is a valid host
			Path torrentFile = Paths.get(args[0]);
			byte[] tfArray;
			try {
				//Read torrent file into a byte array
				tfArray = Files.readAllBytes(torrentFile);
				//ToolKit.printString(tfArray, false, 1);
				try {
					//ByteBuffer torrentBuffer = Bencoder2.getInfoBytes(tfArray);
					//ToolKit.printString(torrentBuffer, false, 10);
					//Decode the torrent byte array
					//Object torrentDecode = Bencoder2.decode(tfArray);
			        TorrentInfo tf = new TorrentInfo(tfArray);
			        System.out.println("Announce: " + tf.announce_url);
			        System.out.println("Piece Length: " + tf.piece_length);
			        System.out.println("File name: " + tf.file_name);
			        System.out.println("File length: " + tf.file_length);
					//ToolKit.print(torrentDecode, 0);
				} catch (BencodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Check if second argument is a valid port number
			Path saveFile = Paths.get(args[0]);
			
			
		//System.out.print("Torrent_File: " + args[0] + "\n" + "File_Save_Name: " + args[1] + "\n");
		
		}
		//End argument check
	}
}

