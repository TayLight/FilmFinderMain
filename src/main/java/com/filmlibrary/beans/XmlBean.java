package com.filmlibrary.beans;

import criteriongenerated.Criterion;
import criteriongenerated.ObjectCriterion;
import generated.EntityXml;
import generated.Result;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.io.File;
import java.util.List;

@Local
public interface XmlBean {

    Result fromXmlToObject(File file);

    File convertEntityToXml(EntityXml entity);

    File convertCriterionToXml(List<Criterion> criterionList, String type);

    ObjectCriterion fromXmlToCriterion(File file);
}
