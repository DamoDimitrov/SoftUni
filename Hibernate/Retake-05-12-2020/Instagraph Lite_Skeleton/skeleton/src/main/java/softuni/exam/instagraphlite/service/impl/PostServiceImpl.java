package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Boolean аreImported() {
        return this.postRepository.count() > 0;
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
