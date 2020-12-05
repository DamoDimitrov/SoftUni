package softuni.exam.instagraphlite.models.dtos.xmls;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {

    @XmlElement
    private String caption;
    @XmlElement
    private UserImportXMLDto user;
    @XmlElement
    private PictureImportXMLDto picture;

    public PostImportDto() {
    }

    @Length(min = 21)
    @NotNull
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public UserImportXMLDto getUser() {
        return user;
    }

    public void setUser(UserImportXMLDto user) {
        this.user = user;
    }

    @NotNull
    public PictureImportXMLDto getPicture() {
        return picture;
    }

    public void setPicture(PictureImportXMLDto picture) {
        this.picture = picture;
    }
}
