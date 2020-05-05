package generated;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EntityXml {

    String getTable();

    BigInteger getCountColumns();

    ColumnsType getColumns();

    PreparedStatement setDataAdd(PreparedStatement preparedStatement) throws SQLException;

    PreparedStatement setDataUpdate(PreparedStatement preparedStatement) throws SQLException;

    EntityXml getEntity(ResultSet resultSet);

    void setArray(List<EntityXml> entity);
}
