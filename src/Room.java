public class Room {
  private final String title;
  private String roomDescription;
  private final int column;
  private final int row;

  public Room(String title, int column, int row, String roomDescription) {
    this.title = title;
    this.column = column;
    this.row = row;
    this.roomDescription = roomDescription;
  }

  public void setRoomDescription(String roomDescription) {
    this.roomDescription = roomDescription;
  }

  public String getRoomDescription() {
    return roomDescription;
  }

  public String getTitle() {
    return title;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

}
