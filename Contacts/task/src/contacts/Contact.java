package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    private String number;
    private Boolean isPerson;
    private LocalDateTime created;
    private LocalDateTime updated;
    protected static final String NO_DATA = "[no data]";

    public Contact(String number, Boolean isPerson) {
        setNumber(number);
        this.isPerson = isPerson;
        this.created = LocalDateTime.now().withSecond(0);
    }

    public String getNumber() {
        if (number.isEmpty()) {
            return "[no number]";
        }
        return number;
    }

    public void setNumber(String number) {
        Pattern pattern = Pattern.compile("^\\+?(\\w+([\\s,-]\\w{2,}){0,3}$|\\w+[\\s,-]\\(\\w{2,}\\)([\\s,-]\\w{2,}){0,3}$|\\(\\w+\\)([\\s,-]\\w{2,}){0,3}$)");
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            this.number = number;
        } else {
            System.out.println("Wrong number format!");
            this.number = "";
        }

        setUpdated();
    }

    public Boolean isPerson() {
        return isPerson;
    }

    public void setUpdated() {
        this.updated = LocalDateTime.now().withSecond(0);
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public abstract String[] getFields();

    public abstract void changeField(Fields field, String newValue);

    public abstract String getFullName();
}
