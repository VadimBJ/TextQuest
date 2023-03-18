public class Room {
  private final String title;
  private final String roomDescription;
  private int column;
  private int row;

  public Room(String title, int column, int row, String roomDescription) {
    this.title = title;
    this.column = column;
    this.row = row;
    this.roomDescription = roomDescription;
  }

  public String getRoomDescription() {
    return roomDescription;
  }

  public String getTitle() {
    return title;
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

}
