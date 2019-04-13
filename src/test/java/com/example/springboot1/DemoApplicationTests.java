package com.example.springboot1;

import antlr.build.Tool;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: DemoApplicationTests
 * @Package com.example.springboot1
 * @Description
 * @date 2018/8/24 11:08
 */

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "src/docs/asciidoc/generated")
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void createSpringFoxSwaggerJson() throws Exception {
//        //String designFirstSwaggerLocation = Swagger2MarkupTest.class.getResource("/swagger.yaml").getPath();
//        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir"); // mvn test
////        String outputDir = "D:\\workspace\\springfox-swagger2-demo\\target\\swagger"; // run as
//
//        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        MockHttpServletResponse response = mvcResult.getResponse();
//        String swaggerJson = response.getContentAsString();
//        Files.createDirectories(Paths.get("src/docs/asciidoc/generated"));
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/docs/asciidoc/generated", "swagger.json"), StandardCharsets.UTF_8)){
//            writer.write(swaggerJson);
//        }
//    }



    @Test
    public void generateAsciiDocs() throws Exception {
//         读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
//         这个outputDir必须和插件里面<generated></generated>标签配置一致
//        Swagger2MarkupConverter.from("src/docs/asciidoc/generated" + "/swagger.json")
//                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
//                .withExamples("src/docs/asciidoc/generated")
//                .build()
//                .intoFolder("src/docs/asciidoc/generated");// 输出
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from("src/docs/asciidoc/generated/swagger.json")
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./docs/asciidoc/generated"));

    }



}