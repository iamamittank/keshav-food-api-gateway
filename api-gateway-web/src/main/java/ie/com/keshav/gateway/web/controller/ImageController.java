package ie.com.keshav.gateway.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Amit Tank
 */
@Slf4j
@RestController
public class ImageController {

    private static final String ENTRY_LOG = "Entered [%s] service";

    @GetMapping(value = "/home/banner/{imageCounter}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getHomeBanners(
            @PathVariable int imageCounter
    ) {
        log.info(String.format(ENTRY_LOG, "Get Banner Images"));
        log.info("Returning image count : " + imageCounter);

        String imagePath = "";
        switch (imageCounter) {
            case 1:
                imagePath = "banner/image1.jpg";
                break;
            case 2:
                imagePath = "banner/image2.jpg";
                break;
            case 3:
                imagePath = "banner/image3.jpg";
                break;
            case 4:
                imagePath = "banner/image4.jpg";
                break;
        }

        return new ClassPathResource(imagePath);
    }

}
