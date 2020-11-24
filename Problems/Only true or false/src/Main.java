class Primitive {
    public static boolean toPrimitive(Boolean b) {
        if (b == null) {
            return false;
        } else {
            boolean result = b;
            return result;
        }
    }
}