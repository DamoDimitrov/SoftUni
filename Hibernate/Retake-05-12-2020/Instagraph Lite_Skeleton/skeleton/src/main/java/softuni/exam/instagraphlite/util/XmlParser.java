package softuni.exam.instagraphlite.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <O> Object parseXml(Class<O> objectClass, String filePath) throws JAXBException;

    <O> void exportXml(O object, Class<O> objectClass, String filePath) throws JAXBException;
}
