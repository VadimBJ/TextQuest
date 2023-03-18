public class Room {
  private final String title;
  private String roomDescription;
  private int column;
  private int row;

  public Room(String title, int column, int row) {
    this.title = title;
    this.column = column;
    this.row = row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getRow() {
    return row;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public int getColumn() {
    return column;
  }

  public void setRoomDescription(String roomDescription) {
    this.roomDescription = roomDescription;
  }
}
