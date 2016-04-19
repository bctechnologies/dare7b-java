package com.example;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

public class TransformerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_sample1() throws Exception {
        String result = transformSample("/sample1.xml");
        String expected = "<document>" +
                "<item><name>B</name><score>0.5</score></item>" +
                "<item><name>A</name><score>0.8</score></item>" +
                "</document>";
        assertEquals(expected, result);
    }

    @Test
    public void test_sample2() throws Exception {
        String result = transformSample("/sample2.xml");
        String expected = "<document>" +
                "<item><name>B</name><score>0.1</score></item>" +
                "<item><name>A</name><score>0.2</score></item>" +
                "<item><name>D</name><score>0.6</score></item>" +
                "<item><name>C</name><score>0.9</score></item>" +
                "</document>";
        assertEquals(expected, result);
    }

    @Test
    public void test_sample3() throws Exception {
        String result = transformSample("/sample3.xml");
        String expected = "<document>" +
                "<item><name>D</name><score>0.0</score></item>" +
                "<item><name>E</name><score>0.1</score></item>" +
                "<item><name>H</name><score>0.2</score></item>" +
                "<item><name>B</name><score>0.3</score></item>" +
                "<item><name>F</name><score>0.4</score></item>" +
                "<item><name>G</name><score>0.5</score></item>" +
                "<item><name>C</name><score>0.7</score></item>" +
                "<item><name>A</name><score>0.8</score></item>" +
                "</document>";
        assertEquals(expected, result);
    }

    private String transformSample(String sample) throws Exception {
        Transformer transformer = new Transformer();
        try (InputStream input = TransformerTest.class.getResourceAsStream(sample)) {
            try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                transformer.transform(input, output);
                output.flush();
                return output.toString("UTF-8");
            }
        }
    }

}
