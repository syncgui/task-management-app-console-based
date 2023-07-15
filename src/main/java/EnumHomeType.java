public enum EnumHomeType {

    CLEAN, ORGANIZE, BUILD, COOK;

    public static void printValues() {
        for (EnumHomeType e : EnumHomeType.values()) {
            System.out.println(" " + e.ordinal() + "-" + e);
        }
    }
}
