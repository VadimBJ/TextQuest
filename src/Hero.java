public class Hero {
  private String name;
  private int steps=0;
  private int hitCount=0;
  private String currentRoom;
  private int column;
  private int row;

  public Hero(String name) {
    this.name = name;
    this.steps = 0;
    this.hitCount = 0;
    this.currentRoom = "HL";
    this.column = 2;
    this.row = 2;
  }

  public String getName() {
    return name;
  }

  public int getSteps() {
    return steps;
  }

  public int getHitCount() {
    return hitCount;
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

  public void setHitCount(int hitCount) {
    this.hitCount = hitCount;
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
