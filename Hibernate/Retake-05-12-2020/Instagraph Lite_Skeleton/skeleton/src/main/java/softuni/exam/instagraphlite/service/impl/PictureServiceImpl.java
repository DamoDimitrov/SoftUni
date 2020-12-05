package softuni.exam.instagraphlite.service.impl;

import softuni.exam.instagraphlite.service.PictureService;

import java.io.IOException;

public class PictureServiceImpl implements PictureService {
    @Override
    public Boolean areImported() {
        return false;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return null;
    }

    @Override
    public String importPictures() throws IOException {
        return null;
    }

    @Override
    public String exportPictures() {
        return null;
    }
}
