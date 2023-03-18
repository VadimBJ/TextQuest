public class Hero {
  private final String name;
  private int steps;
  private int hitCount;
  private final int MAX_HIT_COUNT=4;
  private String currentRoom;
  private int column;
  private int row;

  public void setSteps(int steps) {
    this.steps = steps;
  }

  public Hero(String name) {
    this.name = name;
    this.steps = 0;
    this.hitCount = 0;
    this.currentRoom = "HL";
    this.column = 2;
    this.row = 2;
  }

  public void hitHead(){
    ++hitCount;
    System.out.println(QuestRunner.RED);
    if (hitCount == 1) {
      System.out.println("Ты попытался пройти сквозь стену и очень сильно ударился головой..." +
          "\nБудь внимательнее!");
    } else if (hitCount < MAX_HIT_COUNT) {
      System.out.printf("Ты %dй раз ударился головой о стену! Это до добра не доведет...",hitCount);
    } else {
      System.out.println("Ты в очередной раз налетел на стену и получил травмы не совместимые с " +
          "жизнью... Нам очень жаль" +
          " ");
      System.exit(0);
    }

    System.out.println(QuestRunner.RESET);
  }

  public String getName() {
    return name;
  }

  public int getSteps() {
    return steps;
  }

  public String getCurrentRoom() {
    return currentRoom;
  }

  public int getColumn() {
    return column;
  }

  public int getRow() {
    return row;
  }

  public void setCurrentRoom(String currentRoom) {
    this.currentRoom = currentRoom;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public void setRow(int row) {
    this.row = row;
  }
}
