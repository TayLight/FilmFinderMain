package com.filmlibrary.beans;

import criteriongenerated.Criterion;
import criteriongenerated.ObjectCriterion;
import generated.EntityXml;
import generated.Result;

import java.util.List;

public interface XmlBean {

    Result fromXmlToObject();

    void convertEntityToXml(EntityXml entity);

    void convertCriterionToXml(List<Criterion> criterionList, String type);

    ObjectCriterion fromXmlToCriterion();
}
