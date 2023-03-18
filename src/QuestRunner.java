import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class QuestRunner {
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Введи своё имя: ");
    Hero hero = new Hero(/*br.readLine()*/ "Вадим");
    Map<String, Room> mapRooms = setRoom();
    String[][] strMap = buildMap(mapRooms, hero);
    System.out.println();
    System.out.println(BLUE + "\n═══════════ TextQuest: Typical Home Explore ═══════════" + RESET);
    System.out.println("\nДобро пожаловать в наш квест, " + hero.getName() + "!");
    showMenu(mapRooms, hero, strMap);

//    for (int i = 0; i < 4; i++) {
//      for (int j = 0; j < 4; j++) {
//        System.out.print(strMap[i][j]);
//      }
//      System.out.println();
//    }
  }

  public static void showMenu(Map<String, Room> mapRooms, Hero hero, String[][] strMap) throws IOException {
    Room currentRoom = mapRooms.get(hero.getCurrentRoom());
    System.out.println();
    System.out.println(GREEN + String.format(currentRoom.getRoomDescription()) + RESET);
    while (true) {
      System.out.println("""
                  
          Доступные действия:
          1. Пойти вверх
          2. Пойти вниз
          3. Пойти влево
          4. Пойти вправо
          5. Посмотреть карту
          6. Выйти из игры""");
      System.out.print("Введи номер действия: ");
      int answear = readIntLimited(1, 6);
      switch (answear) {
        case 1 -> makeMove(0, -1, hero, strMap, mapRooms);
        case 2 -> makeMove(0, 1, hero, strMap, mapRooms);
        case 3 -> makeMove(-1, 0, hero, strMap, mapRooms);
        case 4 -> makeMove(1, 0, hero, strMap, mapRooms);
        case 5 -> showMap(strMap);
        case 6 -> quitGame(hero);
      }
      strMap = buildMap(mapRooms, hero);
    }
  }

  public static void quitGame(Hero hero) {
    System.out.printf(BLUE + """
        Поздравляю %s, ты успешно завершил наш квест!
        Мы надеемся, что ты получил массу удовольствия и узнал что-то новое.
        Будь готов к новым приключениям, и не забывай вернуться к нам снова!""", hero.getName());
    System.exit(0);
  }

  public static void makeMove(int diffColumn, int diffRow, Hero hero, String[][] strMap, Map<String, Room> mapRooms) {
    int row = hero.getRow();
    int column = hero.getColumn();
    row += diffRow;
    column += diffColumn;
    if (row < 0 || row > 3 || column < 0 || column > 3) {
      hero.hitHead();
      return;
    }
    if (strMap[row][column].equals("  ")) {
      hero.hitHead();
      return;
    }
    hero.setRow(row);
    hero.setColumn(column);
    hero.setCurrentRoom(strMap[row][column]);
    buildMap(mapRooms, hero);
    Room currentRoom = mapRooms.get(hero.getCurrentRoom());
    System.out.println();
    System.out.println(GREEN + String.format(currentRoom.getRoomDescription()) + RESET);

  }

  public static int readIntLimited(int min, int max) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = 0;
    do {
      try {
        num = Integer.parseInt(br.readLine());
      } catch (NumberFormatException e) {
        System.out.println("Вводи только цифры!");
      }
      if (!(num >= min && num <= max)) {
        System.out.printf("Введи число от %d до %d: ", min, max);
      }
    } while (!(num >= min && num <= max));
    return num;
  }

  public static String[][] buildMap(Map<String, Room> mapRooms, Hero hero) {
    String[][] strMap = new String[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        strMap[i][j] = "  ";
      }
    }
    for (Map.Entry<String, Room> setRoom : mapRooms.entrySet()) {
      Room currentRoom = setRoom.getValue();
      int row = currentRoom.getRow();
      int column = currentRoom.getColumn();
      String title = currentRoom.getTitle();
      strMap[row][column] = title;
    }
    int row = hero.getRow();
    int column = hero.getColumn();
    strMap[row][column] = "░░";
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

  public static void showMap(String[][] strMap) {
    System.out.printf("               ┌────┬────┬────┬────┐%n");
    System.out.printf("               │    │    │ %s │ %s │%n", strMap[0][2], strMap[0][3]);
    System.out.printf("               ├────┼────┼────┼────┤%n");
    System.out.printf("               │    │ %s │ %s │    │%n", strMap[1][1], strMap[1][2]);
    System.out.printf("               ├────┼────┼────┼────┤%n");
    System.out.printf("               │ %s │ %s │ %s │ %s │%n", strMap[2][0], strMap[2][1],
        strMap[2][2], strMap[2][3]);
    System.out.printf("               ├────┼────┼────┼────┤%n");
    System.out.printf("               │ %s │    │ %s │    │%n", strMap[3][0], strMap[3][2]);
    System.out.printf("               └────┴────┴────┴────┘%n");
    System.out.println("                                Kt - Кухня      Bn - Балкон");
    System.out.println("               GR - Игровая     DR - Столовая");
    System.out.println("SR - Спальня   LV - Гостинная   HL - Холл       BR - Ванная");
    System.out.println("GD - Гардероб                   ST - Кладовая");
    System.out.println("               ░░ <- вы находитесь здесь");

  }
}