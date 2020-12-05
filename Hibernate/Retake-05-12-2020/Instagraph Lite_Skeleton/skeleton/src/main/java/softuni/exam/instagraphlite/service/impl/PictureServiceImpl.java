package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dtos.jsons.PictureImportDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.GlobalVariables;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.instagraphlite.util.GlobalVariables.*;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Boolean areImported() {

        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(PICTURES_PATH)));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        PictureImportDto[] pictureImportDtos = this.gson.fromJson(this.readFromFileContent(), PictureImportDto[].class);

        for (PictureImportDto pictureImportDto : pictureImportDtos) {
            if (this.validatorUtil.isValid(pictureImportDto)) {
                sb.append(String.format("Successfully imported Picture, with size %.2f", pictureImportDto.getSize()))
                        .append(System.lineSeparator());

                this.pictureRepository.saveAndFlush(this.modelMapper.map(pictureImportDto, Picture.class));
            } else {
                sb.append("Invalid Picture")
                        .append(System.lineSeparator());
            }
            System.out.println();
        }
        return sb.toString();
    }

    @Override
    public String exportPictures() {
        return null;
    }
}
