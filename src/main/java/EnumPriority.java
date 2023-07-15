public enum EnumPriority {

    LOW, MEDIUM, HIGH;

    public static void printValues() {
        for (EnumPriority e : EnumPriority.values()) {
            System.out.println(" " + e.ordinal() + "-" + e);
        }
    }
}
