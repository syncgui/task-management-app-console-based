public enum EnumWorkType {

    FIX, IMPLEMENTATION, DOCUMENTATION, MEETING;

    public static void printValues() {
        for (EnumWorkType e : EnumWorkType.values()) {
            System.out.println(" " + e.ordinal() + "-" + e);
        }
    }
}
