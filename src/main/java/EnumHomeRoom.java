public enum EnumHomeRoom {

    BEDROOM, BATHROOM, KITCHEN, OFFICE;

    public static void printValues() {
        for (EnumHomeRoom e : EnumHomeRoom.values()) {
            System.out.println(" " + e.ordinal() + "-" + e);
        }
    }
}
