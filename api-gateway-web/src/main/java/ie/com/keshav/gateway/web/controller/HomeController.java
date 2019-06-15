package ie.com.keshav.gateway.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Amit Tank
 */
@Slf4j
@RestController
public class HomeController {

    private static final String ENTRY_LOG = "Entered [%s] service";

    @RequestMapping("home/banner")
    public List<String> getBannerCount() throws IOException {
        log.info(String.format(ENTRY_LOG, "Get Banner Images Count"));

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("banner/*");
        return Arrays.stream(resources)
                .map(Resource::getFilename)
                .collect(Collectors.toList());
    }

}
