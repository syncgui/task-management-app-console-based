public enum EnumWorkReporter {

    CLIENT, MANAGER, CTO, DIRECTOR;

    public static void printValues() {
        for (EnumWorkReporter e : EnumWorkReporter.values()) {
            System.out.println(" " + e.ordinal() + "-" + e);
        }
    }
}
