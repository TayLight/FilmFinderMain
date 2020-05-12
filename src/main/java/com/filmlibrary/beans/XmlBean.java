package com.filmlibrary.beans;

import criteriongenerated.Criterion;
import criteriongenerated.ObjectCriterion;
import generated.EntityXml;
import generated.Result;
import org.w3c.dom.Document;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.io.File;
import java.util.List;

@Local
public interface XmlBean {

    Result fromXmlFileToEntity(File file);

    File convertEntityToXmlFile(Result result);

    File convertCriterionToXmlFile(ObjectCriterion objectCriterion);

    ObjectCriterion fromXmlFileToCriterion(File file);

    public Result fromXmlNodeToEntity(Document doc);

    public ObjectCriterion fromNodeToCriterion(Document doc);

    public Document convertCriterionToNode(ObjectCriterion objectCriterion);

    public Document convertEntityToNode(Result result);
}
