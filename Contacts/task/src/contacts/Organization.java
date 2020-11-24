package contacts;

public class Organization extends Contact {

    private String name;
    private String address;

    public Organization(String name, String address, String number) {
        super(number, false);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdated();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setUpdated();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("%s: %s\n", Fields.ORGANIZATION_NAME.getLabel(), getName()))
                .append(String.format("%s: %s\n", Fields.ADDRESS.getLabel(), getAddress()))
                .append(String.format("%s: %s\n", Fields.NUMBER.getLabel(), getNumber()))
                .append(String.format("%s: %s\n", Fields.CREATED.getLabel(), getCreated()))
                .append(String.format("%s: %s\n", Fields.UPDATED.getLabel(), getUpdated()));

        return stringBuilder.toString();
    }

    @Override
    public String[] getFields() {
        return new String[]{
                Fields.ORGANIZATION_NAME.getLabel().toLowerCase(),
                Fields.ADDRESS.getLabel().toLowerCase(),
                Fields.NUMBER.getLabel().toLowerCase()
        };
    }

    @Override
    public void changeField(Fields field, String newValue) {
        switch (field.getLabel().toLowerCase()) {
            case "name": {
                setName(newValue);
                break;
            }
            case "address": {
                setAddress(newValue);
                break;
            }
            case "number": {
                setNumber(newValue);
                break;
            }
            default:
                System.out.printf("Wrong field type. Select from list: %s", getFields());
                break;
        }
    }

    @Override
    public String getFullName() {
        return this.name;
    }
}
