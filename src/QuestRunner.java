import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class QuestRunner {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Введите Ваше имя: ");
    Hero hero = new Hero(br.readLine());
    Map<String, Room> mapRooms = setRoom();
    String[][] strMap = buildMap(mapRooms,hero);
    showMap(strMap);
    hero.setColumn(3);
    hero.setRow(0);
    strMap = buildMap(mapRooms,hero);
    showMap(strMap);

//    for (int i = 0; i < 4; i++) {
//      for (int j = 0; j < 4; j++) {
//        System.out.print(strMap[i][j]);
//      }
//      System.out.println();
//    }
  }

  public static String[][] buildMap(Map<String, Room> mapRooms,Hero hero ) {
    String[][] strMap = new String[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        strMap[i][j] = "  ";
      }
    }
    for (Map.Entry<String,Room> setRoom : mapRooms.entrySet()){
      Room currentRoom = setRoom.getValue();
      int row = currentRoom.getRow();
      int column = currentRoom.getColumn();
      String title = currentRoom.getTitle();
      strMap[row][column]=title;
    }
    int row = hero.getRow();
    int column = hero.getColumn();
    strMap[row][column]="░░";
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
      Room newRoom = new Room(title, column, row, roomDescription);
      mapRooms.put(title, newRoom);
    }
    return mapRooms;
  }

  public static void showMap(String[][] strMap){
    System.out.printf("               ┌────┬────┬────┬────┐%n");
    System.out.printf("               │    │    │ %s │ %s │%n",strMap[0][2],strMap[0][3]);
    System.out.printf("               ├────┼────┼────┼────┤%n");
    System.out.printf("               │    │ %s │ %s │    │%n",strMap[1][1],strMap[1][2]);
    System.out.printf("               ├────┼────┼────┼────┤%n");
    System.out.printf("               │ %s │ %s │ %s │ %s │%n",strMap[2][0],strMap[2][1],
        strMap[2][2],strMap[2][3]);
    System.out.printf("               ├────┼────┼────┼────┤%n");
    System.out.printf("               │ %s │    │ %s │    │%n",strMap[3][0],strMap[3][2]);
    System.out.printf("               └────┴────┴────┴────┘%n");
    System.out.println("                                Kt - Кухня      Bn - Балкон");
    System.out.println("               GR - Игровая     DR - Столовая");
    System.out.println("SR - Спальня   LV - Гостинная   HL - Холл       BR - Ванная");
    System.out.println("GD - Гардероб                   ST - Кладовая");
    System.out.println("               ░░ <- вы находитесь здесь");

  }
}