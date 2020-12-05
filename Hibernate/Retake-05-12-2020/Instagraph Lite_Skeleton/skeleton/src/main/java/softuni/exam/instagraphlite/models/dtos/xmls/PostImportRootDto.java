package softuni.exam.instagraphlite.models.dtos.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportRootDto {

    @XmlElement(name = "post")
    private List<PostImportDto> posts;

    public PostImportRootDto() {
    }

    public List<PostImportDto> getPostImportDtos() {
        return posts;
    }

    public void setPostImportDtos(List<PostImportDto> postImportDtos) {
        this.posts = postImportDtos;
    }
}
