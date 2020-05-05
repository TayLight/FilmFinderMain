package com.filmlibrary.beans;

import criteriongenerated.Criterion;
import criteriongenerated.ObjectCriterion;
import generated.EntityXml;
import generated.Result;

import java.io.File;
import java.util.List;

public interface XmlBean {

    Result fromXmlToObject(File file);

    File convertEntityToXml(EntityXml entity);

    File convertCriterionToXml(List<Criterion> criterionList, String type);

    ObjectCriterion fromXmlToCriterion(File file);
}
