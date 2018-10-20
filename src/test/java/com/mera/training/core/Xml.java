package com.mera.training.core;

import org.testng.annotations.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Xml {


    private String parse() {
        final String fileName = "src/test/resources/xml/simple_xml.xml";
        final String[] result = {null};
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("left_bridge")) {
                        name = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (name) {
                        String s = new String(ch, start, length);
                        System.out.println("left_bridge: " + s);
                        name = false;
                        result[0] = s;
                    }
                }
            };
            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result[0];
    }


    @Test
    public void testSimpleXml() {
        String bridge = parse();
        String[] split = bridge.split("-");
        System.out.println(Integer.parseInt(split[0]) + 1 + "-" + split[1]);
    }

}
