package constant;

public enum ItemType {

    ELECTRONIC("Điện tử"),
    REFRIGERATION("Điện lạnh"),
    COMPUTER("Máy tính"),
    OFFICE_EQUIPMENT("Thiết bị văn phòng");

    public String value;

    ItemType(String value) {
        this.value = value;
    }

}
