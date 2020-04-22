package com.filmlibrary.beans;

import generated.Result;

public interface XmlBean {

    Result fromXmlToObject(String filePath);

    void convertObjectToXml(Result person, String filePath);
}
