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

}