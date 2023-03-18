import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class QuestRunner {
  public static void main(String[] args) throws IOException {
    String[][] strMap = buildMap();
    Map<String, Room> mapRooms = setRoom();


  }

  public static String[][] buildMap() {
    String[][] strMap = new String[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        strMap[i][j] = "  ";
      }
    }

    return strMap;
  }

  public static Map<String, Room> setRoom() throws IOException {
    Map<String, Room> mapRooms = new HashMap<>();
    File inpFile = new File("res/rooms.txt");
    BufferedReader fr = new BufferedReader(new FileReader(inpFile));
    for (int i = 0; i < 10; i++) {
      String title = fr.readLine();
      int column = Integer.parseInt(fr.readLine());
      int row = Integer.parseInt(fr.readLine());
      String roomDescription = fr.readLine();
      Room newRoom = new Room(title,column,row,roomDescription);
      mapRooms.put(title,newRoom);
    }
    return mapRooms;
  }
}