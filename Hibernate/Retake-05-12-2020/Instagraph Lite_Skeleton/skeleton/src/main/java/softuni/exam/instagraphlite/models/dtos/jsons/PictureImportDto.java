package softuni.exam.instagraphlite.models.dtos.jsons;

import com.google.gson.annotations.Expose;
import javax.validation.constraints.NotNull;

public class PictureImportDto {
    @Expose
    private String path;
    @Expose
    private double size;

    public PictureImportDto() {
    }

    @NotNull
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
