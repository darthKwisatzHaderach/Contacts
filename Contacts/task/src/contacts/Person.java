package contacts;

public class Person extends Contact {

    private String name;
    private String surname;
    private String fullName;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String number, String birthDate, String gender) {
        super(number, true);
        this.name = name;
        this.surname = surname;
        setBirthDate(birthDate);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdated();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        setUpdated();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.isEmpty() || birthDate == null) {
            this.birthDate = NO_DATA;
        } else {
            this.birthDate = birthDate;
        }

        setUpdated();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.isEmpty() || gender == null) {
            this.gender = NO_DATA;
        } else {
            this.gender = gender;
        }

        setUpdated();
    }

    @Override
    public String getFullName() {
        return String.format("%s %s", this.name, this.surname);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("%s: %s\n", Fields.NAME.getLabel(), getName()))
                .append(String.format("%s: %s\n", Fields.SURNAME.getLabel(), getSurname()))
                .append(String.format("%s: %s\n", Fields.BIRTH_DATE.getLabel(), getBirthDate()))
                .append(String.format("%s: %s\n", Fields.GENDER.getLabel(), getGender()))
                .append(String.format("%s: %s\n", Fields.NUMBER.getLabel(), getNumber()))
                .append(String.format("%s: %s\n", Fields.CREATED.getLabel(), getCreated()))
                .append(String.format("%s: %s\n", Fields.UPDATED.getLabel(), getUpdated()));

        return stringBuilder.toString();
    }

    @Override
    public String[] getFields() {
        return new String[]{
                Fields.NAME.getLabel().toLowerCase(),
                Fields.SURNAME.getLabel().toLowerCase(),
                Fields.BIRTH_DATE.getLabel().toLowerCase(),
                Fields.GENDER.getLabel().toLowerCase(),
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
            case "surname": {
                setSurname(newValue);
                break;
            }
            case "number": {
                setNumber(newValue);
                break;
            }
            case "birth": {
                setBirthDate(newValue);
                break;
            }
            case "gender": {
                setGender(newValue);
                break;
            }
            default:
                System.out.printf("Wrong field type. Select from list: %s", getFields());
                break;
        }
    }
}
