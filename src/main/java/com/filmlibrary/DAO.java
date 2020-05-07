package com.filmlibrary;

import com.filmlibrary.beans.PersonXmlBean;
import com.filmlibrary.entities.EntityDB;
import org.w3c.dom.Document;
import com.filmlibrary.entities.Film;
import com.filmlibrary.entities.Person;
import criteriongenerated.Criterion;
import criteriongenerated.CriterionListType;
import criteriongenerated.ObjectCriterion;
import generated.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DAO {
    private Connection connection;

    public DAO() {
        connection = DBUtil.getConnection();
    }

    public void addEntity(EntityDB entity) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO ").append(entity.getTableName()).append("(");
            for (int i = 1; i < entity.getColumns().size() - 1; i++) {
                query.append(entity.getColumns().get(i));
                query.append(",");
            }
            query.append(entity.getColumns().get(entity.getColumns().size() - 1)).append(") values (");
            for (int i = 0; i < entity.getColumns().size() - 2; i++) {
                query.append("?,");
            }
            query.append("?)");
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(query));
            preparedStatement = entity.setDataAdd(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEntity(File fileXml) {
        try {
            PersonXmlBean personXmlBean = new PersonXmlBean();
            EntityXml entity = personXmlBean.fromXmlFileToEntity(fileXml);
            StringBuilder query = new StringBuilder();
            List<String> list = entity.getColumns().getColumn();
            query.append("INSERT INTO ").append(entity.getTable()).append("(");
            for (int i = 1; i < list.size() - 1; i++) {
                query.append(list.get(i));
                query.append(",");
            }
            query.append(list.get(list.size() - 1)).append(") values (");
            for (int i = 0; i < list.size() - 2; i++) {
                query.append("?,");
            }
            query.append("?)");
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(query));
            preparedStatement = entity.setDataAdd(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEntity(int id, EntityDB entity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " + entity.getTableName() + " where " + entity.getColumns().get(0) + "=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEntity(File criterionFile) {
        try {
            PersonXmlBean personXmlBean = new PersonXmlBean();
            ObjectCriterion criterion = personXmlBean.fromXmlFileToCriterion(criterionFile);
            List<Criterion> criterionList = criterion.getCriterions().getPerson();
            String type = criterion.getType();
            int id = Integer.parseInt(criterionList.get(0).getValue());
            EntityFactory ef = new EntityFactory();
            EntityXml entity;
            if (type.equals("film")) {
                entity = ef.createFilm();
            } else if (type.equals("person")) {
                entity = ef.createPerson();
            } else {
                entity = ef.createSerial();
            }
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " + entity.getTable() + " where " + entity.getColumns().getColumn().get(0) + "=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEntity(EntityDB entityDB) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("update " + entityDB.getTableName() + " set ");
            for (int i = 1; i < entityDB.getColumns().size() - 1; i++) {
                query.append(entityDB.getColumns().get(i) + "=?,");
            }
            query.append(entityDB.getColumns().get(entityDB.getColumns().size() - 1) + "=? where " + entityDB.getColumns().get(0) + "=?");
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(query));
            preparedStatement = entityDB.setDataUpdate(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEntity(File criterionFile) {
        try {
            PersonXmlBean personXmlBean = new PersonXmlBean();
            ObjectCriterion criterion = personXmlBean.fromXmlFileToCriterion(criterionFile);
            List<Criterion> criterionList = criterion.getCriterions().getPerson();
            String type = criterion.getType();
            int id = Integer.parseInt(criterionList.get(0).getValue());
            EntityFactory ef = new EntityFactory();
            EntityXml entity;
            if (type.equals("film")) {
                entity = ef.createFilm();
            } else if (type.equals("person")) {
                entity = ef.createPerson();
            } else {
                entity = ef.createSerial();
            }
            StringBuilder query = new StringBuilder();
            query.append("update " + entity.getTable() + " set ");
            for (int i = 1; i < entity.getColumns().getColumn().size() - 1; i++) {
                query.append(entity.getColumns().getColumn().get(i) + "=?,");
            }
            query.append(entity.getColumns().getColumn().get(entity.getColumns().getColumn().size() - 1) + "=? where " + entity.getColumns().getColumn().get(0) + "=?");
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(query));
            preparedStatement = entity.setDataUpdate(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<EntityDB> searchEntity(String column, String searchItem, EntityDB entityDB) {
        ArrayList<EntityDB> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + entityDB.getTableName() + " WHERE " + column + " = ?");
            if (tryParse(searchItem, "integer")) {
                preparedStatement.setInt(1, Integer.parseInt(searchItem));
            } else if (tryParse(searchItem, "double")) {
                preparedStatement.setDouble(1, Double.parseDouble(searchItem));
            } else {
                preparedStatement.setString(1, searchItem);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(getEntity(resultSet, entityDB));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }


    public File searchEntity(File criterionFile) {
        ArrayList<EntityXml> entities = new ArrayList<>();
        PersonXmlBean personXmlBean = new PersonXmlBean();
        ObjectCriterion criterion = personXmlBean.fromXmlFileToCriterion(criterionFile);
        List<Criterion> criterionList = criterion.getCriterions().getPerson();
        String type = criterion.getType();
        EntityFactory ef = new EntityFactory();
        EntityXml entity;
        if (type.equals("film")) {
            entity = ef.createFilm();
        } else if (type.equals("person")) {
            entity = ef.createPerson();
        } else {
            entity = ef.createSerial();
        }
        String column = criterionList.get(0).getValue();
        String searchItem = criterionList.get(1).getValue();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + entity.getTable() + " WHERE " + column + " = ?");
            if (tryParse(searchItem, "integer")) {
                preparedStatement.setInt(1, Integer.parseInt(searchItem));
            } else if (tryParse(searchItem, "double")) {
                preparedStatement.setDouble(1, Double.parseDouble(searchItem));
            } else {
                preparedStatement.setString(1, searchItem);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(getEntity(resultSet, entity));
            }
            Result result = new Result();
            if (entity.getClass() == PersonType.class) {
                PersonListType personListType = new PersonListType();
                personListType.setArray(entities);
                result.setPersons(personListType);
            } else if (entity.getClass() == FilmType.class) {
                FilmListType filmListType = new FilmListType();
                filmListType.setArray(entities);
                result.setFilms(filmListType);
            } else {
                SerialListType serialListType = new SerialListType();
                serialListType.setArray(entities);
                result.setSerials(serialListType);
            }
            return personXmlBean.convertEntityToXmlFile(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean tryParse(String value, String type) {
        try {
            switch (type) {
                case "integer":
                    Integer.parseInt(value);
                    return true;
                case "double":
                    Double.parseDouble(value);
                    return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public EntityDB getEntity(ResultSet resultSet, EntityDB
            entityDB) {
        return entityDB.getEntity(resultSet);
    }

    public ArrayList<EntityDB> getAllEntity(EntityDB entityDB) {
        ArrayList<EntityDB> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from " + entityDB.getTableName() + "");
            while (rs.next()) {
                entities.add(getEntity(rs, entityDB));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public EntityXml getEntity(ResultSet resultSet, EntityXml
            entityXml) {
        EntityXml test = entityXml.getEntity(resultSet);
        return entityXml.getEntity(resultSet);

    }

    public File getAllEntity(EntityXml entityXml) {
        List<EntityXml> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from " + entityXml.getTable() + "");
            while (rs.next()) {
                entities.add(getEntity(rs, entityXml));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PersonXmlBean personXmlBean = new PersonXmlBean();
        Result result = new Result();
        if (entityXml.getClass() == PersonType.class) {
            PersonListType personListType = new PersonListType();
            personListType.setArray(entities);
            result.setPersons(personListType);
        } else if (entityXml.getClass() == FilmType.class) {
            FilmListType filmListType = new FilmListType();
            filmListType.setArray(entities);
        } else {
            SerialListType serialListType = new SerialListType();
            serialListType.setArray(entities);
            result.setSerials(serialListType);
        }
        return personXmlBean.convertEntityToXmlFile(result);
    }

    public EntityDB getEntityById(int entityId, EntityDB entityDB) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from " + entityDB.getTableName() + " where " + entityDB.getColumns().get(0) + "=?");
            preparedStatement.setInt(1, entityId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                entityDB = entityDB.getEntity(rs);
            }
            return entityDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getEntityById(File criterionFile) {
        try {
            PersonXmlBean personXmlBean = new PersonXmlBean();
            ObjectCriterion criterion = personXmlBean.fromXmlFileToCriterion(criterionFile);
            List<Criterion> criterionList = criterion.getCriterions().getPerson();
            String type = criterion.getType();
            EntityFactory ef = new EntityFactory();
            EntityXml entity;
            if (type.equals("film")) {
                entity = ef.createFilm();
            } else if (type.equals("person")) {
                entity = ef.createPerson();
            } else {
                entity = ef.createSerial();
            }
            int entityId = Integer.parseInt(criterionList.get(0).getValue());
            PreparedStatement preparedStatement = connection.prepareStatement("select * from " + entity.getTable() + " where " + entity.getColumns().getColumn().get(0) + "=?");
            preparedStatement.setInt(1, entityId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                entity = entity.getEntity(rs);
            }
            Result result = new Result();
            result.setEntity(entity);
            return personXmlBean.convertEntityToXmlFile(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EntityDB getTopEntity(EntityDB entityDB) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from " + entityDB.getTableName() + " order by id_" + entityDB.getTableName() + " desc limit 1");
            if (rs.next()) {
                entityDB = entityDB.getEntity(rs);
            }
            return entityDB;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getTopEntity(File criterionFile) {
        PersonXmlBean personXmlBean = new PersonXmlBean();
        ObjectCriterion criterion = personXmlBean.fromXmlFileToCriterion(criterionFile);
        String type = criterion.getType();
        EntityFactory ef = new EntityFactory();
        EntityXml entity;
        if (type.equals("film")) {
            entity = ef.createFilm();
        } else if (type.equals("person")) {
            entity = ef.createPerson();
        } else {
            entity = ef.createSerial();
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from " + entity.getTable() + " order by id_" + entity.getTable() + " desc limit 1");
            if (rs.next()) {
                entity = entity.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setEntity(entity);
        return personXmlBean.convertEntityToXmlFile(result);
    }

    public ArrayList<EntityDB> getProjectsByPerson(String projectType, String position, int entityId, EntityDB entityDB) {
        ArrayList<EntityDB> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select distinct * " +
                    "from " + projectType + " " +
                    "where id_" + projectType + " in " +
                    "      (select id_" + projectType +
                    "       from " + projectType + "_person " +
                    "       where id_position in " +
                    "             (select id_position " +
                    "              from position " +
                    "              where name_position = ?) " +
                    "         and id_person = ?) ");
            preparedStatement.setString(1, position);
            preparedStatement.setInt(2, entityId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(getEntity(resultSet, entityDB));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public ArrayList<EntityDB> getPersonByProject(String projectType, String position, int entityId, EntityDB entityDB) {
        ArrayList<EntityDB> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select distinct * " +
                    "from person " +
                    "where id_person in " +
                    "      (select id_person " +
                    "       from " + projectType + "_person" +
                    "       where id_position in (select id_position" +
                    "              from position" +
                    "              where name_position = ?) and id_" + projectType + " = ?)");
            preparedStatement.setString(1, position);
            preparedStatement.setInt(2, entityId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(getEntity(resultSet, entityDB));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void setProjectToPerson(String projectType, int projectId, int personId, int positionId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into " + projectType + "_person " +
                    "values (?, ?, ?) ");
            preparedStatement.setInt(1, projectId);
            preparedStatement.setInt(2, personId);
            preparedStatement.setInt(3, positionId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNumOfProjects(String projectType, int personId) {
        int numOfProjects = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*)" +
                    "from (select distinct id_person, id_" + projectType + " from " + projectType + "_person where id_person = ?)" +
                    " as numOfProjects");
            preparedStatement.setInt(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                numOfProjects = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfProjects;
    }

    public static void main(String[] arg) {
        DAO dao = new DAO();
        EntityFactory ef = new EntityFactory();
        PersonXmlBean personXmlBean = new PersonXmlBean();
        Criterion criterion1 = new Criterion();
        criterion1.setNameCriterion("first_name");
        criterion1.setValue("Леонардо");
        Criterion criterion2 = new Criterion();
        criterion2.setNameCriterion("country");
        criterion2.setValue("США");
        LinkedList<Criterion> criteria = new LinkedList<>();
        CriterionListType criterionListType = new CriterionListType();
        criterionListType.setPerson(criteria);
        criteria.add(criterion1);
        criteria.add(criterion2);
        Document document = personXmlBean.convertCriterionToNode(criteria, "person");
        Document document1 = dao.searchEntityByCriterion(document);
        Result result = personXmlBean.fromXmlNodeToEntity(document1);
        personXmlBean.convertEntityToXmlFile(result);
        //Результат смотреть тут src\main\java\com\filmlibrary\beans\xml\entity.xml
    }

    public Document searchEntityByCriterion(Document document) {
        PersonXmlBean personXmlBean = new PersonXmlBean();
        ObjectCriterion criteria = personXmlBean.fromNodeToCriterion(document);
        String type = criteria.getType(); // Значение типа будет название таблицы в какой искать
        List<Criterion> criterionList = criteria.getCriterions().getPerson(); // Список критериев
        ArrayList<EntityXml> entitiesXml = new ArrayList<>(); //Итоговый список сущностей

        //Todo Тут может быть ваш алгоритм
        //В каждой сущность с окончанием на Type,
        // есть количество столбцом и их названия по очереди,
        // как и в обычных наших сущностях

        EntityFactory ef = new EntityFactory();
        EntityXml entityXml;
        if (type.equals("film")) {
            entityXml = ef.createFilm();
        } else if (type.equals("person")) {
            entityXml = ef.createPerson();
        } else {
            entityXml = ef.createSerial();
        }
        try {
            StringBuilder sqlRequest = new StringBuilder("SELECT * FROM " + entityXml.getTable() + " WHERE ");
            for (int i = 0; i < criterionList.size(); i++) {
                if (i != criterionList.size() - 1)
                    sqlRequest.append(criterionList.get(i).getNameCriterion()).append(" = ? AND ");
                else
                    sqlRequest.append(criterionList.get(i).getNameCriterion()).append(" = ?");
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest.toString());

            for (int i = 0; i < criterionList.size(); i++) {
                if (tryParse(criterionList.get(i).getValue(), "integer")) {
                    preparedStatement.setInt(i + 1, Integer.parseInt(criterionList.get(i).getValue()));
                } else if (tryParse(criterionList.get(i).getValue(), "double")) {
                    preparedStatement.setDouble(i + 1, Double.parseDouble(criterionList.get(i).getValue()));
                } else {
                    preparedStatement.setString(i + 1, criterionList.get(i).getValue());
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entitiesXml.add(getEntity(resultSet, entityXml));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Result result = new Result();
        if (type.equals("film")) {
            FilmListType filmListType = new FilmListType();
            filmListType.setArray(entitiesXml);
            result.setEntity(filmListType);
        } else if (type.equals("serial")) {
            SerialListType serialListType = new SerialListType();
            serialListType.setArray(entitiesXml);
            result.setEntity(serialListType);
        } else {
            PersonListType personListType = new PersonListType();
            personListType.setArray(entitiesXml);
            result.setEntity(personListType);
        }
        return personXmlBean.convertEntityToNode(result);
    }
}