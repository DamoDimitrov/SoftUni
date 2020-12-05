package softuni.exam.instagraphlite.models.dtos.jsons;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.MapKeyType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PictureImportDto {
    @Expose
    private String path;
    @Expose
    private double size;

    public PictureImportDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
