package softuni.exam.instagraphlite.service.impl;

import softuni.exam.instagraphlite.service.PostService;

import java.io.IOException;

public class PostServiceImpl implements PostService {
    @Override
    public Boolean аreImported() {
        return false;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return null;
    }

    @Override
    public String importPosts() throws IOException {
        return null;
    }
}
