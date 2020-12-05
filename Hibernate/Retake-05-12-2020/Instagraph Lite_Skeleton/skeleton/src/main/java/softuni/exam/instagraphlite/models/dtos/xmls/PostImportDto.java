package softuni.exam.instagraphlite.models.dtos.xmls;

import softuni.exam.instagraphlite.models.User;

public class PostImportDto {
    private String caption;
    private User user;

    public PostImportDto() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
