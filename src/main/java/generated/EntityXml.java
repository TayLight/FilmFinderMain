package generated;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.List;

public interface EntityXml {

    String getTable();

    BigInteger getCountColumns();

    ColumnsType getColumns();

    EntityXml getEntity(ResultSet resultSet);

    void setArray(List<EntityXml> entity);
}
