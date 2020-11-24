package contacts;

public enum Fields {
    NAME("Name"),
    ORGANIZATION_NAME("Organization name"),
    SURNAME("Surname"),
    BIRTH_DATE("Birth date"),
    GENDER("Gender"),
    NUMBER("Number"),
    ADDRESS("Address"),
    CREATED("Time created"),
    UPDATED("Time last edit");

    String label;

    Fields(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
